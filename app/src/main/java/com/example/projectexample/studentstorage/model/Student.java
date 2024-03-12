package com.example.projectexample.studentstorage.model;

import androidx.annotation.Nullable;

public class Student {
    private int studentId;
    private String name;
    private int age;
    private int classID;

    public Student(int studentId, String name, int age, int classID) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.classID = classID;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getClassID() {
        return classID;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Student) {
            return ((Student) obj).getStudentId() == studentId;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classID=" + classID +
                '}';
    }
}
