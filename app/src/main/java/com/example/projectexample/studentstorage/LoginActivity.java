package com.example.projectexample.studentstorage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.projectexample.R;

public class LoginActivity extends AppCompatActivity {

    private AppCompatEditText usernameEdt, passwordEdt;
    private AppCompatButton loginBtn;
    private final String appNamePref = "project_sample_pref";
    private final String nameKey = "USERNAME";
    private final String passwordKey = "PASSWORD";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_stored_student);

        saveLoginInfo();

        usernameEdt = findViewById(R.id.username_edt);
        passwordEdt = findViewById(R.id.pass_edt);
        loginBtn = findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEdt.getText().toString().trim();
                String password = passwordEdt.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    showErrorDialog("Vui lòng nhập đầy đủ thông tin!");
                    return;
                }

                if (isValidCredentials(username, password)) {
                    Intent intent = new Intent(LoginActivity.this, ManageStudentsActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    showErrorDialog("Tên người dùng hoặc mật khẩu không đúng");
                }
            }
        });
    }



    private void showErrorDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("LỖI");
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    private boolean isValidCredentials(String username, String password) {
        String savedUsername = getValueOf(nameKey);
        String savedPassword = getValueOf(passwordKey);

        return username.equals(savedUsername) && password.equals(savedPassword);
    }

    private void saveLoginInfo() {
        SharedPreferences sharedPreferences = getSharedPreferences(appNamePref, Context.MODE_PRIVATE);
        SharedPreferences.Editor shareEditor = sharedPreferences.edit();
        shareEditor.putString("USERNAME", "abc");
        shareEditor.putString("PASSWORD", "123");

        shareEditor.commit();
    }

    private String getValueOf(String key){
        SharedPreferences sharedPreferences = getSharedPreferences(appNamePref, Context.MODE_PRIVATE);

        return sharedPreferences.getString(key,"");
    }
}