package com.miriapodel.backtoworkapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class wantToReadActivity extends AppCompatActivity {

    private RecyclerView wantToReadRecView;

    private SeeAllBooksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_to_read);

        initVariables();
    }

    private void initVariables()
    {
        wantToReadRecView = findViewById(R.id.wantToReadRecView);

        adapter = new SeeAllBooksAdapter(this, "wishlist");

        adapter.setBookList(Utils.getInstance(this).getWishlistBooks());

        wantToReadRecView.setAdapter(adapter);
        wantToReadRecView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
    }
}