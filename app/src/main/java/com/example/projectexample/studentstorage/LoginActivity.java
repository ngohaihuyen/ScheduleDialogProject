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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_stored_student);

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
                    saveLoginInfo(username);
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

        SharedPreferences sharedPreferences = getSharedPreferences("LOGIN_INFOR", Context.MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("USERNAME", "");
        String savedPassword = sharedPreferences.getString("PASSWORD", "");
        return username.equals(savedUsername) && password.equals(savedPassword);
    }

    private void saveLoginInfo(String username) {
        SharedPreferences sharedPreferences = getSharedPreferences("LOGIN_INFOR", Context.MODE_PRIVATE);
        SharedPreferences.Editor shareEditor = sharedPreferences.edit();
        shareEditor.putString("USERNAME", "HUYEN");
        shareEditor.putString("PASSWORD", "123456");
        shareEditor.commit();
    }
}