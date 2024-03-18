package com.example.projectexample.imagefile;

import static android.os.Build.VERSION.SDK_INT;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

    String fileName = "Silicon_valley_tilte.png";

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
                requestPermissions();
            }
        });

        readFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] data = readFile();
                if (data != null) {
                    Log.d(TAG, "read file successful");
                } else {
                    Log.d(TAG, "read file í failed");
                }
            }
        });

        writeFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeFile();
            }
        });
    }


    private byte[] readFile() {
        File file = getExistingFile();

        if (file != null) {

            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] data = new byte[(int) file.length()];
                fileInputStream.read(data);
                fileInputStream.close();
                return data;
            } catch (IOException e) {
                Log.e(TAG, "Error in reading file");
            }
        }
        return null;
    }

    private void writeFile() {
        File file = getExistingFile();
        if (file != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.close();
                Log.d(TAG, "Write file successful");
            } catch (IOException e) {
                Log.e(TAG, "Error writing file");
            }
        }
    }

    private File getExistingFile() {
        try {
            String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + fileName;
            File existingFile = new File(filePath);
            if (existingFile.exists()) {
                return existingFile;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void requestPermissions() {
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


    public void download(String url){
        //download to external storage
        //connect to url
        //read InputStream

        //get file to write
        //write to file

        //close all stream & url

    }

    public void showImageFromPath(String path){

    }

}
