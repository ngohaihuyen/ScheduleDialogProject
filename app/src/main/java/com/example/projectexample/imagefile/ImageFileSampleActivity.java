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
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.projectexample.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class ImageFileSampleActivity extends AppCompatActivity implements OnDownloadListener, OnCountDownListener {
    AppCompatButton requestBtn, downloadBtn, displayBtn;
    AppCompatImageView resultImg;
    AppCompatTextView percentTxt;
    String TAG = "ManhNQ";
    String fileName = "Animal_lion.png";
    String imageUrl = "https://cdn.firstcry.com/education/2022/11/26141737/Animal-Name-Starting-With-L-For-Kids.jpg";
    String imageUrl2 = "https://media.wired.com/photos/593261cab8eb31692072f129/master/pass/85120553.jpg";


    private ThreadManager threadManager;
//    private Handler handler = new Handler(Looper.getMainLooper());
//    private Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            Log.d(TAG, "run: "+Thread.currentThread().getName());
//            downloadToExternalStorage(imageUrl);
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    showImageFromPath();
//                }
//            });
//        }
//    };

//    private Thread thread = new Thread(runnable);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_file_activity);

        initViews();
    }

    private void initViews() {
        threadManager = new ThreadManager();

        threadManager.countDown(3,this);
        requestBtn = findViewById(R.id.request_btn);
        downloadBtn = findViewById(R.id.download_btn);
        resultImg = findViewById(R.id.result_img);
        displayBtn = findViewById(R.id.display_btn);
        percentTxt = findViewById(R.id.percent_txt);

        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermissions();
            }
        });

        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d(TAG, "click: "+Thread.currentThread().getName());
//                if (!thread.isAlive()) {
//                    thread.start();
//                }
                threadManager.downloadImage(getApplicationContext(), imageUrl2, ImageFileSampleActivity.this);
            }
        });

        displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageFromPath();
            }
        });

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

//    private void downloadToExternalStorage(String url) {
//        HttpURLConnection connection = null;
//        InputStream inputStream = null;
//        FileOutputStream outputStream = null;
//
//        try {
//            URL imageurl = new URL(url);
//            connection = (HttpURLConnection) imageurl.openConnection();
//            connection.connect();
//
//            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                inputStream = connection.getInputStream();
//                File file = getImageFile();
//                outputStream = new FileOutputStream(file);
//
//                byte[] buffer = new byte[1024];
//                int bytesRead = inputStream.read(buffer);
//                while (bytesRead != -1) {
//                    outputStream.write(buffer, 0, bytesRead);
//                    bytesRead = inputStream.read(buffer);
//                }
//
//                outputStream.close();
//                inputStream.close();
//                connection.disconnect();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private File getImageFile() {
        try {
            File file = new File(this.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), fileName);
            if (!file.exists()) {
                boolean isSuccess = file.createNewFile();
                if (isSuccess) {
                    return file;
                } else {
                    return null;
                }
            }
            return file;
        } catch (Exception e) {
            return null;
        }
    }

    public void showImageFromPath() {
        File file = getImageFile();

        if (file != null && file.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            resultImg.setImageBitmap(bitmap);
        } else {
            showAlertDialog(this, "lỗi", "hiển thị image file không thành công");

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

    @Override
    public void onDownloadCompleted() {
        Log.d(TAG, "onDownloadCompleted: ");
        showImageFromPath();
    }

    @Override
    public void onDownloading(int percent) {
        percentTxt.setText(String.valueOf(percent));
        Log.d(TAG, "onDownloading: "+percent);
    }

    @Override
    public void onUpdateTime(int time) {
        percentTxt.setText(String.valueOf(time));
    }

    @Override
    public void onTimeComplete() {
        percentTxt.setText("Complete");
    }

}

