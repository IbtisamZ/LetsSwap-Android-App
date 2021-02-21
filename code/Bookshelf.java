package com.example.letsswap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bookshelf extends AppCompatActivity {
    Button History ;
    Button Science ;
    Button Religion ;
    Button Philosophy ;
    Button Sci_Fi ;
    Button Politics ;
    Button Mystery ;
    Button Poetry ;
    Button Romance ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookshelf);
        History = (Button) findViewById(R.id.HisBtn);
        Science = (Button) findViewById(R.id.SciBtn);
        Religion = (Button) findViewById(R.id.RelBtn);
        Philosophy = (Button) findViewById(R.id.PhyBtn);
        Sci_Fi = (Button) findViewById(R.id.SifiBtn);
        Politics = (Button) findViewById(R.id.PolBtn);
        Mystery = (Button) findViewById(R.id.MysBtn);
        Poetry = (Button) findViewById(R.id.PoeBtn);
        Romance = (Button) findViewById(R.id.RomBtn);

        History.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent in = new Intent(Bookshelf.this,History.class);
               startActivity(in);
           }
        });
        Science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Bookshelf.this,Science.class);
                startActivity(in);
            }
        });
        Religion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Bookshelf.this,Religion.class);
                startActivity(in);
            }
        });
        Philosophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Bookshelf.this,Philosophy.class);
                startActivity(in);
            }
        });
        Sci_Fi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Bookshelf.this,SciFi.class);
                startActivity(in);
            }
        });
        Politics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Bookshelf.this,Politics.class);
                startActivity(in);
            }
        });
        Mystery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Bookshelf.this,Mystery.class);
                startActivity(in);
            }
        });
        Poetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Bookshelf.this,Poetry.class);
                startActivity(in);
            }
        });
        Romance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Bookshelf.this,Romance.class);
                startActivity(in);
            }
        });
    }
}