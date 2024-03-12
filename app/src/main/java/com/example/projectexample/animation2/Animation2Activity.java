package com.example.projectexample.animation2;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.projectexample.R;

public class Animation2Activity extends AppCompatActivity {

    private ValueAnimator valueAnimator;
    private ObjectAnimator objectAnimator;
    private AppCompatButton runBtn;

    private View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation2_activity);
        initViews();
//        initAnimation();
        initObjectAnimation();
    }

    private void initObjectAnimation() {
        objectAnimator = ObjectAnimator.ofFloat(view, "scaleX", 1f, 2f);
        objectAnimator.setDuration(2000L);
        view.setPivotX((float) view.getWidth()/2);
        view.setPivotY((float) view.getHeight()/2);
    }

    private void initViews() {
        runBtn = findViewById(R.id.run_btn);
        view = findViewById(R.id.animated_view);

        runBtn.setOnClickListener(v -> {
            objectAnimator.start();
        });
    }

    private void runAnim() {
        if (!valueAnimator.isStarted()) {
            valueAnimator.start();
        }

        if (valueAnimator.isPaused()) {
            valueAnimator.resume();
        } else {
            valueAnimator.pause();
        }
    }

    private void initAnimation() {
        valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.setDuration(2000L);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator animation) {
                //100f-300f


                float animatedValue = (float) animation.getAnimatedValue();
                float width = convertValue(animatedValue, 0f, 1f, 100f, 300f);
                float alpha = convertValue(animatedValue, 0f, 1f, 0.5f, 1f);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) width, (int) 100f);
                view.setLayoutParams(params);
                view.setAlpha(alpha);

            }
        });
    }

    private float convertValue(float value, float min1, float max1, float min2, float max2) {
        return 0;
    }
}
