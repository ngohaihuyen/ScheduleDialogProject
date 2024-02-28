package com.example.projectexample.studentstorage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.projectexample.R;
import com.example.projectexample.studentstorage.model.ClassItem;
import com.example.projectexample.studentstorage.model.Student;

import java.util.ArrayList;

public class ManageStudentsActivity extends AppCompatActivity implements View.OnClickListener {


    private AppCompatButton addClass, addStudent;
    private AppCompatTextView resultTxt;
    private SchoolManager manager;

    private OnStudentCallback callback = new OnStudentCallback() {
        @Override
        public void onAddStudent(Student student) {
            manager.addStudent(student);

            resultTxt.setText(manager.getArrClass().toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_stored_student);
        manager = new SchoolManager();

        initViews();
        setClickEvents();
    }


    private void initViews() {
        addClass = findViewById(R.id.add_class_btn);
        addStudent = findViewById(R.id.add_student_btn);
        resultTxt = findViewById(R.id.result_txt);
    }

    private void setClickEvents() {
        addClass.setOnClickListener(this);
        addStudent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add_class_btn) {
            initClass();
        } else if (v.getId() == R.id.add_student_btn) {
            AddStudentDialog addStudentDialog = new AddStudentDialog(this);
            addStudentDialog.setCallback(callback);
            addStudentDialog.show();
        }
    }


    void initClass() {
        manager.addClass(new ClassItem(1, "class A", new ArrayList<>()));
        manager.addClass(new ClassItem(2, "class B", new ArrayList<>()));
        manager.addClass(new ClassItem(3, "class C", new ArrayList<>()));
        manager.addClass(new ClassItem(4, "class D", new ArrayList<>()));
        manager.addClass(new ClassItem(5, "class E", new ArrayList<>()));
    }

}
