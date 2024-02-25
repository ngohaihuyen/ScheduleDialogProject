package com.example.projectexample.studentstorage;

public class StudentInfo {
    private String className;
    private int studentNumber;

    public StudentInfo(String className, int studentCount) {
        this.className = className;
        this.studentNumber = studentCount;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
}
