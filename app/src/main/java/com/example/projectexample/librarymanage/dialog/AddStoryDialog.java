package com.example.projectexample.librarymanage.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.projectexample.librarymanage.callback.OnStoryCallback;

public class AddStoryDialog extends Dialog implements View.OnClickListener {
    private AppCompatEditText editTextStoryName, editTextStoryContent;
    private AppCompatButton buttonAdd, buttonCancel;
    private OnStoryCallback callback;

    public AddStoryDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.);

        editTextStoryName = findViewById(R.id.);
        editTextStoryContent = findViewById(R.id.);
        buttonAdd = findViewById(R.id.);
        buttonCancel = findViewById(R.id.);

        buttonAdd.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);*/
    }

    public void setCallback(OnStoryCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onClick(View v) {

    }
}
