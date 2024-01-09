package com.example.projectexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton dialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogBtn = findViewById(R.id.show_dialog_btn);

        dialogBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.show_dialog_btn) {
//            showAlertDiaLog();

            showCustomDialog();
        }
    }

    private void showCustomDialog() {
        RateDialog rateDialog = new RateDialog(this, R.style.DialogTheme);

        rateDialog.show();
    }

    private void showAlertDiaLog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Delete image")
                .setMessage("Do you want to delete this image?")
                .setPositiveButton("OK", (dialog, which) -> {
                    Log.d("ManhNQ", "onClick: OK");
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("ManhNQ", "onClick: CANCEL");
            }
        });

        alertDialogBuilder.show();


    }
}