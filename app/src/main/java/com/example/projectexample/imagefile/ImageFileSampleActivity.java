package com.example.projectexample.imagefile;

import static android.os.Build.VERSION.SDK_INT;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.projectexample.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageFileSampleActivity extends AppCompatActivity {
    AppCompatButton requestBtn, getfileBtn, readFileBtn, writeFileBtn;
    AppCompatTextView resultTxt;
    String TAG = "ManhNQ";

    String fileName ="Silicon_valley_tilte.png";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_file_activity);
        initViews();
    }

    private void initViews() {
        requestBtn = findViewById(R.id.request_btn);
        getfileBtn = findViewById(R.id.get_file_btn);
        readFileBtn = findViewById(R.id.read_file_btn);
        writeFileBtn = findViewById(R.id.write_file_btn);
        resultTxt = findViewById(R.id.result_txt);

        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
            }
        });

        readFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] imageData = readFile();
                if (imageData != null) {
                    Log.d(TAG, "Image read successfully");
                } else {
                    Log.d(TAG, "read image is failed");
                }
            }
        });

        writeFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] imageData = getImageData();

                if (imageData != null) {
                    writeFile(imageData);
                } else {
                    Log.d(TAG, "Failed to write image");
                }
            }
        });
    }

    private byte[] readFile() {
        try {
            File file = getExistingFile(fileName);
            if (file != null) {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] imageData = new byte[(int) file.length()];
                fileInputStream.read(imageData);
                fileInputStream.close();
                return imageData;
            } else {
                Log.d(TAG, "File not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeFile(byte[] imageData) {
        try {
            File file = getExistingFile(fileName);
            if (file != null) {
                FileOutputStream outputStream = new FileOutputStream(file);
                outputStream.write(imageData);
                outputStream.close();
                Log.d(TAG, "Image saved successfully");
            } else {
                Log.d(TAG, "File not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getExistingFile(String fileName) {
        String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + fileName;
        File existingFile = new File(filePath);
        if (existingFile.exists()) {
            return existingFile;
        }
        return null;
    }


    private void requestPermission() {
        if (SDK_INT >= Build.VERSION_CODES.R) {
            try {
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(String.format("package:%s", getApplicationContext().getPackageName())));
                startActivityForResult(intent, 2296);
            } catch (Exception e) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                startActivityForResult(intent, 2296);
            }
        }
    }

    private byte[] getImageData() {
        return null;
    }
}
