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
        okButton = findViewById(R.id.ok_ct);
        cancelButton = findViewById(R.id.cancel_ct);

        initBtn();
        initTxt();

        closeButton.setOnClickListener(this);
        okButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }


    private void initBtn() {
        smartBg = findViewById(R.id.smart_power_saving_ct);
        maxtimeBg = findViewById(R.id.maximum_standby_time_ct);
        sleepmodeBg = findViewById(R.id.sleep_mode_ct);
        currtenBg = findViewById(R.id.current_mode_ct);
    }

    private void initTxt() {
        smartTxt = findViewById(R.id.smart_power_saving_txt);
        maxtimeTxt = findViewById(R.id.maximum_standby_time_txt);
        sleepmodeTxt = findViewById(R.id.sleep_mode_txt);
        currentTxt = findViewById(R.id.current_mode_txt);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.close_icon || v.getId() == R.id.cancel_ct || v.getId() == R.id.ok_ct) {
            dismiss();
        } else if (v.getId() == R.id.smart_power_saving_ct) {
            selectBtnId = R.id.smart_power_saving_ct;
        } else if (v.getId() == R.id.maximum_standby_time_ct) {
            selectBtnId = R.id.maximum_standby_time_ct;
        } else if (v.getId()== R.id.sleep_mode_ct) {
            selectBtnId = R.id.sleep_mode_ct;
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

        if (selectBtnId == R.id.smart_power_saving_ct) {
            smartSelection(smartTxt, smartBg, selectTextColor, selectBgColor);
            maxTimeSelection(maxtimeTxt, maxtimeBg, normalTextColor, normalBgColor);
            sleepSelection(sleepmodeTxt, sleepmodeBg, normalTextColor, normalBgColor);
            currentSelection(currentTxt, currtenBg, normalTextColor, normalBgColor);

        }
        if (selectBtnId == R.id.maximum_standby_time_ct) {
            smartSelection(smartTxt, smartBg, normalTextColor, normalBgColor);
            maxTimeSelection(maxtimeTxt, maxtimeBg, selectTextColor, selectBgColor);
            sleepSelection(sleepmodeTxt, sleepmodeBg, normalTextColor, normalBgColor);
            currentSelection(currentTxt, currtenBg, normalTextColor, normalBgColor);

        }
        if (selectBtnId == R.id.sleep_mode_ct) {
            smartSelection(smartTxt, smartBg, normalTextColor, normalBgColor);
            maxTimeSelection(maxtimeTxt, maxtimeBg, normalTextColor, normalBgColor);
            sleepSelection(sleepmodeTxt, sleepmodeBg, selectTextColor, selectBgColor);
            currentSelection(currentTxt, currtenBg, normalTextColor, normalBgColor);
        }
        if (selectBtnId == R.id.current_mode_ct) {
            smartSelection(smartTxt, smartBg, normalTextColor, normalBgColor);
            maxTimeSelection(maxtimeTxt, maxtimeBg, normalTextColor, normalBgColor);
            sleepSelection(sleepmodeTxt, sleepmodeBg, normalTextColor, normalBgColor);
            currentSelection(currentTxt, currtenBg, selectTextColor, selectBgColor);
        }
    }

    private void smartSelection(AppCompatTextView smartTextView, ConstraintLayout smartBackground, int textColor, int bgColor) {
        smartTextView.setTextColor(textColor);
        smartBackground.setBackgroundColor(bgColor);
    }

    private void maxTimeSelection(AppCompatTextView maxTimeTextView, ConstraintLayout maxTimeBackground, int textColor, int bgColor) {
        maxTimeTextView.setTextColor(textColor);
        maxTimeBackground.setBackgroundColor(bgColor);
    }

    private void sleepSelection(AppCompatTextView sleepTextView, ConstraintLayout sleepBackground, int textColor, int bgColor) {
        sleepTextView.setTextColor(textColor);
        sleepBackground.setBackgroundColor(bgColor);
    }

    private void currentSelection(AppCompatTextView currentTextView, ConstraintLayout currentBackground, int textColor, int bgColor) {
        currentTextView.setTextColor(textColor);
        currentBackground.setBackgroundColor(bgColor);
    }
}


