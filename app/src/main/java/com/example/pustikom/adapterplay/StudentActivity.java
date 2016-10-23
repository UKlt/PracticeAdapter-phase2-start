package com.example.pustikom.adapterplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pustikom.adapterplay.com.example.pustikom.adapter.StudentArrayAdapter;
import com.example.pustikom.adapterplay.com.example.pustikom.user.Student;
import com.example.pustikom.adapterplay.com.example.pustikom.user.StudentList;

import java.util.ArrayList;

/**
 * Created by pustikom on 07/10/16.
 */

public class StudentActivity extends AppCompatActivity {
    private StudentArrayAdapter studentArrayAdapter;
    private StudentList studentList;
    private ListView studentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        studentList = StudentList.getInstance();
        //ArrayList<Student> students = populateStudentDummies();
        //StudentArrayAdapter studentArrayAdapter = new StudentArrayAdapter(this,new ArrayList<Student>());
        ListView list_item = (ListView) findViewById(R.id.list_item);
        list_item.setAdapter(studentArrayAdapter);
        FloatingActionButton addButton = (FloatingActionButton)findViewById(R. id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, AddStudentActivity.class);
                startActivity(intent);
            }
        });


        studentListView = (ListView) findViewById(R.id.list_item);
        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), EditStudentActivity.class);
                Student student = studentList.get(position);
                intent.putExtra("StudentList", String.valueOf(student));
                startActivity(intent);
            }
        });

    }

    private void populateStudentDummies(){
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        studentArrayList.add(new Student("3145136188","TRI FEBRIANA SIAMI","0858xxxxxx","tri@mhs.unj.ac.id"));
        studentArrayList.add(new Student("3145136192","Ummu Kultsum","0813xxxxxx","ummu@mhs.unj.ac.id"));
        studentList.addList(studentArrayList);
        studentArrayAdapter = new StudentArrayAdapter(this,studentList.getList());
        studentListView.setAdapter(studentArrayAdapter);
    }

    @Override
    public void onResume(){
        super.onResume();
        TextView EmptyText =(TextView) findViewById(R.id.empty);
        studentListView.setEmptyView(EmptyText);
        if(studentList.count()==0) {
            studentArrayAdapter = new StudentArrayAdapter(this, new ArrayList<Student>());
            EmptyText.setText("No Student Found");
        } else{
            studentArrayAdapter = new StudentArrayAdapter(this, studentList.getList());
        }
        studentListView.setAdapter(studentArrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_student,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.create_dummy:
                populateStudentDummies();
                return true;
            case R.id.clear_list:
                StudentList.getInstance().clearList();
                studentArrayAdapter = new StudentArrayAdapter(this, new ArrayList<Student>());
                studentListView.setAdapter(studentArrayAdapter);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
