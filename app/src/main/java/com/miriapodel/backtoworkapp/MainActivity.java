package com.miriapodel.backtoworkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView logo;

    private TextView appName, copyright;

    private Button seeAll, currentlyReading, alreadyRead, wishlist, favorites, about;

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.seeAll:
                Intent intent = new Intent(this, SeeAllBooksActivity.class);
                startActivity(intent);
                break;
            case R.id.currentlyReading:
                Intent intent1  = new Intent(this, CurrentlyReadingActivity.class);
                startActivity(intent1);
                break;
            case R.id.alreadyRead:
                Intent intent2 = new Intent(this, alreadyReadBooksActivity.class);
                startActivity(intent2);
                break;
            case R.id.wishlist:
                Intent intent3 = new Intent(this, wantToReadActivity.class);
                startActivity(intent3);
                break;
            case R.id.favorites:
                Intent intent4 = new Intent(this, addToFavoritesActivity.class);
                startActivity(intent4);
                break;
            case R.id.about:
                Intent intent5 = new Intent(this, WebView.class);
                intent5.putExtra("about", "https://apple.com/");
                startActivity(intent5);
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();

        setOnClickListeners();
    }

    private void initVariables()
    {
        logo = findViewById(R.id.logo);

        logo.setImageResource(R.mipmap.logo);

        appName = findViewById(R.id.appName);

        copyright = findViewById(R.id.copyright);

        seeAll = findViewById(R.id.seeAll);

        currentlyReading = findViewById(R.id.currentlyReading);

        alreadyRead = findViewById(R.id.alreadyRead);

        wishlist = findViewById(R.id.wishlist);

        favorites = findViewById(R.id.favorites);

        about = findViewById(R.id.about);
    }

    private void setOnClickListeners()
    {
        seeAll.setOnClickListener(this);

        currentlyReading.setOnClickListener(this);

        alreadyRead.setOnClickListener(this);

        wishlist.setOnClickListener(this);

        favorites.setOnClickListener(this);

        about.setOnClickListener(this);
    }

}