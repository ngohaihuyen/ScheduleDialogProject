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

import java.util.ArrayList;

public class AddClassDialog extends Dialog {

    private OnClassCallback callback;
    private EditText nameEditText, idEdt;
    private Button cancelBtn, addBtn;


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
        setContentView(R.layout.add_class_dialog);

        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        nameEditText = findViewById(R.id.name_category_edt);
        idEdt = findViewById(R.id.id_category_edt);
        cancelBtn = findViewById(R.id.cancel_btn);
        addBtn = findViewById(R.id.add_btn);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = getStringOf(nameEditText);
                int id = getNumOf(idEdt);

                if (name.isEmpty()) {
                    showErrorDialog("Vui lòng nhập đầy đủ thông tin");
                } else {
                    ClassItem classItem = new ClassItem(id, name, new ArrayList<>());
                    if (callback != null) {
                        callback.onAddClass(classItem);
                    }
                    dismiss();
                }
            }
        });
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
            }
}

