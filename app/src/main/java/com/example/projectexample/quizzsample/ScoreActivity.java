package com.example.projectexample.quizzsample;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectexample.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {
    private ListView scoreListView;
    private List<String> scoreList;
    private String fileName = "score_file_name.txt";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_activity);
        scoreListView = findViewById(R.id.score_list_view);
        scoreList = new ArrayList<>();
        displayScore();
    }

    private void displayScore() {
            Score scoreManager = new Score(this, fileName);
            String scores = scoreManager.readScore();
            scoreList.add(scores);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Collections.singletonList(scores));
            scoreListView.setAdapter(adapter);
    }
}
