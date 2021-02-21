package com.example.letsswap;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SciFi extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView empty_imageview;
    TextView no_data;
    DBHelper myDB;
    ArrayList<String> book_id, book_name, book_price, book_status, cont;
    CustomAdapter customAdapter;
    ArrayList<byte[]> image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sci_fi);
        recyclerView = findViewById(R.id.recyclerView);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);

        myDB = new DBHelper(SciFi.this);
        book_id = new ArrayList<>();
        book_name = new ArrayList<>();
        book_price = new ArrayList<>();
        book_status = new ArrayList<>();
        cont = new ArrayList<>();
        image = new ArrayList<>();
        storeDataInArrays();

        customAdapter = new CustomAdapter(SciFi.this, this, book_id, book_name, book_price,
                book_status, cont,image);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(SciFi.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }
    void storeDataInArrays(){
        Cursor cursor = myDB.sciData();
        if(cursor.getCount() == 0){
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                book_id.add(cursor.getString(0));
                book_name.add(cursor.getString(1));
                book_price.add(cursor.getString(3));
                book_status.add(cursor.getString(4));
                cont.add(cursor.getString(5));
                image.add(cursor.getBlob(6));
            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }
}