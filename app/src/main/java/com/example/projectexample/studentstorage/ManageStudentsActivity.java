package com.example.projectexample.studentstorage;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.projectexample.R;

import java.util.ArrayList;
import java.util.List;

public class ManageStudentsActivity extends AppCompatActivity implements View.OnClickListener, AddStudentDialog.OnOkClickListener {

    private List<StudentInfo> studentList;

    private LinearLayout classListLayout;
    private AppCompatButton addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_stored_student);

        classListLayout = findViewById(R.id.classlist_layout);
        addBtn = findViewById(R.id.add_btn_2);
        addBtn.setOnClickListener(this);

        studentList = new ArrayList<>();
        studentList.add(new StudentInfo("Class A", 2));
        studentList.add(new StudentInfo("Class B", 7));
        studentList.add(new StudentInfo("Class C", 10));

        updateClassList();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add_btn_2) {
            AddStudentDialog dialog = new AddStudentDialog(this, this);
            dialog.show();
        }
    }

    private void updateClassList() {

        for (int i = 0; i < studentList.size(); i++) {
            StudentInfo studentInfo = studentList.get(i);
            String className = studentInfo.getClassName();
            int studentCount = studentInfo.getStudentNumber();

            TextView textView = new TextView(this);
            textView.setText(className + ": " + studentCount);
            classListLayout.addView(textView);
        }
    }

    @Override
    public void onOkClicked(String name, String age, String className) {

        boolean found = false;
        for (int i = 0; i < studentList.size(); i++) {
            StudentInfo studentInfo = studentList.get(i);
            if (studentInfo.getClassName().equals(className)) {
                studentInfo.setStudentNumber(studentInfo.getStudentNumber() + 1);
                found = true;
                break;
            }
        }

        if (!found) {
            studentList.add(new StudentInfo(className, 1));
        }
        updateClassList();
    }
}
