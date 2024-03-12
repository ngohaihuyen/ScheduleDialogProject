package com.example.projectexample.animation;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.projectexample.R;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatButton btnAnim, btnAnim2, btnAnim3;
    private AppCompatImageView btnAnim4, btnAnim5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_activity);
        initViews();

        Log.d("ManhNQ", "onClick: click item");

        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
        Animation robotIconAnimation = AnimationUtils.loadAnimation(this, R.anim.robot_icon_anim);
        Animation lightningIconAnimation = AnimationUtils.loadAnimation(this, R.anim.lightning_icon_anim);



        // Start the animation
        btnAnim.startAnimation(fadeInAnimation);
        btnAnim2.startAnimation(scaleAnimation);
        btnAnim3.startAnimation(translateAnimation);
        btnAnim4.startAnimation(robotIconAnimation);
        btnAnim5.startAnimation(lightningIconAnimation);

        Log.d("ManhNQ", "onClick: run anim");

    }

    private void initViews() {
        btnAnim = findViewById(R.id.btn_anim);
        btnAnim2 = findViewById(R.id.btn_anim2);
        btnAnim3 = findViewById(R.id.btn_anim3);
        btnAnim4 = findViewById(R.id.btn_anim4);
        btnAnim5 = findViewById(R.id.btn_anim5);

        btnAnim.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_anim) {

        }
    }
}
