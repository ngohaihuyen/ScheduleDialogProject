package com.example.projectexample.filesample;

import static android.os.Build.VERSION.SDK_INT;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.projectexample.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileSampleActivity extends AppCompatActivity {
    AppCompatButton requestBtn, createFileBtn, readFileBtn, writeFileBtn;
    AppCompatTextView resultTxt;
    String TAG = "ManhNQ";

    String fileName = "TestFile140324.txt";
    String fileName2 = "TestFile140324-2.txt";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_sample_activity);
        initViews();
    }

    private void initViews() {
        requestBtn = findViewById(R.id.request_btn);
        createFileBtn = findViewById(R.id.create_file_btn);
        readFileBtn = findViewById(R.id.read_file_btn);
        writeFileBtn = findViewById(R.id.write_file_btn);
        resultTxt = findViewById(R.id.result_img);

        requestBtn.setOnClickListener(v -> {
            requestPermission();
        });

        createFileBtn.setOnClickListener(v -> {
            boolean result = createFile();
            Log.d(TAG, "initViews: create file = " + result);

        });

        readFileBtn.setOnClickListener(v -> {
            String result = readFile2();

            resultTxt.setText(result);
        });

        writeFileBtn.setOnClickListener(v -> {
            writeFile2();
        });


    }

    private void writeFile() {
        try {
            String content = getString(R.string.content_article);

            File file = getNewFile(fileName);
            FileOutputStream outputStream = new FileOutputStream(file);

            outputStream.write(content.getBytes());

            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFile() {
        try {
            String result = "";
            File file = getNewFile(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);

            byte[] buff = new byte[1024];

            int len = fileInputStream.read(buff);
            while (len > -1) {
                result += new String(buff, 0, len);
                len = fileInputStream.read(buff);
            }
            fileInputStream.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private void writeFile2() {
        try {
            String content = getString(R.string.content_article_2);

            File file = getNewFile(fileName2);
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.seek(6);
            raf.write("9999".getBytes());
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readFile2() {
        try {
            String result = "";

            File file = getNewFile(fileName2);
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            long cursorPoint = raf.getFilePointer();

            while (cursorPoint < file.length()) {
                String lineContent = raf.readLine();
                if (lineContent == null) {
                    return result;
                }
                Log.d(TAG, "readFile2: " + lineContent);
                result += lineContent;
            }
            raf.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private void printFileInfo() {
        try {
            File downloadFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

            Log.d(TAG, "handleFile: getAbsolutePath=" + downloadFolder.getAbsolutePath());
            Log.d(TAG, "handleFile: getPath=" + downloadFolder.getPath());
            Log.d(TAG, "handleFile: length=" + downloadFolder.length());

            File[] childrenFiles = downloadFolder.listFiles();
            for (int i = 0; i < childrenFiles.length; i++) {
                File file = childrenFiles[i];
                Log.d(TAG, "info file: " + file.getAbsolutePath());
            }
            String newPath = downloadFolder.getPath() + "/test2.txt";
            File newFile = new File(newPath);
            if (!newFile.exists()) {
                boolean result = newFile.mkdirs();
                Log.d(TAG, "create new file: " + result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean createFile() {
        try {
            return getNewFile(fileName) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    File getNewFile(String subPath) {
        try {
            File downloadFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

            String newPath = downloadFolder.getPath() + File.separator + subPath;

            Log.d(TAG, "getNewFile: " + newPath);

            File newFile = new File(newPath);

            if (!newFile.exists()) {
                boolean result = newFile.createNewFile();
                if (result) {
                    return newFile;
                } else {
                    return null;
                }
            }
            return newFile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
}
