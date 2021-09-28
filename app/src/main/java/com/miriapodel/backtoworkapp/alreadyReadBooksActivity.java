package com.miriapodel.backtoworkapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class alreadyReadBooksActivity extends AppCompatActivity {

    private RecyclerView alreadyReadBooksRecView;

    private SeeAllBooksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read_books);

        initVariables();
    }

    private void initVariables()
    {
        alreadyReadBooksRecView = findViewById(R.id.alreadyReadBooksRecView);

        adapter = new SeeAllBooksAdapter(this, "already");

        adapter.setBookList(Utils.getInstance(this).getAlreadyReadBooks());

        alreadyReadBooksRecView.setAdapter(adapter);
        alreadyReadBooksRecView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
    }
}