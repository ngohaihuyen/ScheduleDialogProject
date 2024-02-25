package com.example.projectexample.shared;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.projectexample.R;

public class SharedPreferencesActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton saveBtn, readBtn;
    private AppCompatTextView resultTxt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        initViews();
        initClickEvents();
    }

    private void initClickEvents() {
        saveBtn.setOnClickListener(this);
        readBtn.setOnClickListener(this);
    }

    private void initViews() {
        saveBtn = findViewById(R.id.save_btn);
        readBtn = findViewById(R.id.read_btn);
        resultTxt = findViewById(R.id.result_txt);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.save_btn) {
            //Save
            SharedPreferences sharedPreferences = getSharedPreferences("ProjectSample", Context.MODE_PRIVATE);
            SharedPreferences.Editor shareEditor = sharedPreferences.edit();
            shareEditor.putString("USERNAME", "MANH");
            shareEditor.putString("PASSWORD", "123456");
            shareEditor.commit();

        } else if (v.getId() == R.id.read_btn) {
            SharedPreferences sharedPreferences = getSharedPreferences("ProjectSample", Context.MODE_PRIVATE);
            String name = sharedPreferences.getString("USERNAME","m");
            String pass = sharedPreferences.getString("PASSWORD","-1");


            resultTxt.setText(name);
            //read
        }
    }
}
