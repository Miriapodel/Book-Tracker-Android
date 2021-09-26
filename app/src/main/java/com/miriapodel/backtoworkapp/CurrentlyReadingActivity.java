package com.miriapodel.backtoworkapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class CurrentlyReadingActivity extends AppCompatActivity {

    private RecyclerView currentlyReadingRecView;

    private SeeAllBooksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading);

        initVariables();
    }

    private void initVariables()
    {
        currentlyReadingRecView = findViewById(R.id.currentlyReadingRecView);

        adapter = new SeeAllBooksAdapter(this, "currently");

        adapter.setBookList(Utils.getInstance().getCurrentlyReadingBooks());

        currentlyReadingRecView.setAdapter(adapter);
        currentlyReadingRecView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
    }
}