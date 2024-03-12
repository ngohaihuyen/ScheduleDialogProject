package com.example.projectexample.triangle;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.projectexample.R;


public class TriangleActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatEditText axEdt, ayEdt, bxEdt, byEdt, cxEdt, cyEdt;
    private Button perimeterBtn, areaBtn;
    private TextView resultTxt;
    private CalculateManager calculateManager;
    private PointItem pointA, pointB, pointC;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangle_activity);

        initViews();
        initPoints();
        calculateManager = new CalculateManager();

        perimeterBtn.setOnClickListener(this);
        areaBtn.setOnClickListener(this);

        Log.d("MANHNQ", "onCreate: oncreate");

        onTextChangeListener();

    }

    private void initPoints() {
        pointA = new PointItem();
        pointB = new PointItem();
        pointC = new PointItem();
    }


    private void onTextChangeListener() {
        axEdt.addTextChangedListener(new CustomTextWatcher() {
            @Override
            void onCustomTextChange(CharSequence s, int start, int before, int count) {
                Log.d("ManhNQ", "onTextChanged: " + s);
                if (checkValidText(s.toString())) {
                    pointA.setX(Float.parseFloat(s.toString()));
                    calculateManager.setAPoint(pointA);
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.perimeter_btn) {
            if (checkValid()) {
                float chuvi = calculateManager.calculatePerimeter();
                displayResult(String.valueOf(chuvi));

            }
        } else if (v.getId() == R.id.area_btn) {
            if (checkValid()) {

                float value = calculateManager.calculateArea();
                displayResult(String.valueOf(value));
            }
        }

        Log.d("MANHNQ", "onClick: on click");
    }


    private boolean checkValid() {
        String ax = axEdt.getText().toString();
        String ay = ayEdt.getText().toString();
        String bx = bxEdt.getText().toString();
        String by = byEdt.getText().toString();
        String cx = cxEdt.getText().toString();
        String cy = cyEdt.getText().toString();

        if (ax.isEmpty() || ay.isEmpty() || bx.isEmpty() || by.isEmpty() || cx.isEmpty() || cy.isEmpty()) {
            showAlertDialog("LỖI", "Bạn chưa nhập đủ toạ độ");
            return false;
        }
        return true;
    }

    private boolean checkValidText(String value) {
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c < '0' || c > '9') {
                showAlertDialog("LỖI", "Vui lòng nhập một số hợp lệ");
                return false;
            }
        }
        return true;
    }


    private void showAlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title).setMessage(message);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void displayResult(String result) {
        resultTxt.setText(result);
    }


    private void initViews() {
        axEdt = findViewById(R.id.ax_edt);
        ayEdt = findViewById(R.id.ay_edt);
        bxEdt = findViewById(R.id.bx_edt);
        byEdt = findViewById(R.id.by_edt);
        cxEdt = findViewById(R.id.cx_edt);
        cyEdt = findViewById(R.id.cy_edt);
        perimeterBtn = findViewById(R.id.perimeter_btn);
        areaBtn = findViewById(R.id.area_btn);
        resultTxt = findViewById(R.id.result_txt);

    }

}
