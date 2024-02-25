package com.example.projectexample.studentstorage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.example.projectexample.R;

public class AddStudentDialog extends Dialog {

    private OnOkClickListener onOkClickListener;
    private EditText nameEditText, ageEditText, classEditText;
    private Button cancelButton, okButton;

    public AddStudentDialog(@NonNull Context context, OnOkClickListener onOkClickListener) {
        super(context);
        this.onOkClickListener = onOkClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student_dialog);

        nameEditText = findViewById(R.id.student_name_edt);
        ageEditText = findViewById(R.id.student_age_edt);
        classEditText = findViewById(R.id.class_edt);
        cancelButton = findViewById(R.id.cancel_btn);
        okButton = findViewById(R.id.add_tv);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String age = ageEditText.getText().toString().trim();
                String className = classEditText.getText().toString().trim();

                if (checkValidName(name) && !age.isEmpty() && !className.isEmpty()) {
                    onOkClickListener.onOkClicked(name, age, className);
                    dismiss();
                } else {
                    showErrorDialog("Vui lòng nhập đầy đủ và hợp lệ thông tin");
                }
            }
        });
    }
    private boolean checkValidName(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z')) {
                return false;
            }
        }
        return true;
    }


    private void showErrorDialog(String message) {
    }

    public interface OnOkClickListener {
        void onOkClicked(String name, String age, String className);
    }
}