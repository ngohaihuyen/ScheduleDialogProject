package com.example.projectexample.librarymanage.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.projectexample.R;
import com.example.projectexample.librarymanage.Story;
import com.example.projectexample.librarymanage.callback.OnStoryCallback;
import com.example.projectexample.studentstorage.model.Student;

public class AddStoryDialog extends Dialog  {
    private AppCompatEditText nameStrEdt, contentEdt, idEdt;
    private AppCompatButton addBtn, cancelBtn;
    private OnStoryCallback storyCallback;

    public AddStoryDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_story_dialog);

        nameStrEdt = findViewById(R.id.name_story_edt);
        contentEdt = findViewById(R.id.content_story_edt);
        idEdt = findViewById(R.id.id_story_edt);
        addBtn = findViewById(R.id. add_btn);
        cancelBtn = findViewById(R.id.cancel_btn);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = getStringOf(nameStrEdt);
                int id = getNumOf(idEdt);

                if (checkValidName(name)) {
                    Story story = new Story(id, name);
                    if (storyCallback != null) {
                        storyCallback.onAddStory(story);
                    }

                    dismiss();
                } else {
                    showErrorDialog("Vui lòng nhập thông tin hợp lệ");
                }
            }
        });

    }

    private void showErrorDialog(String s) {
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

    public void setStoryCallback(OnStoryCallback storyCallback) {
        this.storyCallback = storyCallback;
    }

}
