package com.example.projectexample.imagefile;

import static android.os.Build.VERSION.SDK_INT;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.projectexample.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageFileSampleActivity extends AppCompatActivity {
    AppCompatButton requestBtn, downloadBtn, readFileBtn, writeFileBtn, displayBtn;
    AppCompatImageView resultImg;
    String TAG = "ManhNQ";
    String imageUrl = "https://cafebiz.cafebizcdn.vn/2018/3/23/photo-1-1521770925470754998831.jpg";
    String fileName = "Silicon_valley_tilte.png";
    DownloadManager downloadManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_file_activity);

        initViews();
    }

    private void initViews() {
        requestBtn = findViewById(R.id.request_btn);
        downloadBtn = findViewById(R.id.download_btn);
        readFileBtn = findViewById(R.id.read_file_btn);
        writeFileBtn = findViewById(R.id.write_file_btn);
        resultImg = findViewById(R.id.result_img);
        displayBtn = findViewById(R.id.display_btn);

        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermissions();
            }
        });

        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);

                Uri uri = Uri.parse(imageUrl);

                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                Long reference = downloadManager.enqueue(request);
                downloadToExternalStorage(imageUrl);
            }
        });

        /*readFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFile();
            }
        });

        writeFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeFile();
            }
        });*/
    }


    private void writeFile() {

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

    private void downloadToExternalStorage(String url) {
        // Tải xuống và ghi dữ liệu vào file
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            URL imageurl = new URL(url);
            connection = (HttpURLConnection) imageurl.openConnection();
            connection.connect();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = connection.getInputStream();
                File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), fileName);
                outputStream = new FileOutputStream(file);

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                // Tải xuống và ghi file thành công
                showAlertDialog(this, "success", "tải xuống và ghi hình ảnh thành công");
            } else {
                // Lỗi khi tải xuống hình ảnh
                showAlertDialog(this, "lỗi", "tải xuôống hình ảnh không thành công");
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Lỗi khi tải xuống hoặc ghi file
            showAlertDialog(this, "lỗi", "tải xuống hoặc ghi file không thành công");
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            connection.disconnect();
        }
    }

    private void showAlertDialog(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }


    public void showImageFromPath(String path){
            File imgFile = new File(path);
            if (imgFile.exists()) {
                Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                resultImg.setImageBitmap(bitmap);
            } else {
                showAlertDialog(this, "lỗi", "Hiển thị file không thành công");

            }
        }
    }

