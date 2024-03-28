package com.example.projectexample.imagefile;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadManager {
    private ExecutorService executor = Executors.newCachedThreadPool();
    private Handler handler = new Handler(Looper.getMainLooper());

    public void downloadImage(Context context, String url, OnDownloadListener listener) {
        executor.execute(new DownloadRunnable(context, url, listener, handler));
    }

    public void countDown(int count, OnCountDownListener listener) {
        executor.execute(new CountDownRunnable(count, listener, handler));
    }


}
