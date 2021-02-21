package com.example.letsswap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Checkout extends AppCompatActivity {

    TextView name_output, price_output;
    String name, price;
    Button checkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        name_output = findViewById(R.id.name_output);
        price_output = findViewById(R.id.price_output);
        checkout = (Button) findViewById(R.id.checkout);


        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Checkout.this, PaymentPage.class);
                startActivity(intent);
            }
        });

        getAndSetIntentData();
    }

    void getAndSetIntentData() {
        if (getIntent().hasExtra("bookName") && getIntent().hasExtra("price")) {
            //Getting Data from Intent
            name = getIntent().getStringExtra("bookName");
            price = getIntent().getStringExtra("price");

            //Setting Intent Data
            name_output.setText(name);
            price_output.setText(price + " SR ");

          //  Log.d("stev", name + " " + price);
        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}
