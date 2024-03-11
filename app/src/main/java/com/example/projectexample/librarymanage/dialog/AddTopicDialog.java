package com.example.projectexample.librarymanage.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.projectexample.librarymanage.callback.OnTopicCallback;

public class AddTopicDialog extends Dialog implements View.OnClickListener {

    private AppCompatEditText editTextTopicName;
    private AppCompatButton buttonAdd, buttonCancel;
    private OnTopicCallback callback;

    public AddTopicDialog(Context context) {
            super(context);
        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //setContentView(R.layout.);

            /*editTextTopicName = findViewById(R.id.);
            buttonAdd = findViewById(R.id.);
            buttonCancel = findViewById(R.id.);

            buttonAdd.setOnClickListener(this);
            buttonCancel.setOnClickListener(this);*/
        }

        public void setCallback(OnTopicCallback callback) {
            this.callback = callback;
        }

        @Override
        public void onClick(View v) {

        }
}
