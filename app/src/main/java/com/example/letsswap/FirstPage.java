package com.example.letsswap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);
        Button button = (Button) findViewById(R.id.button);
    }
    public void onClick(View v){
        Intent button = new Intent(this, SignIn.class) ;
        startActivity(button);
    }
}