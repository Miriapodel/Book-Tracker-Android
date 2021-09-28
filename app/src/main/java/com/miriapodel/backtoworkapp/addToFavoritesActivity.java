package com.miriapodel.backtoworkapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class addToFavoritesActivity extends AppCompatActivity {

    private RecyclerView addToFavoritesActivityRecView;

    private SeeAllBooksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_favorites);

        initVariables();
    }

    private void initVariables()
    {
        addToFavoritesActivityRecView = findViewById(R.id.addToFavoritesRecView);

        adapter = new SeeAllBooksAdapter(this, "favorites");

        adapter.setBookList(Utils.getInstance(this).getFavoritesBooks());

        addToFavoritesActivityRecView.setAdapter(adapter);
        addToFavoritesActivityRecView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
    }
}