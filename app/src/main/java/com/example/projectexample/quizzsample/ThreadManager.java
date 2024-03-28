package com.example.projectexample.quizzsample;

import android.os.Handler;
import android.os.Looper;

import com.example.projectexample.imagefile.CountDownRunnable;
import com.example.projectexample.imagefile.OnCountDownListener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {
    private ExecutorService executor = Executors.newCachedThreadPool();
    private Handler handler = new Handler(Looper.getMainLooper());

    public void countDown(int count, OnCountDownListener listener) {
        executor.execute(new CountDownRunnable(count, listener, handler));
    }
}
