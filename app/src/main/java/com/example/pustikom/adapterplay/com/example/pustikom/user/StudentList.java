package com.example.pustikom.adapterplay.com.example.pustikom.user;

import java.util.ArrayList;

/**
 * Created by UCode on 10/21/2016.
 */

public class StudentList extends ArrayList<Student> {
    public static ArrayList<Student> studentList = new ArrayList<>();
    private static StudentList instance = new StudentList();


    public static StudentList getInstance() {
        return instance;
    }

    public static void setInstance(StudentList instance) {
        StudentList.instance = instance;
    }
    public void addStudent(Student student){
        student.setId(nextId());
        studentList.add(student);
    }
    public int nextId(){
        return studentList.size()+1;
    }

    public Student get(int index){
        Student student = studentList.get(index);
        return student;
    }

    public Student removeLast(){
        Student student = studentList.remove(studentList.size()-1);
        return student;
    }

    public Student set(int index, Student student){
        studentList.set(index, student);
        return student;
    }

    public Student remove(int index){
        Student student = studentList.remove(index);
        resetCounterId(index);
        return student;
    }

    public Student getLast(){
        Student student = studentList.get(studentList.size()-1);
        return student;
    }

    private void resetCounterId(int i){
        for (int j = i; j < studentList.size(); j++) {
            studentList.get(j).setId(j);
        }
    }
    public void addList(ArrayList<Student> students){
        studentList.addAll(students);
        resetCounterId(0);
    }
    public int count(){
        return studentList.size();
    }

    public void clearList(){
        studentList.clear();
    }


    public ArrayList<Student> getList(){
        return studentList;
    }
}
