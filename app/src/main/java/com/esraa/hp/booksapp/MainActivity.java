package com.esraa.hp.booksapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list);


        ArrayList<BookDetails> books=new ArrayList<>();
        books.add(new BookDetails("One Hundred Years of Solitude ","by Gabriel García Márquez",R.drawable.solitude,3.5f));
        books.add(new BookDetails("Terra Nostra ","Carlos Fuentes",R.drawable.nostra,3));
        books.add(new BookDetails("Angels & Demons ","by Dan Brown",R.drawable.angels,4));
        books.add(new BookDetails("The Sword Thief  "," by Peter Lerangis",R.drawable.sword,2));
        books.add(new BookDetails("Inferno","by Dan Brown",R.drawable.inferno,4.5f));
        books.add(new BookDetails("Bloodline ","by James Rollins",R.drawable.blood,2));
        books.add(new BookDetails("The House of the Spirits ","by Isabel Allende",R.drawable.spirits,3));
        books.add(new BookDetails("The Hummingbird's Daughter ","by Luis Alberto Urrea ",R.drawable.humming,3.5f));


        BookAdapter adapter=new BookAdapter(this,books);
        listView.setAdapter(adapter);





    }
}
