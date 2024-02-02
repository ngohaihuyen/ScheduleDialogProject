package com.example.projectexample.triangle;

import android.text.Editable;
import android.text.TextWatcher;

abstract class CustomTextWatcher  implements TextWatcher {
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        onCustomTextChange(s,start, before, count);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    abstract void onCustomTextChange(CharSequence s, int start, int before, int count);

}
