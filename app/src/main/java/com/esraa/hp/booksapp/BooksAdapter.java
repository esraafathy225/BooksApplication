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

public class BooksAdapter extends ArrayAdapter<BookDetails> {
    AlertDialog alertDialog;
    ArrayList<BookDetails> objects;

    public BooksAdapter(@NonNull Context context, @NonNull ArrayList<BookDetails> objects) {
        super(context, 0, objects);
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView= LayoutInflater.from(getContext()).inflate(R.layout.custom_row,parent,false);

        TextView title = convertView.findViewById(R.id.txt_title);
        TextView author=convertView.findViewById(R.id.txt_author);
        ImageView img=convertView.findViewById(R.id.img);
        RatingBar ratingBar=convertView.findViewById(R.id.rating);



        final BookDetails bookDetails=getItem(position);

        title.setText(bookDetails.getTitle());
        author.setText(bookDetails.getAuthor());
        img.setImageResource(bookDetails.getImageId());
        ratingBar.setRating(bookDetails.getRatingBar());


        ImageView clear_img=convertView.findViewById(R.id.clear);

        clear_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder= new AlertDialog.Builder(getContext());
                builder.setTitle("Warning!")
                        .setMessage("Do you want to delete this book ? ")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                objects.remove(position);
                                notifyDataSetChanged();
                                alertDialog.dismiss();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                alertDialog.dismiss();
                            }
                        });

                alertDialog=builder.create();
                alertDialog.show();


            }
        });

        return convertView;
    }
}
