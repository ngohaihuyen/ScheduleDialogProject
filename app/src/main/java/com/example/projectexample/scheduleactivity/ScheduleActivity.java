package com.example.projectexample.scheduleactivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.projectexample.R;
public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener {

    private View onButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_schedule_layout);
        View onButton = findViewById(R.id.on_button_ct);
        onButton.setOnClickListener(this);
        Log.d("MANH NQ", "onCreate: ");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.on_button_ct) {
            showCustomDialog();
            Log.d("MANH NQ", "onClick: ");
        }
    }

    private void showCustomDialog() {
        SwitchToDialog switchToDialog = new SwitchToDialog(this, R.style.DialogTheme);
        switchToDialog.show();
    }

    private void showAlertDiaLog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ScheduleActivity.this);
        alertDialogBuilder.setTitle("Switch to:");
        final CharSequence[]items = {"Smart Power Saving", "Maximum Standby Time", "Sleep Mode", "Current Mode"};
        alertDialogBuilder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Log.d("ManhNQ", "onClick: ");
            }
        });
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Log.d("ManhNQ", "onClick: OK");
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("ManhNQ", "onClick: CANCEL");
            }
        });

        alertDialogBuilder.show();
    }

    private void setSelectItem(String selectedItem) {
        switch (selectedItem) {
            case "Smart Power Saving":
                break;
            case "Maximum Standby Time":
                break;
            case "Sleep Mode":
                break;
            case "Current Mode":
                break;
        }
    }
}
