package com.example.projectexample.threadsample;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.projectexample.R;

public class ThreadActivitySample extends AppCompatActivity {
    private AppCompatButton btnTest;
    AppCompatTextView appCompatTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.thread_activity_main);
        initViews();

    }

    private void initViews() {
        btnTest = findViewById(R.id.test_btn);
        appCompatTextView = findViewById(R.id.test_txt);
        btnTest.setOnClickListener(v -> {
            runOnMain();
        });
    }

    private void runOnMain() {
        try {
            int counter = 0;
            while (counter < 10000000) {
                Log.d("ManhNQ", "runOnMain: "+counter);
                Thread.sleep(500);
                counter++;
                appCompatTextView.setText(""+counter);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
