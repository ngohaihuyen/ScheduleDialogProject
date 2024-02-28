package com.example.projectexample.studentstorage;

import com.example.projectexample.studentstorage.model.ClassItem;
import com.example.projectexample.studentstorage.model.Student;

import java.util.ArrayList;

public class SchoolManager {
    private ArrayList<ClassItem> arrClass;

    public SchoolManager() {
        this.arrClass = new ArrayList<>();
    }

    ArrayList<ClassItem> getArrClass() {
        return arrClass;
    }

    Boolean addStudent(Student student) {
        ClassItem classItem = findClassById(student.getClassID());
        if (classItem != null) {
            ArrayList<Student> students = classItem.getStudents();

            if (!students.contains(student)) {
                if (students.size()>15) {
                    return false;
                }
                students.add(student);
                return true;
            }
        }
        return false;
    }

    Boolean addClass(ClassItem clazz) {
        if (arrClass.size() > 10) return false;
        if (!arrClass.contains(clazz)) {
            arrClass.add(clazz);
            return true;
        }
        return false;
    }

    Boolean deleteStudent(Student student) {
        return false;
    }

    ClassItem findClassById(int classId) {
        for (int i = 0; i < arrClass.size(); i++) {
            ClassItem item = arrClass.get(i);
            if (item.getId() == classId) {
                return item;
            }
        }
        return null;
    }
}
