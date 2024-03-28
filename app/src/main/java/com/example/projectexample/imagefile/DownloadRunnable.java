package com.example.projectexample.imagefile;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadRunnable implements Runnable {
    private Context context;
    private String url;
    private OnDownloadListener listener;
    private Handler handler;

    public DownloadRunnable(Context context, String url, OnDownloadListener listener, Handler handler) {
        this.context = context;
        this.url = url;
        this.listener = listener;
        this.handler = handler;
    }


    String fileName = "Animal_lion.png";

    @Override
    public void run() {
        Log.d("ManhNQ", "run: " + url);

        downloadToExternalStorage(url);
    }

    private void downloadToExternalStorage(String url) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            URL imageurl = new URL(url);
            connection = (HttpURLConnection) imageurl.openConnection();
            connection.connect();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = connection.getInputStream();
                File file = getImageFile();

                int totalContent = connection.getContentLength();
                int currentPercent = 0;

                outputStream = new FileOutputStream(file);

                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                while (bytesRead != -1) {
                    currentPercent += bytesRead;
                    int percent = (int) ((currentPercent * 1f / totalContent) * 100);
                    handler.post(() -> listener.onDownloading(percent));

                    Log.d("ManhNQ", "downloadToExternalStorage: percent= " + currentPercent + "total=" + totalContent);
                    outputStream.write(buffer, 0, bytesRead);
                    bytesRead = inputStream.read(buffer);
                }

                outputStream.close();
                inputStream.close();
                connection.disconnect();
                //send notifier to activity
                handler.post(() -> listener.onDownloadCompleted());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getImageFile() {
        try {
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), fileName);
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
}
