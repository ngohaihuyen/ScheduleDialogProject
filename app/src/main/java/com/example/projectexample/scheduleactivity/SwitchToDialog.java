package com.example.projectexample.scheduleactivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.example.projectexample.R;

public class SwitchToDialog extends Dialog implements View.OnClickListener {
    private AppCompatImageView closeButton;
    private ConstraintLayout cancelButton, okButton, smartBg;

    private ConstraintLayout maxtimeBg;
    private ConstraintLayout sleepmodeBg;
    private ConstraintLayout currtenBg;

    private AppCompatTextView smartTxt;

    private AppCompatTextView maxtimeTxt;
    private AppCompatTextView sleepmodeTxt;
    private AppCompatTextView currentTxt;

    private int selectBtnId =-1 ;


    public SwitchToDialog(@NonNull Context context) {
        super(context);
    }

    public SwitchToDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected SwitchToDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switchto_dialog);
        closeButton = findViewById(R.id.close_icon);
        okButton = findViewById(R.id.add_btn);
        cancelButton = findViewById(R.id.cancel_ct);

        initBtn();
        initTxt();

        closeButton.setOnClickListener(this);
        okButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }


    private void initBtn() {
        smartBg = findViewById(R.id.smart_ct);
        maxtimeBg = findViewById(R.id.student_age_ct);
        sleepmodeBg = findViewById(R.id.class_ct);
        currtenBg = findViewById(R.id.current_mode_ct);

        smartBg.setOnClickListener(this);
        maxtimeBg.setOnClickListener(this);
        sleepmodeBg.setOnClickListener(this);
        currtenBg.setOnClickListener(this);
    }

    private void initTxt() {
        smartTxt = findViewById(R.id.smart_tv);
        maxtimeTxt = findViewById(R.id.student_age_tv);
        sleepmodeTxt = findViewById(R.id.class_tv);
        currentTxt = findViewById(R.id.current_mode_txt);

        smartTxt.setOnClickListener(this);
        maxtimeTxt.setOnClickListener(this);
        sleepmodeTxt.setOnClickListener(this);
        currentTxt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.close_icon || v.getId() == R.id.cancel_ct || v.getId() == R.id.add_btn) {
            dismiss();
        } else if (v.getId() == R.id.smart_ct) {
            selectBtnId = R.id.smart_ct;
        } else if (v.getId() == R.id.student_age_ct) {
            selectBtnId = R.id.student_age_ct;
        } else if (v.getId()== R.id.class_ct) {
            selectBtnId = R.id.class_ct;
        } else if (v.getId() == R.id.current_mode_ct) {
            selectBtnId = R.id.current_mode_ct;
        }
        checkSelectOption();
    }

    private void checkSelectOption() {

        int selectTextColor = ContextCompat.getColor(getContext(), R.color.blue_color);
        int selectBgColor = ContextCompat.getColor(getContext(), R.color.grey_color);
        int normalTextColor = ContextCompat.getColor(getContext(), R.color.grey_color);
        int normalBgColor = ContextCompat.getColor(getContext(), R.color.white);

        if (selectBtnId == R.id.smart_ct) {
            updateSelection(smartTxt, smartBg, R.id.smart_ct, selectTextColor, selectBgColor);
            updateSelection(maxtimeTxt, maxtimeBg, R.id.student_age_ct, normalTextColor, normalBgColor);
            updateSelection(sleepmodeTxt, sleepmodeBg, R.id.class_ct, normalTextColor, normalBgColor);
            updateSelection(currentTxt, currtenBg, R.id.current_mode_ct, normalTextColor, normalBgColor);
        } else if (selectBtnId == R.id.student_age_ct) {
            updateSelection(smartTxt, smartBg, R.id.smart_ct, normalTextColor, normalBgColor);
            updateSelection(maxtimeTxt, maxtimeBg, R.id.student_age_ct, selectTextColor, selectBgColor);
            updateSelection(sleepmodeTxt, sleepmodeBg, R.id.class_ct, normalTextColor, normalBgColor);
            updateSelection(currentTxt, currtenBg, R.id.current_mode_ct, normalTextColor, normalBgColor);
        } else if (selectBtnId == R.id.class_ct) {
            updateSelection(smartTxt, smartBg, R.id.smart_ct, normalTextColor, normalBgColor);
            updateSelection(maxtimeTxt, maxtimeBg, R.id.student_age_ct, normalTextColor, normalBgColor);
            updateSelection(sleepmodeTxt, sleepmodeBg, R.id.class_ct, selectTextColor, selectBgColor);
            updateSelection(currentTxt, currtenBg, R.id.current_mode_ct, normalTextColor, normalBgColor);
        } else if (selectBtnId == R.id.current_mode_ct) {
            updateSelection(smartTxt, smartBg, R.id.smart_ct, normalTextColor, normalBgColor);
            updateSelection(maxtimeTxt, maxtimeBg, R.id.student_age_ct, normalTextColor, normalBgColor);
            updateSelection(sleepmodeTxt, sleepmodeBg, R.id.class_ct, normalTextColor, normalBgColor);
            updateSelection(currentTxt, currtenBg, R.id.current_mode_ct, selectTextColor, selectBgColor);
        }
    }

    private void updateSelection(AppCompatTextView textView, ConstraintLayout backGround, int idSelected, int textColor, int bgColor) {
        if (selectBtnId == idSelected) {
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.blue_color));
            backGround.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.grey_color));
        } else {
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.grey_color));
            backGround.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
        }
    }
}


