package com.example.projectexample;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

public class RateDialog extends Dialog implements View.OnClickListener {
    AppCompatImageView closeIcon;
    View poorLn, greatLn;


    public RateDialog(@NonNull Context context) {
        super(context);
    }

    public RateDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected RateDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_dialog);
        closeIcon = findViewById(R.id.close_icon);
        poorLn = findViewById(R.id.poor_ln);
        greatLn = findViewById(R.id.great_ln);

        closeIcon.setOnClickListener(this);
        poorLn.setOnClickListener(this);
        greatLn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.close_icon) {
            dismiss();
        } else if (v.getId() == R.id.poor_ln) {
            dismiss();
        } else if (v.getId() == R.id.great_ln) {
            dismiss();
        }

    }
}
