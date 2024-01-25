package com.example.projectexample.AntiVirrusActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.example.projectexample.R;

public class AntiVirusActivity extends AppCompatActivity implements View.OnClickListener {

    private View scanVirusBg, secureWifiBg, appLockBg, autoScanBg, secretBg, cleanJunkBg, deleteBg, removeBg, similarPhotoBg, smartCleanBg, appManaBg, clipBoardBg, processBg, tempBg, batteryBg;

    private AppCompatTextView scanVirusTxt, secureWifiTxt, appLockTxt, autoScanTxt, secretTxt, cleanJunkTxt, deleteTxt, removeTxt, similarPhotoTxt, smartCleanTxt, appManaTxt, clipBoardTxt, processTXt, tempTxt, batteryTxt;

    private int selectBtnId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_virus_activity);
        initViews();
        setOnClickViews();

        Log.d("ANTIVIRUS", "onClick: onCreate");

    }

    private void initViews() {
        scanVirusBg = findViewById(R.id.scan_virus_bg);
        secureWifiBg = findViewById(R.id.secure_wifi_bg);
        appLockBg = findViewById(R.id.app_lock_bg);
        autoScanBg = findViewById(R.id.auto_scan_bg);
        secretBg = findViewById(R.id.secret_browser_bg);
        cleanJunkBg = findViewById(R.id.clean_junk_bg);
        deleteBg = findViewById(R.id.delete_file_bg);
        removeBg = findViewById(R.id.remove_notice_bg);
        similarPhotoBg = findViewById(R.id.similar_photo_bg);
        smartCleanBg = findViewById(R.id.smart_clean_bg);
        appManaBg = findViewById(R.id.app_manager_bg);
        clipBoardBg = findViewById(R.id.clip_board_bg);
        processBg = findViewById(R.id.process_bg);
        tempBg = findViewById(R.id.temp_detect_bg);
        batteryBg = findViewById(R.id.battery_info_bg);

        scanVirusTxt = findViewById(R.id.scan_virus_txt);
        secureWifiTxt = findViewById(R.id.secure_wifi_txt);
        appLockTxt = findViewById(R.id.app_lock_txt);
        autoScanTxt = findViewById(R.id.auto_scan_txt);
        secretTxt = findViewById(R.id.secret_browser_txt);
        cleanJunkTxt = findViewById(R.id.clean_junk_txt);
        deleteTxt = findViewById(R.id.delete_file_txt);
        removeTxt = findViewById(R.id.remove_notice_txt);
        similarPhotoTxt = findViewById(R.id.similar_photo_txt);
        smartCleanTxt = findViewById(R.id.smart_clean_txt);
        appManaTxt = findViewById(R.id.app_manager_txt);
        clipBoardTxt = findViewById(R.id.clip_board_txt);
        processTXt = findViewById(R.id.process_txt);
        tempTxt = findViewById(R.id.temp_detect_txt);
        batteryTxt = findViewById(R.id.battery_info_txt);

        Log.d("ANTIVIRUS", "onClick: Init views");


    }

    private void setOnClickViews() {
        scanVirusBg.setOnClickListener(this);
        secureWifiBg.setOnClickListener(this);
        appLockBg.setOnClickListener(this);
        autoScanBg.setOnClickListener(this);
        secretBg.setOnClickListener(this);
        cleanJunkBg.setOnClickListener(this);
        deleteBg.setOnClickListener(this);
        removeBg.setOnClickListener(this);
        similarPhotoBg.setOnClickListener(this);
        smartCleanBg.setOnClickListener(this);
        appManaBg.setOnClickListener(this);
        clipBoardBg.setOnClickListener(this);
        processBg.setOnClickListener(this);
        tempBg.setOnClickListener(this);
        batteryBg.setOnClickListener(this);

        Log.d("ANTIVIRUS", "onClick: set click");

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.scan_virus_bg) {
            selectBtnId = R.id.scan_virus_bg;
        } else if (v.getId() == R.id.secure_wifi_bg) {
            selectBtnId = R.id.secure_wifi_bg;
        } else if (v.getId() == R.id.app_lock_bg) {
            selectBtnId = R.id.app_lock_bg;
        } else if (v.getId() == R.id.auto_scan_bg) {
            selectBtnId = R.id.auto_scan_bg;
        } else if (v.getId() == R.id.secret_browser_bg) {
            selectBtnId = R.id.secret_browser_bg;
        } else if (v.getId() == R.id.clean_junk_bg) {
            selectBtnId = R.id.clean_junk_bg;
        } else if (v.getId() == R.id.delete_file_bg) {
            selectBtnId = R.id.delete_file_bg;
        } else if (v.getId() == R.id.remove_notice_bg) {
            selectBtnId = R.id.remove_notice_bg;
        } else if (v.getId() == R.id.similar_photo_bg) {
            selectBtnId = R.id.similar_photo_bg;
        } else if (v.getId() == R.id.smart_clean_bg) {
            selectBtnId = R.id.smart_clean_bg;
        } else if (v.getId() == R.id.app_manager_bg) {
            selectBtnId = R.id.app_manager_bg;
        } else if (v.getId() == R.id.clip_board_bg) {
            selectBtnId = R.id.clip_board_bg;
        } else if (v.getId() == R.id.process_bg) {
            selectBtnId = R.id.process_bg;
        } else if (v.getId() == R.id.temp_detect_bg) {
            selectBtnId = R.id.temp_detect_bg;
        } else if (v.getId() == R.id.battery_info_bg) {
            selectBtnId = R.id.battery_info_bg;
        }

        checkOptionSelect();

        Log.d("ANTIVIRUS", "onClick: on click");
    }

    private void checkOptionSelect() {

        int selectTextColor = ContextCompat.getColor(this, R.color.blue_color);
        int selectBgColor = ContextCompat.getColor(this, R.color.grey_color);
        int normalTextColor = ContextCompat.getColor(this, R.color.black);
        int normalBgColor = ContextCompat.getColor(this, R.color.white);

        if (selectBtnId == R.id.scan_virus_bg) {
            updateSelection(scanVirusTxt, scanVirusBg, R.id.scan_virus_bg, selectTextColor, selectBgColor);
            updateSelection(secureWifiTxt, secureWifiBg, R.id.secure_wifi_bg, normalTextColor, normalBgColor);
            updateSelection(appLockTxt, appLockBg, R.id.app_lock_bg, normalTextColor, normalBgColor);
            updateSelection(autoScanTxt, autoScanBg, R.id.auto_scan_bg, normalTextColor, normalBgColor);
            updateSelection(secretTxt, secretBg, R.id.secret_browser_bg, normalTextColor, normalBgColor);
            updateSelection(cleanJunkTxt, cleanJunkBg, R.id.clean_junk_bg, normalTextColor, normalBgColor);
            updateSelection(deleteTxt, deleteBg, R.id.delete_file_bg, normalTextColor, normalBgColor);
            updateSelection(removeTxt, removeBg, R.id.remove_notice_bg, normalTextColor, normalBgColor);
            updateSelection(similarPhotoTxt, similarPhotoBg, R.id.similar_photo_bg, normalTextColor, normalBgColor);
            updateSelection(smartCleanTxt, smartCleanBg, R.id.smart_clean_bg, normalTextColor, normalBgColor);
            updateSelection(appManaTxt, appManaBg, R.id.app_manager_bg, normalTextColor, normalBgColor);
            updateSelection(clipBoardTxt, clipBoardBg, R.id.clip_board_bg, normalTextColor, normalBgColor);
            updateSelection(processTXt, processBg, R.id.process_bg, normalTextColor, normalBgColor);
            updateSelection(tempTxt, tempBg, R.id.temp_detect_bg, normalTextColor, normalBgColor);
            updateSelection(batteryTxt, batteryBg, R.id.battery_info_bg, normalTextColor, normalBgColor);

        } else if (selectBtnId == R.id.secure_wifi_bg) {
            updateSelection(scanVirusTxt, scanVirusBg, R.id.scan_virus_bg, normalTextColor, normalBgColor);
            updateSelection(secureWifiTxt, secureWifiBg, R.id.secure_wifi_bg, selectTextColor, selectBgColor);
            updateSelection(appLockTxt, appLockBg, R.id.app_lock_bg, normalTextColor, normalBgColor);
            updateSelection(autoScanTxt, autoScanBg, R.id.auto_scan_bg, normalTextColor, normalBgColor);
            updateSelection(secretTxt, secretBg, R.id.secret_browser_bg, normalTextColor, normalBgColor);
            updateSelection(cleanJunkTxt, cleanJunkBg, R.id.clean_junk_bg, normalTextColor, normalBgColor);
            updateSelection(deleteTxt, deleteBg, R.id.delete_file_bg, normalTextColor, normalBgColor);
            updateSelection(removeTxt, removeBg, R.id.remove_notice_bg, normalTextColor, normalBgColor);
            updateSelection(similarPhotoTxt, similarPhotoBg, R.id.similar_photo_bg, normalTextColor, normalBgColor);
            updateSelection(smartCleanTxt, smartCleanBg, R.id.smart_clean_bg, normalTextColor, normalBgColor);
            updateSelection(appManaTxt, appManaBg, R.id.app_manager_bg, normalTextColor, normalBgColor);
            updateSelection(clipBoardTxt, clipBoardBg, R.id.clip_board_bg, normalTextColor, normalBgColor);
            updateSelection(processTXt, processBg, R.id.process_bg, normalTextColor, normalBgColor);
            updateSelection(tempTxt, tempBg, R.id.temp_detect_bg, normalTextColor, normalBgColor);
            updateSelection(batteryTxt, batteryBg, R.id.battery_info_bg, normalTextColor, normalBgColor);

        } else if (selectBtnId == R.id.app_lock_bg) {
            updateSelection(scanVirusTxt, scanVirusBg, R.id.scan_virus_bg, normalTextColor, normalBgColor);
            updateSelection(secureWifiTxt, secureWifiBg, R.id.secure_wifi_bg, normalTextColor, normalBgColor);
            updateSelection(appLockTxt, appLockBg, R.id.app_lock_bg, selectTextColor, selectBgColor);
            updateSelection(autoScanTxt, autoScanBg, R.id.auto_scan_bg, normalTextColor, normalBgColor);
            updateSelection(secretTxt, secretBg, R.id.secret_browser_bg, normalTextColor, normalBgColor);
            updateSelection(cleanJunkTxt, cleanJunkBg, R.id.clean_junk_bg, normalTextColor, normalBgColor);
            updateSelection(deleteTxt, deleteBg, R.id.delete_file_bg, normalTextColor, normalBgColor);
            updateSelection(removeTxt, removeBg, R.id.remove_notice_bg, normalTextColor, normalBgColor);
            updateSelection(similarPhotoTxt, similarPhotoBg, R.id.similar_photo_bg, normalTextColor, normalBgColor);
            updateSelection(smartCleanTxt, smartCleanBg, R.id.smart_clean_bg, normalTextColor, normalBgColor);
            updateSelection(appManaTxt, appManaBg, R.id.app_manager_bg, normalTextColor, normalBgColor);
            updateSelection(clipBoardTxt, clipBoardBg, R.id.clip_board_bg, normalTextColor, normalBgColor);
            updateSelection(processTXt, processBg, R.id.process_bg, normalTextColor, normalBgColor);
            updateSelection(tempTxt, tempBg, R.id.temp_detect_bg, normalTextColor, normalBgColor);
            updateSelection(batteryTxt, batteryBg, R.id.battery_info_bg, normalTextColor, normalBgColor);

        } else if (selectBtnId == R.id.auto_scan_bg) {
            updateSelection(scanVirusTxt, scanVirusBg, R.id.scan_virus_bg, normalTextColor, normalBgColor);
            updateSelection(secureWifiTxt, secureWifiBg, R.id.secure_wifi_bg, normalTextColor, normalBgColor);
            updateSelection(appLockTxt, appLockBg, R.id.app_lock_bg, normalTextColor, normalBgColor);
            updateSelection(autoScanTxt, autoScanBg, R.id.auto_scan_bg, selectTextColor, selectBgColor);
            updateSelection(secretTxt, secretBg, R.id.secret_browser_bg, normalTextColor, normalBgColor);
            updateSelection(cleanJunkTxt, cleanJunkBg, R.id.clean_junk_bg, normalTextColor, normalBgColor);
            updateSelection(deleteTxt, deleteBg, R.id.delete_file_bg, normalTextColor, normalBgColor);
            updateSelection(removeTxt, removeBg, R.id.remove_notice_bg, normalTextColor, normalBgColor);
            updateSelection(similarPhotoTxt, similarPhotoBg, R.id.similar_photo_bg, normalTextColor, normalBgColor);
            updateSelection(smartCleanTxt, smartCleanBg, R.id.smart_clean_bg, normalTextColor, normalBgColor);
            updateSelection(appManaTxt, appManaBg, R.id.app_manager_bg, normalTextColor, normalBgColor);
            updateSelection(clipBoardTxt, clipBoardBg, R.id.clip_board_bg, normalTextColor, normalBgColor);
            updateSelection(processTXt, processBg, R.id.process_bg, normalTextColor, normalBgColor);
            updateSelection(tempTxt, tempBg, R.id.temp_detect_bg, normalTextColor, normalBgColor);
            updateSelection(batteryTxt, batteryBg, R.id.battery_info_bg, normalTextColor, normalBgColor);

        } else if (selectBtnId == R.id.secret_browser_bg) {
            updateSelection(scanVirusTxt, scanVirusBg, R.id.scan_virus_bg, normalTextColor, normalBgColor);
            updateSelection(secureWifiTxt, secureWifiBg, R.id.secure_wifi_bg, normalTextColor, normalBgColor);
            updateSelection(appLockTxt, appLockBg, R.id.app_lock_bg, normalTextColor, normalBgColor);
            updateSelection(autoScanTxt, autoScanBg, R.id.auto_scan_bg, normalTextColor, normalBgColor);
            updateSelection(secretTxt, secretBg, R.id.secret_browser_bg, selectTextColor, selectBgColor);
            updateSelection(cleanJunkTxt, cleanJunkBg, R.id.clean_junk_bg, normalTextColor, normalBgColor);
            updateSelection(deleteTxt, deleteBg, R.id.delete_file_bg, normalTextColor, normalBgColor);
            updateSelection(removeTxt, removeBg, R.id.remove_notice_bg, normalTextColor, normalBgColor);
            updateSelection(similarPhotoTxt, similarPhotoBg, R.id.similar_photo_bg, normalTextColor, normalBgColor);
            updateSelection(smartCleanTxt, smartCleanBg, R.id.smart_clean_bg, normalTextColor, normalBgColor);
            updateSelection(appManaTxt, appManaBg, R.id.app_manager_bg, normalTextColor, normalBgColor);
            updateSelection(clipBoardTxt, clipBoardBg, R.id.clip_board_bg, normalTextColor, normalBgColor);
            updateSelection(processTXt, processBg, R.id.process_bg, normalTextColor, normalBgColor);
            updateSelection(tempTxt, tempBg, R.id.temp_detect_bg, normalTextColor, normalBgColor);
            updateSelection(batteryTxt, batteryBg, R.id.battery_info_bg, normalTextColor, normalBgColor);

        } else if (selectBtnId == R.id.clean_junk_bg) {
            updateSelection(scanVirusTxt, scanVirusBg, R.id.scan_virus_bg, normalTextColor, normalBgColor);
            updateSelection(secureWifiTxt, secureWifiBg, R.id.secure_wifi_bg, normalTextColor, normalBgColor);
            updateSelection(appLockTxt, appLockBg, R.id.app_lock_bg, normalTextColor, normalBgColor);
            updateSelection(autoScanTxt, autoScanBg, R.id.auto_scan_bg, normalTextColor, normalBgColor);
            updateSelection(secretTxt, secretBg, R.id.secret_browser_bg, normalTextColor, normalBgColor);
            updateSelection(cleanJunkTxt, cleanJunkBg, R.id.clean_junk_bg, selectTextColor, selectBgColor);
            updateSelection(deleteTxt, deleteBg, R.id.delete_file_bg, normalTextColor, normalBgColor);
            updateSelection(removeTxt, removeBg, R.id.remove_notice_bg, normalTextColor, normalBgColor);
            updateSelection(similarPhotoTxt, similarPhotoBg, R.id.similar_photo_bg, normalTextColor, normalBgColor);
            updateSelection(smartCleanTxt, smartCleanBg, R.id.smart_clean_bg, normalTextColor, normalBgColor);
            updateSelection(appManaTxt, appManaBg, R.id.app_manager_bg, normalTextColor, normalBgColor);
            updateSelection(clipBoardTxt, clipBoardBg, R.id.clip_board_bg, normalTextColor, normalBgColor);
            updateSelection(processTXt, processBg, R.id.process_bg, normalTextColor, normalBgColor);
            updateSelection(tempTxt, tempBg, R.id.temp_detect_bg, normalTextColor, normalBgColor);
            updateSelection(batteryTxt, batteryBg, R.id.battery_info_bg, normalTextColor, normalBgColor);

        } else if (selectBtnId == R.id.delete_file_bg) {
            updateSelection(scanVirusTxt, scanVirusBg, R.id.scan_virus_bg, normalTextColor, normalBgColor);
            updateSelection(secureWifiTxt, secureWifiBg, R.id.secure_wifi_bg, normalTextColor, normalBgColor);
            updateSelection(appLockTxt, appLockBg, R.id.app_lock_bg, normalTextColor, normalBgColor);
            updateSelection(autoScanTxt, autoScanBg, R.id.auto_scan_bg, normalTextColor, normalBgColor);
            updateSelection(secretTxt, secretBg, R.id.secret_browser_bg, normalTextColor, normalBgColor);
            updateSelection(cleanJunkTxt, cleanJunkBg, R.id.clean_junk_bg, normalTextColor, normalBgColor);
            updateSelection(deleteTxt, deleteBg, R.id.delete_file_bg, selectTextColor, selectBgColor);
            updateSelection(removeTxt, removeBg, R.id.remove_notice_bg, normalTextColor, normalBgColor);
            updateSelection(similarPhotoTxt, similarPhotoBg, R.id.similar_photo_bg, normalTextColor, normalBgColor);
            updateSelection(smartCleanTxt, smartCleanBg, R.id.smart_clean_bg, normalTextColor, normalBgColor);
            updateSelection(appManaTxt, appManaBg, R.id.app_manager_bg, normalTextColor, normalBgColor);
            updateSelection(clipBoardTxt, clipBoardBg, R.id.clip_board_bg, normalTextColor, normalBgColor);
            updateSelection(processTXt, processBg, R.id.process_bg, normalTextColor, normalBgColor);
            updateSelection(tempTxt, tempBg, R.id.temp_detect_bg, normalTextColor, normalBgColor);
            updateSelection(batteryTxt, batteryBg, R.id.battery_info_bg, normalTextColor, normalBgColor);

        } else if (selectBtnId == R.id.remove_notice_bg) {
            updateSelection(scanVirusTxt, scanVirusBg, R.id.scan_virus_bg, normalTextColor, normalBgColor);
            updateSelection(secureWifiTxt, secureWifiBg, R.id.secure_wifi_bg, normalTextColor, normalBgColor);
            updateSelection(appLockTxt, appLockBg, R.id.app_lock_bg, normalTextColor, normalBgColor);
            updateSelection(autoScanTxt, autoScanBg, R.id.auto_scan_bg, normalTextColor, normalBgColor);
            updateSelection(secretTxt, secretBg, R.id.secret_browser_bg, normalTextColor, normalBgColor);
            updateSelection(cleanJunkTxt, cleanJunkBg, R.id.clean_junk_bg, normalTextColor, normalBgColor);
            updateSelection(deleteTxt, deleteBg, R.id.delete_file_bg, normalTextColor, normalBgColor);
            updateSelection(removeTxt, removeBg, R.id.remove_notice_bg, selectTextColor, selectBgColor);
            updateSelection(similarPhotoTxt, similarPhotoBg, R.id.similar_photo_bg, normalTextColor, normalBgColor);
            updateSelection(smartCleanTxt, smartCleanBg, R.id.smart_clean_bg, normalTextColor, normalBgColor);
            updateSelection(appManaTxt, appManaBg, R.id.app_manager_bg, normalTextColor, normalBgColor);
            updateSelection(clipBoardTxt, clipBoardBg, R.id.clip_board_bg, normalTextColor, normalBgColor);
            updateSelection(processTXt, processBg, R.id.process_bg, normalTextColor, normalBgColor);
            updateSelection(tempTxt, tempBg, R.id.temp_detect_bg, normalTextColor, normalBgColor);
            updateSelection(batteryTxt, batteryBg, R.id.battery_info_bg, normalTextColor, normalBgColor);

        } else if (selectBtnId == R.id.similar_photo_bg) {
            updateSelection(scanVirusTxt, scanVirusBg, R.id.scan_virus_bg, normalTextColor, normalBgColor);
            updateSelection(secureWifiTxt, secureWifiBg, R.id.secure_wifi_bg, normalTextColor, normalBgColor);
            updateSelection(appLockTxt, appLockBg, R.id.app_lock_bg, normalTextColor, normalBgColor);
            updateSelection(autoScanTxt, autoScanBg, R.id.auto_scan_bg, normalTextColor, normalBgColor);
            updateSelection(secretTxt, secretBg, R.id.secret_browser_bg, normalTextColor, normalBgColor);
            updateSelection(cleanJunkTxt, cleanJunkBg, R.id.clean_junk_bg, normalTextColor, normalBgColor);
            updateSelection(deleteTxt, deleteBg, R.id.delete_file_bg, normalTextColor, normalBgColor);
            updateSelection(removeTxt, removeBg, R.id.remove_notice_bg, normalTextColor, normalBgColor);
            updateSelection(similarPhotoTxt, similarPhotoBg, R.id.similar_photo_bg, selectTextColor, selectBgColor);
            updateSelection(smartCleanTxt, smartCleanBg, R.id.smart_clean_bg, normalTextColor, normalBgColor);
            updateSelection(appManaTxt, appManaBg, R.id.app_manager_bg, normalTextColor, normalBgColor);
            updateSelection(clipBoardTxt, clipBoardBg, R.id.clip_board_bg, normalTextColor, normalBgColor);
            updateSelection(processTXt, processBg, R.id.process_bg, normalTextColor, normalBgColor);
            updateSelection(tempTxt, tempBg, R.id.temp_detect_bg, normalTextColor, normalBgColor);
            updateSelection(batteryTxt, batteryBg, R.id.battery_info_bg, normalTextColor, normalBgColor);

        } else if (selectBtnId == R.id.smart_clean_bg) {
            updateSelection(scanVirusTxt, scanVirusBg, R.id.scan_virus_bg, normalTextColor, normalBgColor);
            updateSelection(secureWifiTxt, secureWifiBg, R.id.secure_wifi_bg, normalTextColor, normalBgColor);
            updateSelection(appLockTxt, appLockBg, R.id.app_lock_bg, normalTextColor, normalBgColor);
            updateSelection(autoScanTxt, autoScanBg, R.id.auto_scan_bg, normalTextColor, normalBgColor);
            updateSelection(secretTxt, secretBg, R.id.secret_browser_bg, normalTextColor, normalBgColor);
            updateSelection(cleanJunkTxt, cleanJunkBg, R.id.clean_junk_bg, normalTextColor, normalBgColor);
            updateSelection(deleteTxt, deleteBg, R.id.delete_file_bg, normalTextColor, normalBgColor);
            updateSelection(removeTxt, removeBg, R.id.remove_notice_bg, normalTextColor, normalBgColor);
            updateSelection(similarPhotoTxt, similarPhotoBg, R.id.similar_photo_bg, normalTextColor, normalBgColor);
            updateSelection(smartCleanTxt, smartCleanBg, R.id.smart_clean_bg, selectTextColor, selectBgColor);
            updateSelection(appManaTxt, appManaBg, R.id.app_manager_bg, normalTextColor, normalBgColor);
            updateSelection(clipBoardTxt, clipBoardBg, R.id.clip_board_bg, normalTextColor, normalBgColor);
            updateSelection(processTXt, processBg, R.id.process_bg, normalTextColor, normalBgColor);
            updateSelection(tempTxt, tempBg, R.id.temp_detect_bg, normalTextColor, normalBgColor);
            updateSelection(batteryTxt, batteryBg, R.id.battery_info_bg, normalTextColor, normalBgColor);

        } else if (selectBtnId == R.id.app_manager_bg) {
            updateSelection(scanVirusTxt, scanVirusBg, R.id.scan_virus_bg, normalTextColor, normalBgColor);
            updateSelection(secureWifiTxt, secureWifiBg, R.id.secure_wifi_bg, normalTextColor, normalBgColor);
            updateSelection(appLockTxt, appLockBg, R.id.app_lock_bg, normalTextColor, normalBgColor);
            updateSelection(autoScanTxt, autoScanBg, R.id.auto_scan_bg, normalTextColor, normalBgColor);
            updateSelection(secretTxt, secretBg, R.id.secret_browser_bg, normalTextColor, normalBgColor);
            updateSelection(cleanJunkTxt, cleanJunkBg, R.id.clean_junk_bg, normalTextColor, normalBgColor);
            updateSelection(deleteTxt, deleteBg, R.id.delete_file_bg, normalTextColor, normalBgColor);
            updateSelection(removeTxt, removeBg, R.id.remove_notice_bg, normalTextColor, normalBgColor);
            updateSelection(similarPhotoTxt, similarPhotoBg, R.id.similar_photo_bg, normalTextColor, normalBgColor);
            updateSelection(smartCleanTxt, smartCleanBg, R.id.smart_clean_bg, normalTextColor, normalBgColor);
            updateSelection(appManaTxt, appManaBg, R.id.app_manager_bg, selectTextColor, selectBgColor);
            updateSelection(clipBoardTxt, clipBoardBg, R.id.clip_board_bg, normalTextColor, normalBgColor);
            updateSelection(processTXt, processBg, R.id.process_bg, normalTextColor, normalBgColor);
            updateSelection(tempTxt, tempBg, R.id.temp_detect_bg, normalTextColor, normalBgColor);
            updateSelection(batteryTxt, batteryBg, R.id.battery_info_bg, normalTextColor, normalBgColor);

        } else if (selectBtnId == R.id.clip_board_bg) {
            updateSelection(scanVirusTxt, scanVirusBg, R.id.scan_virus_bg, normalTextColor, normalBgColor);
            updateSelection(secureWifiTxt, secureWifiBg, R.id.secure_wifi_bg, normalTextColor, normalBgColor);
            updateSelection(appLockTxt, appLockBg, R.id.app_lock_bg, normalTextColor, normalBgColor);
            updateSelection(autoScanTxt, autoScanBg, R.id.auto_scan_bg, normalTextColor, normalBgColor);
            updateSelection(secretTxt, secretBg, R.id.secret_browser_bg, normalTextColor, normalBgColor);
            updateSelection(cleanJunkTxt, cleanJunkBg, R.id.clean_junk_bg, normalTextColor, normalBgColor);
            updateSelection(deleteTxt, deleteBg, R.id.delete_file_bg, normalTextColor, normalBgColor);
            updateSelection(removeTxt, removeBg, R.id.remove_notice_bg, normalTextColor, normalBgColor);
            updateSelection(similarPhotoTxt, similarPhotoBg, R.id.similar_photo_bg, normalTextColor, normalBgColor);
            updateSelection(smartCleanTxt, smartCleanBg, R.id.smart_clean_bg, normalTextColor, normalBgColor);
            updateSelection(appManaTxt, appManaBg, R.id.app_manager_bg, normalTextColor, normalBgColor);
            updateSelection(clipBoardTxt, clipBoardBg, R.id.clip_board_bg, selectTextColor, selectBgColor);
            updateSelection(processTXt, processBg, R.id.process_bg, normalTextColor, normalBgColor);
            updateSelection(tempTxt, tempBg, R.id.temp_detect_bg, normalTextColor, normalBgColor);
            updateSelection(batteryTxt, batteryBg, R.id.battery_info_bg, normalTextColor, normalBgColor);

        } else if (selectBtnId == R.id.process_bg) {
            updateSelection(scanVirusTxt, scanVirusBg, R.id.scan_virus_bg, normalTextColor, normalBgColor);
            updateSelection(secureWifiTxt, secureWifiBg, R.id.secure_wifi_bg, normalTextColor, normalBgColor);
            updateSelection(appLockTxt, appLockBg, R.id.app_lock_bg, normalTextColor, normalBgColor);
            updateSelection(autoScanTxt, autoScanBg, R.id.auto_scan_bg, normalTextColor, normalBgColor);
            updateSelection(secretTxt, secretBg, R.id.secret_browser_bg, normalTextColor, normalBgColor);
            updateSelection(cleanJunkTxt, cleanJunkBg, R.id.clean_junk_bg, normalTextColor, normalBgColor);
            updateSelection(deleteTxt, deleteBg, R.id.delete_file_bg, normalTextColor, normalBgColor);
            updateSelection(removeTxt, removeBg, R.id.remove_notice_bg, normalTextColor, normalBgColor);
            updateSelection(similarPhotoTxt, similarPhotoBg, R.id.similar_photo_bg, normalTextColor, normalBgColor);
            updateSelection(smartCleanTxt, smartCleanBg, R.id.smart_clean_bg, normalTextColor, normalBgColor);
            updateSelection(appManaTxt, appManaBg, R.id.app_manager_bg, normalTextColor, normalBgColor);
            updateSelection(clipBoardTxt, clipBoardBg, R.id.clip_board_bg, normalTextColor, normalBgColor);
            updateSelection(processTXt, processBg, R.id.process_bg, selectTextColor, selectBgColor);
            updateSelection(tempTxt, tempBg, R.id.temp_detect_bg, normalTextColor, normalBgColor);
            updateSelection(batteryTxt, batteryBg, R.id.battery_info_bg, normalTextColor, normalBgColor);

        } else if (selectBtnId == R.id.temp_detect_bg) {
            updateSelection(scanVirusTxt, scanVirusBg, R.id.scan_virus_bg, normalTextColor, normalBgColor);
            updateSelection(secureWifiTxt, secureWifiBg, R.id.secure_wifi_bg, normalTextColor, normalBgColor);
            updateSelection(appLockTxt, appLockBg, R.id.app_lock_bg, normalTextColor, normalBgColor);
            updateSelection(autoScanTxt, autoScanBg, R.id.auto_scan_bg, normalTextColor, normalBgColor);
            updateSelection(secretTxt, secretBg, R.id.secret_browser_bg, normalTextColor, normalBgColor);
            updateSelection(cleanJunkTxt, cleanJunkBg, R.id.clean_junk_bg, normalTextColor, normalBgColor);
            updateSelection(deleteTxt, deleteBg, R.id.delete_file_bg, normalTextColor, normalBgColor);
            updateSelection(removeTxt, removeBg, R.id.remove_notice_bg, normalTextColor, normalBgColor);
            updateSelection(similarPhotoTxt, similarPhotoBg, R.id.similar_photo_bg, normalTextColor, normalBgColor);
            updateSelection(smartCleanTxt, smartCleanBg, R.id.smart_clean_bg, normalTextColor, normalBgColor);
            updateSelection(appManaTxt, appManaBg, R.id.app_manager_bg, normalTextColor, normalBgColor);
            updateSelection(clipBoardTxt, clipBoardBg, R.id.clip_board_bg, normalTextColor, normalBgColor);
            updateSelection(processTXt, processBg, R.id.process_bg, normalTextColor, normalBgColor);
            updateSelection(tempTxt, tempBg, R.id.temp_detect_bg, selectTextColor, selectBgColor);
            updateSelection(batteryTxt, batteryBg, R.id.battery_info_bg, normalTextColor, normalBgColor);

        } else if (selectBtnId == R.id.battery_info_bg) {
            updateSelection(scanVirusTxt, scanVirusBg, R.id.scan_virus_bg, normalTextColor, normalBgColor);
            updateSelection(secureWifiTxt, secureWifiBg, R.id.secure_wifi_bg, normalTextColor, normalBgColor);
            updateSelection(appLockTxt, appLockBg, R.id.app_lock_bg, normalTextColor, normalBgColor);
            updateSelection(autoScanTxt, autoScanBg, R.id.auto_scan_bg, normalTextColor, normalBgColor);
            updateSelection(secretTxt, secretBg, R.id.secret_browser_bg, normalTextColor, normalBgColor);
            updateSelection(cleanJunkTxt, cleanJunkBg, R.id.clean_junk_bg, normalTextColor, normalBgColor);
            updateSelection(deleteTxt, deleteBg, R.id.delete_file_bg, normalTextColor, normalBgColor);
            updateSelection(removeTxt, removeBg, R.id.remove_notice_bg, normalTextColor, normalBgColor);
            updateSelection(similarPhotoTxt, similarPhotoBg, R.id.similar_photo_bg, normalTextColor, normalBgColor);
            updateSelection(smartCleanTxt, smartCleanBg, R.id.smart_clean_bg, normalTextColor, normalBgColor);
            updateSelection(appManaTxt, appManaBg, R.id.app_manager_bg, normalTextColor, normalBgColor);
            updateSelection(clipBoardTxt, clipBoardBg, R.id.clip_board_bg, normalTextColor, normalBgColor);
            updateSelection(processTXt, processBg, R.id.process_bg, normalTextColor, normalBgColor);
            updateSelection(tempTxt, tempBg, R.id.temp_detect_bg, normalTextColor, normalBgColor);
            updateSelection(batteryTxt, batteryBg, R.id.battery_info_bg, selectTextColor, selectBgColor);

        }

        Log.d("ANTIVIRUS", "onClick: check ");


    }

    private void updateSelection(AppCompatTextView textView, View backGround, int idSelected, int textColor, int bgColor) {
        if (selectBtnId == idSelected) {
            textView.setTextColor(ContextCompat.getColor(this, R.color.blue_color));
            backGround.setBackgroundColor(ContextCompat.getColor(this, R.color.grey_color));
        } else {
            textView.setTextColor(ContextCompat.getColor(this, R.color.black));
            backGround.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        }

        Log.d("ANTIVIRUS", "onClick: update selection");

    }

}
