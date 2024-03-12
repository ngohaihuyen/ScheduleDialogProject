package com.example.projectexample.librarymanage.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.projectexample.R;
import com.example.projectexample.librarymanage.callback.OnCategoryCallback;

public class AddCategoryDialog extends Dialog implements View.OnClickListener {

    private AppCompatEditText categoryNameEdt, idEdt;
    private AppCompatButton buttonAdd, buttonCancel;

    private OnCategoryCallback categoryCallback;

    public AddCategoryDialog(Context context) {
            super(context);
        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.add_category_dialog);

            categoryNameEdt = findViewById(R.id.name_category_edt);
            idEdt = findViewById(R.id.id_category_edt);
            buttonAdd = findViewById(R.id.add_btn);
            buttonCancel = findViewById(R.id.cancel_btn);

            buttonAdd.setOnClickListener(this);
            buttonCancel.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

        }

    public void setCategoryCallback(OnCategoryCallback callback) {
        this.categoryCallback = callback;
    }
}
