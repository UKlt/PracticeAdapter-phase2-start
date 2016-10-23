package com.example.pustikom.adapterplay;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pustikom.adapterplay.com.example.pustikom.user.Student;
import com.example.pustikom.adapterplay.com.example.pustikom.user.StudentList;

/**
 * Created by UCode on 10/14/2016.
 */

public class AddStudentActivity extends AppCompatActivity {
    private EditText id_, name_, noreg_, phone_, mail_;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        id_ = (EditText) findViewById(R.id.edit_id);
        name_ = (EditText) findViewById(R.id.edit_nama);
        noreg_ = (EditText) findViewById(R.id.edit_nim);
        phone_ = (EditText) findViewById(R.id.edit_phone);
        mail_ = (EditText) findViewById(R.id.edit_email);
        setTitle("Add New Student");
        invalidateOptionsMenu();

        FloatingActionButton cancelButton = (FloatingActionButton) findViewById(R.id.cancelActionButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        FloatingActionButton saveButton = (FloatingActionButton) findViewById(R.id.saveActionButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    private void save() {
        int id = Integer.parseInt(id_.getText().toString());
        String name = name_.getText().toString();
        String noreg = noreg_.getText().toString();
        String mail = mail_.getText().toString();
        String phone = phone_.getText().toString();
        student = new Student(id, noreg, name, phone, mail);
        StudentList studentList = StudentList.getInstance();
        studentList.addStudent(student);
        Toast.makeText(getApplicationContext(), "Added Successfull", Toast.LENGTH_SHORT).show();
        finish();
    }


    }

