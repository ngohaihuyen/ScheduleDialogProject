package com.example.projectexample.quizzsample;

import android.os.Handler;

import com.example.projectexample.imagefile.OnCountDownListener;

public class CountDownRunnable implements Runnable{
    int count;
    OnCountDownListener listener;
    Handler handler;

    public CountDownRunnable(int count, OnCountDownListener listener, Handler handler) {
        this.count = count;
        this.listener = listener;
        this.handler = handler;
    }

    @Override
    public void run() {
        countDown();
    }

    public void countDown() {
        int currentCount = count;
        try {
            while (currentCount > 0) {
                int finalCurrentCount = currentCount;
                handler.post(() -> listener.onUpdateTime(finalCurrentCount));

                Thread.sleep(15000);
                currentCount--;
            }
            if (currentCount == 0) {
                handler.post(() -> listener.onTimeComplete());
            }
        } catch (Exception e) {

        }

    }
}
