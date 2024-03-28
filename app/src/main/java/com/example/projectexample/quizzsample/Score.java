package com.example.projectexample.quizzsample;

import android.os.Environment;
import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Score {
    private String scoreFileName = "score_file_name.txt";
    private Context context;

    public Score(Context context, String scoreFileName) {
        this.context = context;
        this.scoreFileName = scoreFileName;

        if(!isScoreFileExists()) {
            writeScoreToFile(0);
        }
    }

    private boolean isScoreFileExists() {
        File scoreFile = getScoreFile();
        return scoreFile.exists();
    }

    private File getScoreFile() {
        try {
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), scoreFileName);
            if (!file.exists()) {
                boolean isSuccess = file.createNewFile();
                if (isSuccess) {
                    return file;
                } else {
                    return null;
                }
            }
            return file;
        } catch (Exception e) {
            return null;
        }
    }

    public void updateScore(int score){
        int currentScore = Integer.parseInt(readScore());
        int updatedScore = currentScore + score;

        writeScoreToFile(updatedScore);
    }

    public String readScore() {
        try {
            File file = getScoreFile();
            FileInputStream fileInputStream = new FileInputStream(file);

            byte[] buff = new byte[1024];
            int len = fileInputStream.read(buff);

            String result = " ";
            while (len > -1) {
                result += new String(buff, 0, len);
                len = fileInputStream.read(buff);
            }
            fileInputStream.close();
            return result;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void writeScoreToFile(int score) {
        try { File file = getScoreFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(String.valueOf(score).getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
