package com.miriapodel.backtoworkapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class SeeAllBooksAdapter extends RecyclerView.Adapter<SeeAllBooksAdapter.ViewHolder> {

    private ArrayList<Book> bookList = new ArrayList<>();

    private Context context;

    private String parentActivity;

    public SeeAllBooksAdapter(Context context, String parentActivity) {
        this.context = context;
        this.parentActivity = parentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_books_list_item, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

    holder.bookTitle.setText(bookList.get(position).getBookTitle());

    Glide.with(context).asBitmap().load(bookList.get(position).getBookCoverURL()).into(holder.bookCover);

    holder.shortDescription.setText(bookList.get(position).getShortDescription());

    holder.authorName.setText(bookList.get(position).getAuthorName());

    holder.item.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, BookActivity.class);
            intent.putExtra("bookId", bookList.get(position).getId());
            context.startActivity(intent);
        }
    });

    if(bookList.get(position).getExpanded())
    {
        TransitionManager.beginDelayedTransition(holder.expandedLayout);
        holder.expandedLayout.setVisibility(View.VISIBLE);
        holder.downArrow.setVisibility(View.GONE);

        if(parentActivity.equals("allBooks"))
        {
            holder.deleteButton.setVisibility(View.GONE);
        }
        else
            if(parentActivity.equals("currently"))
            {
                holder.deleteButton.setVisibility(View.VISIBLE);

                holder.deleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure you want to delete " + bookList.get(position).getBookTitle());

                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if(Utils.getInstance(context).removeFromCurrentlyReading(bookList.get(position)))
                                {
                                    Toast.makeText(context, "Book removed", Toast.LENGTH_SHORT).show();
                                    bookList = Utils.getInstance(context).getCurrentlyReadingBooks();
                                    notifyDataSetChanged();
                                }
                                else
                                {
                                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                    builder.create().show();
                    }
                });
            }
            else
                if(parentActivity.equals("already"))
                {
                    holder.deleteButton.setVisibility(View.VISIBLE);

                    holder.deleteButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                            builder.setMessage("Are you sure you want to delete " + bookList.get(position).getBookTitle()+"?");

                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    if(Utils.getInstance(context).removeFromAlreadyRead(bookList.get(position)))
                                    {
                                        Toast.makeText(context, "Book removed", Toast.LENGTH_SHORT).show();
                                        bookList = Utils.getInstance(context).getAlreadyReadBooks();
                                        notifyDataSetChanged();
                                    }
                                    else
                                    {
                                        Toast.makeText(context, "Error occurred! Please try again.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                            builder.create().show();
                        }
                    });
                }
                else
                    if(parentActivity.equals("wishlist"))
                    {
                        holder.deleteButton.setVisibility(View.VISIBLE);

                        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setMessage("Are you sure you want to delete " + bookList.get(position).getBookTitle() + "?");

                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        if(Utils.getInstance(context).removeFromWishlist(bookList.get(position)))
                                        {
                                            Toast.makeText(context, "Book removed", Toast.LENGTH_SHORT).show();
                                            bookList = Utils.getInstance(context).getWishlistBooks();
                                            notifyDataSetChanged();
                                        }
                                        else
                                        {
                                            Toast.makeText(context, "Error occurred! Please try again", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                            builder.create().show();
                            }
                        });
                    }
                    else
                        if(parentActivity.equals("favorites"))
                        {
                            holder.deleteButton.setVisibility(View.VISIBLE);

                            holder.deleteButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                    builder.setMessage("Are you sure you want to delete " + bookList.get(position) + "?");

                                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            if(Utils.getInstance(context).removeFromFavorites(bookList.get(position)))
                                            {
                                                Toast.makeText(context, "Book removed", Toast.LENGTH_SHORT).show();
                                                bookList = Utils.getInstance(context).getFavoritesBooks();
                                                notifyDataSetChanged();
                                            }
                                            else
                                            {
                                                Toast.makeText(context, "Error occurred! Please try again.", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });

                                  builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                      @Override
                                      public void onClick(DialogInterface dialogInterface, int i) {

                                      }
                                  });

                                builder.create().show();
                                }
                            });
                        }

    }
    else
    {
        TransitionManager.beginDelayedTransition(holder.expandedLayout);
        holder.expandedLayout.setVisibility(View.GONE);
        holder.downArrow.setVisibility(View.VISIBLE);
    }

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        MaterialCardView item;

        ImageView bookCover;

        TextView bookTitle;

        TextView authorName;

        TextView shortDescription;

        ImageView downArrow;

        ImageView upArrow;

        RelativeLayout expandedLayout;

        TextView deleteButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item = itemView.findViewById(R.id.item);

            deleteButton = itemView.findViewById(R.id.deleteText);

            bookCover = itemView.findViewById(R.id.bookCover);

            bookTitle = itemView.findViewById(R.id.bookTitle);

            authorName = itemView.findViewById(R.id.authorName);

            shortDescription = itemView.findViewById(R.id.shortDescription);

            downArrow = itemView.findViewById(R.id.downArrow);

            upArrow = itemView.findViewById(R.id.upArrow);

            expandedLayout = itemView.findViewById(R.id.expandedLayout);


            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    notifyItemChanged(getAdapterPosition());
                    Book book = bookList.get(getAdapterPosition());
                    book.setExpanded(true);
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    notifyItemChanged(getAdapterPosition());
                    Book book = bookList.get(getAdapterPosition());
                    book.setExpanded(false);
                }
            });

        }
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;

        notifyDataSetChanged();
    }
}
