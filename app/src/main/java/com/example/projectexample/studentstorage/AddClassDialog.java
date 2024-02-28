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
import com.example.projectexample.studentstorage.model.ClassItem;
import com.example.projectexample.studentstorage.model.Student;

import java.util.ArrayList;

public class AddClassDialog extends Dialog {

    private OnClassCallback callback;
    private EditText nameEditText, ageEditText, classEditText, idEdt;
    private Button cancelButton, addBtn;


    public AddClassDialog(@NonNull Context context) {
        super(context);
    }

    public AddClassDialog(@NonNull Context context, int themeResId) {
        super(context, R.style.ActivityDialogFullScreen);
    }

    protected AddClassDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    void setCallback(OnClassCallback event) {
        callback = event;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student_dialog);

        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        //findviewbyid

        nameEditText = findViewById(R.id.student_name_edt);
        ageEditText = findViewById(R.id.student_age_edt);
        classEditText = findViewById(R.id.class_edt);
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
                String className = getStringOf(classEditText);
                int id = getNumOf(idEdt);

                if (checkValidName(name)) {
                    ArrayList<Student> students = new ArrayList<>();
                    ClassItem classItem = new ClassItem(id, className, students);
                    if (callback != null) {
                        callback.onAddClass(classItem);
                    }

                    dismiss();
                } else {
                    showErrorDialog("Vui lòng nhập đầy đủ và hợp lệ thông tin");
                }
            }

            private String getStringOf(EditText edt) {
                return edt.getText().toString().trim();
            }

            private int getNumOf(EditText edt) {
                String value = edt.getText().toString();
                return Integer.parseInt(value);
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
                // show error dialog
            }
        });
    }
}