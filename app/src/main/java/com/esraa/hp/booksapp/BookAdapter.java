package com.esraa.hp.booksapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;


public class BookAdapter extends ArrayAdapter<BookDetails> {

    ArrayList<BookDetails> books;
    AlertDialog dialog;

    public BookAdapter(@NonNull Context context, @NonNull ArrayList<BookDetails> books) {
        super(context, 0,books);
        this.books=books;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.custom_row,parent,false);
        TextView title=convertView.findViewById(R.id.txt_title);
        TextView author=convertView.findViewById(R.id.txt_author);
        ImageView imageView=convertView.findViewById(R.id.img);
        RatingBar ratingBar=convertView.findViewById(R.id.rating);
        ImageView clear=convertView.findViewById(R.id.clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setTitle("Warning!")
                        .setMessage("Are you sure you want to delete this book?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                books.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialog.dismiss();
                            }
                        });
                dialog=builder.create();
                dialog.show();
            }
        });

        BookDetails bookDetails=getItem(position);
        title.setText(bookDetails.getTitle());
        author.setText(bookDetails.getAuthor());
        imageView.setImageResource(bookDetails.getImageId());
        ratingBar.setRating(bookDetails.getRatingBar());

        return convertView;
    }
}
