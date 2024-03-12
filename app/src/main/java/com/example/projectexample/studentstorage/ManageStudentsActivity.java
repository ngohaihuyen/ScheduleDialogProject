package com.example.projectexample.studentstorage;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.projectexample.R;
import com.example.projectexample.studentstorage.model.ClassItem;
import com.example.projectexample.studentstorage.model.Student;

public class ManageStudentsActivity extends AppCompatActivity implements View.OnClickListener {


    private AppCompatButton addClass, addStudent;
    private AppCompatTextView resultTxt;
    private SchoolManager manager;

    private OnStudentCallback callbackStudent = new OnStudentCallback()  {
        @Override
        public void onAddStudent(Student student) {
            manager.addStudent(student);

            resultTxt.setText(manager.getArrClass().toString());
        }
    };

    private OnClassCallback callbackClass = new OnClassCallback() {
        @Override
        public void onAddClass(ClassItem classItem) {
            manager.addClass(classItem);

            resultTxt.setText(manager.getClass().toString());
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
            AddClassDialog addClassDialog = new AddClassDialog(this);
            addClassDialog.setCallback(callbackClass);
            addClassDialog.show();

        } else if (v.getId() == R.id.add_student_btn) {
            AddStudentDialog addStudentDialog = new AddStudentDialog(this);
            addStudentDialog.setCallback(callbackStudent);
            addStudentDialog.show();
        }
    }

}
