package com.example.projectexample.librarymanage;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.projectexample.R;
import com.example.projectexample.librarymanage.callback.OnCategoryCallback;
import com.example.projectexample.librarymanage.callback.OnStoryCallback;
import com.example.projectexample.librarymanage.dialog.AddCategoryDialog;
import com.example.projectexample.librarymanage.dialog.AddStoryDialog;

public class LibraryManageActivity extends AppCompatActivity implements View.OnClickListener{

    private AppCompatButton addStrBtn, addCategoryBtn, updateBtn, deleteBtn;

    private AppCompatTextView resultTxt;
    private LibraryManager manager;

    private OnStoryCallback storyCallback = new OnStoryCallback() {
        @Override
        public void onAddStory(Story storyItem) {
            manager.addStoryToCategory(storyItem);
            resultTxt.setText(manager.toString());

        }
    };

    private OnCategoryCallback categoryCallback = new OnCategoryCallback() {
        @Override
        public void onAddCategoryCallback(Category categoryItem) {
            manager.addCategory(categoryItem);
            resultTxt.setText(manager.toString());
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_library_first_screen);

        manager = new LibraryManager();

        initViews();
        setClickEvents();
    }


    private void initViews() {
        addStrBtn = findViewById(R.id.add_story_btn);
        addCategoryBtn = findViewById(R.id.add_category_btn);
        updateBtn = findViewById(R.id.update_str_btn);
        deleteBtn = findViewById(R.id.delete_btn);
        resultTxt = findViewById(R.id.result_txt);
    }

    private void setClickEvents() {
        addStrBtn.setOnClickListener(this);
        addCategoryBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add_story_btn){
            AddStoryDialog addStoryDialog = new AddStoryDialog(this);
            addStoryDialog.setStoryCallback(storyCallback);
            addStoryDialog.show();
        } else if (v.getId() == R.id.add_category_btn) {
            AddCategoryDialog addCategoryDialog = new AddCategoryDialog(this);
            addCategoryDialog.setCategoryCallback(categoryCallback);
            addCategoryDialog.show();

        }
    }

}
