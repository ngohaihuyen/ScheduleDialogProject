package com.example.projectexample.librarymanage.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.projectexample.R;
import com.example.projectexample.librarymanage.callback.OnStoryCallback;

public class AddStoryDialog extends Dialog implements View.OnClickListener {
    private AppCompatEditText nameStrEdt, contentEdt, idEdt;
    private AppCompatButton buttonAdd, buttonCancel;
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
        buttonAdd = findViewById(R.id. add_btn);
        buttonCancel = findViewById(R.id.cancel_btn);

        buttonAdd.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
    }

    public void setStoryCallback(OnStoryCallback storyCallback) {
        this.storyCallback = storyCallback;
    }

    @Override
    public void onClick(View v) {

    }
}
