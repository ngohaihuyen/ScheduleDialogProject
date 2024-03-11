package com.example.projectexample.studentstorage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projectexample.R;
import com.example.projectexample.studentstorage.model.Student;

public class AddStudentDialog extends Dialog {

    private OnStudentCallback callback;

    private EditText nameEditText, ageEditText, classEditText, idEdt;
    private Button cancelButton, addBtn;

    public AddStudentDialog(@NonNull Context context) {
        super(context);
    }

    public AddStudentDialog(@NonNull Context context, int themeResId) {
        super(context, R.style.ActivityDialogFullScreen);
    }

    protected AddStudentDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    void setCallback(OnStudentCallback event) {
        callback = event;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student_dialog);

        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        nameEditText = findViewById(R.id.student_name_edt);
        ageEditText = findViewById(R.id.student_age_edt);
        classEditText = findViewById(R.id.id_class_edt);
        idEdt = findViewById(R.id.id_edt);
        cancelButton = findViewById(R.id.cancel_btn);
        addBtn = findViewById(R.id.add_btn);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = getStringOf(nameEditText);
                int age = getNumOf(ageEditText);
                int className = getNumOf(classEditText);
                int id = getNumOf(idEdt);

                if (checkValidName(name)) {
                    Student student = new Student(id, name, age, className);
                    if (callback != null) {
                        callback.onAddStudent(student);
                    }

                    dismiss();
                } else {
                    showErrorDialog("Vui lòng nhập thông tin hợp lệ");
                }

                if (name.isEmpty() || age <= 0 || age >30 ) {
                    showErrorDialog("Vui lòng nhập đầy đủ thông tin");
                }

                Student student = new Student(id, name, age, className);
                if (callback != null) {
                    callback.onAddStudent(student);
                }

                dismiss();

            }

            private String getStringOf(EditText edt) {
                return edt.getText().toString().trim();
            }

            private int getNumOf(EditText edt) {
                String value = edt.getText().toString();
                if (isInteger(value)) {
                    return Integer.parseInt(value);
                } else {
                    return 0;
                }

            }
            private boolean isInteger(String str) {
                if (str == null || str.isEmpty()) {
                    return false;
                }
                for (int i = 0; i < str.length(); i++) {
                    if (!Character.isDigit(str.charAt(i))) {
                        return false;
                    }
                }
                return true;
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
        })
    ;}
}
