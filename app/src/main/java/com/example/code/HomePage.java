package com.example.letsswap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    Button GoBtn;
    Button AddBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        GoBtn = (Button) findViewById(R.id.gotocat);
        AddBtn = (Button) findViewById(R.id.add);

        GoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(HomePage.this, Bookshelf.class) ;
                    startActivity(intent);
            }
        });


        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, Add.class) ;
                startActivity(intent);
            }
        });
    }

}