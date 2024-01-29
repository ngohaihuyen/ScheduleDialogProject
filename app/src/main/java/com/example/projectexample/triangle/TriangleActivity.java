package com.example.projectexample.triangle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectexample.R;

public class TriangleActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText axEdt, ayEdt, bxEdt, byEdt, cxEdt, cyEdt;
    private Button perimeterBtn, areaBtn;
    private TextView resultTxt;

    private double sideAB, sideBC, sideCA;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangle_activity);

        initViews();

        perimeterBtn.setOnClickListener(this);
        areaBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.perimeter_btn) {
            if (checkValid()) {
                double perimeter = calculatePerimeter();
                if (perimeter >= 0) {
                    displayResult("Ket qua: " + perimeter);
                } else {
                    displayError("Ket qua khong hop ly");
                }
            }
        } else if (v.getId() == R.id.area_btn) {
            if (checkValid()) {
                double area = calculateArea();
                if (area >= 0) {
                    displayResult("Ket qua: " + area);
                } else {
                    displayError("Ket qua khong hop ly");
                }
            }
        }
    }

    private void displayError(String errorMessage) {
        displayResult(errorMessage);
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

    private void showAlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void displayResult(String result) {
        resultTxt.setText(result);
    }

    private double distance(EditText x1Edt, EditText y1Edt, EditText x2Edt, EditText y2Edt) {
        double x1 = Double.parseDouble(x1Edt.getText().toString());
        double y1 = Double.parseDouble(y1Edt.getText().toString());
        double x2 = Double.parseDouble(x2Edt.getText().toString());
        double y2 = Double.parseDouble(y2Edt.getText().toString());
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private double calculatePerimeter() {
        sideAB = distance(axEdt, ayEdt, bxEdt, byEdt);
        sideBC = distance(bxEdt, byEdt, cxEdt, cyEdt);
        sideCA = distance(cxEdt, cyEdt, axEdt, ayEdt);
        return sideAB + sideBC + sideCA;
    }

    private double calculateArea() {
        double x1 = Double.parseDouble(axEdt.getText().toString());
        double y1 = Double.parseDouble(ayEdt.getText().toString());
        double x2 = Double.parseDouble(bxEdt.getText().toString());
        double y2 = Double.parseDouble(byEdt.getText().toString());
        double x3 = Double.parseDouble(cxEdt.getText().toString());
        double y3 = Double.parseDouble(cyEdt.getText().toString());
        return 0.5 * (x1 *(y2 - y3) + x2 *(y3 - y1) + x3 *(y1 - y2));
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
