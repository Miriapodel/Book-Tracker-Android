package com.miriapodel.backtoworkapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class SeeAllBooksActivity extends AppCompatActivity {

    private RecyclerView allBooksList;

    private SeeAllBooksAdapter adapter;

    private ArrayList<Book> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_books);

        initVariables();
    }

    private void initVariables()
    {
        allBooksList = findViewById(R.id.allBooksList);

        adapter = new SeeAllBooksAdapter(this, "allBooks");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter.setBookList(Utils.getInstance(this).getAllBooks());

        allBooksList.setAdapter(adapter);
        allBooksList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        onBackPressed();

        return super.onOptionsItemSelected(item);
    }
}