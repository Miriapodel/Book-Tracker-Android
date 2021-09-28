package com.miriapodel.backtoworkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private ImageView bookImage;

    private Button currentlyButton, wantToButton, alreadyButton, addToButton;

    private TextView bookNameText, authorText, numberOfPagesText, descriptionText, longDescriptionText, nameText, authorNameText, pagesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initVariables();

        Intent intent = getIntent();

        if(intent != null)
        {
            int bookId = intent.getIntExtra("bookId", -1);

            if(bookId != -1)
            {
                Book incomingBook = Utils.getInstance(this).getBookById(bookId);

                if(incomingBook != null)
                {
                   Glide.with(this).asBitmap().load(incomingBook.getBookCoverURL()).into(bookImage);
                    nameText.setText(incomingBook.getBookTitle());
                   authorNameText.setText(incomingBook.getAuthorName());
                    pagesText.setText(String.valueOf(incomingBook.getPages()));
                    longDescriptionText.setText(incomingBook.getLongDescription());

                    handleCurrentlyReading(incomingBook);
                    handleWantToRead(incomingBook);
                    handleAlreadyRead(incomingBook);
                    handleFavorites(incomingBook);

                }
            }
        }

    }

    public void initVariables()
    {
        bookImage = findViewById(R.id.bookImage);

        currentlyButton = findViewById(R.id.currentlyButton);

        wantToButton = findViewById(R.id.wantToButton);

        alreadyButton = findViewById(R.id.alreadyButton);

        addToButton = findViewById(R.id.addToButton);

        bookNameText = findViewById(R.id.bookNameText);

        authorText = findViewById(R.id.authorText);

        numberOfPagesText = findViewById(R.id.numberOfPagesText);

        descriptionText = findViewById(R.id.descriptionText);

        longDescriptionText = findViewById(R.id.longDescriptionText);

        nameText = findViewById(R.id.nameText);

        authorNameText = findViewById(R.id.authorNameText);

        pagesText = findViewById(R.id.pagesText);
    }

    private void handleCurrentlyReading(Book book)
    {
        ArrayList<Book> currentlyReading = Utils.getInstance(this).getCurrentlyReadingBooks();

        boolean existsInCurrentlyReading = false;

        for(Book b : currentlyReading)
            if(b.getId() == book.getId())
                existsInCurrentlyReading = true;

            if(existsInCurrentlyReading)
            {
                currentlyButton.setEnabled(false);
            }
            else
            {
                currentlyButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(Utils.getInstance(BookActivity.this).addToCurrentlyReading(book))
                        {
                            Intent intent = new Intent(BookActivity.this, CurrentlyReadingActivity.class);
                            startActivity(intent);

                            Toast.makeText(BookActivity.this, "Book Added Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(BookActivity.this, "Error! Try Again!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
    }

    private void handleWantToRead(Book book)
    {
        ArrayList<Book> wantToReadBooks = Utils.getInstance(this).getWishlistBooks();

        boolean existsInWantToReadBooks = false;

        for(Book b : wantToReadBooks)
            if(b.getId() == book.getId())
                existsInWantToReadBooks = true;

            if(existsInWantToReadBooks)
            {
                wantToButton.setEnabled(false);
            }
            else
            {
                wantToButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(Utils.getInstance(BookActivity.this).addToWishlistBooks(book))
                        {
                            Intent intent = new Intent(BookActivity.this, wantToReadActivity.class);
                            startActivity(intent);

                            Toast.makeText(BookActivity.this, "Book Added Successfully!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(BookActivity.this, "Error! Try Again!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
    }

    private void handleAlreadyRead(Book book)
    {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance(this).getAlreadyReadBooks();

        boolean existsInAlreadyReadBooks = false;

        for(Book b : alreadyReadBooks)
            if(b.getId() == book.getId())
                existsInAlreadyReadBooks = true;

            if(existsInAlreadyReadBooks)
            {
                alreadyButton.setEnabled(false);
            }
            else
            {
                alreadyButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(Utils.getInstance(BookActivity.this).addToAlreadyReadBooks(book))
                        {
                            Intent intent = new Intent(BookActivity.this, alreadyReadBooksActivity.class);
                            startActivity(intent);

                            Toast.makeText(BookActivity.this, "Book Added Successfully!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(BookActivity.this, "Error! Try Again!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
    }

    private void handleFavorites(Book book)
    {
        ArrayList<Book> favoriteBooks = Utils.getInstance(this).getFavoritesBooks();

        boolean existsInFavoriteBooks = false;

        for(Book b : favoriteBooks)
            if(b.getId() == book.getId())
                existsInFavoriteBooks = true;

            if(existsInFavoriteBooks)
            {
                addToButton.setEnabled(false);
            }
            else
            {
                addToButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(Utils.getInstance(BookActivity.this).addToFavoritesBooks(book))
                        {
                            Intent intent = new Intent(BookActivity.this, addToFavoritesActivity.class);
                            startActivity(intent);

                            Toast.makeText(BookActivity.this, "Book Added Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(BookActivity.this, "Error! Try Again!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
    }

}