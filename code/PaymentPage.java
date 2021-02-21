package com.example.letsswap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PaymentPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_page);
        Button Buy = (Button) findViewById(R.id.buy);
        Buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });
    }
        void confirmDialog(){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Are You Sure?");
            builder.setMessage("Confirm your payment to complete your order.");
            builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(PaymentPage.this, "Your Order is Completed!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PaymentPage.this, Done.class) ;
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(PaymentPage.this, "Your Order is Cancelled!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PaymentPage.this, HomePage.class) ;
                    startActivity(intent);
                }
            });
            builder.create().show();
    }
}