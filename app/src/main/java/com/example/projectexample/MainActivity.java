package com.example.projectexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectexample.AntiVirrusActivity.AntiVirusActivity;
import com.example.projectexample.animation.AnimationActivity;
import com.example.projectexample.filesample.FileSampleActivity;
import com.example.projectexample.imagefile.ImageFileSampleActivity;
import com.example.projectexample.librarymanage.LibraryManageActivity;
import com.example.projectexample.scheduleactivity.ScheduleActivity;
import com.example.projectexample.shared.SharedPreferencesActivity;
import com.example.projectexample.studentstorage.ManageStudentsActivity;
import com.example.projectexample.threadsample.ThreadActivitySample;
import com.example.projectexample.triangle.TriangleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton animBtn, antivirusBtn, filesampleBtn, imageBtn, libraryBtn, scheduleBtn, sharedBtn, studentStorageBtn, threadBtn, triangleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        goToActivity();


    }

    private void goToActivity() {
        animBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnimationActivity.class);
                startActivity(intent);
            }
        });

        antivirusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AntiVirusActivity.class);
                startActivity(intent);
            }
        });

        filesampleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FileSampleActivity.class);
                startActivity(intent);
            }
        });

        imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageFileSampleActivity.class);
                startActivity(intent);
            }
        });

        libraryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LibraryManageActivity.class);
                startActivity(intent);
            }
        });

        scheduleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });

        sharedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SharedPreferencesActivity.class);
                startActivity(intent);
            }
        });

        studentStorageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManageStudentsActivity.class);
                startActivity(intent);
            }
        });

        threadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThreadActivitySample.class);
                startActivity(intent);
            }
        });

        triangleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TriangleActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        animBtn = findViewById(R.id.anim_btn);
        antivirusBtn = findViewById(R.id.antivirus_btn);
        filesampleBtn = findViewById(R.id.file_sample_btn);
        imageBtn = findViewById(R.id.image_file_btn);
        libraryBtn = findViewById(R.id.library_btn);
        scheduleBtn = findViewById(R.id.schedule_btn);
        sharedBtn = findViewById(R.id.shared_btn);
        studentStorageBtn = findViewById(R.id.student_storage_btn);
        threadBtn = findViewById(R.id.thread_btn);
        triangleBtn = findViewById(R.id.triangle_btn);
    }


    @Override
    public void onClick(View v) {
//            showAlertDiaLog();

//            showCustomDialog();


        }
}