package com.example.projectexample.studentstorage.model;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ClassItem {
    private int id;
    private String name;
    private ArrayList<Student> students;

    public ClassItem(int id, String name, ArrayList<Student> students) {
        this.id = id;
        this.students = students;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ClassItem) {
            return ((ClassItem) obj).getId() == id;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Class name :"+name +"    student count: "+students.size()+"\n";
    }
}
