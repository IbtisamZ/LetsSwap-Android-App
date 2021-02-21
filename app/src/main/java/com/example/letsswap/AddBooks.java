package com.example.letsswap;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.net.Uri;
import android.widget.EditText;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.widget.Toast;


public class AddBooks extends AppCompatActivity {


    private ImageView imageSelected;
    EditText book_name, book_state, book_price, contact_info, book_cat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_books);

/*
        imageSelected = (ImageView) findViewById(R.id.select_img);
        book_name = findViewById (R.id.BookName);
        book_cat = findViewById (R.id.BookCat);
        book_state = findViewById (R.id.BookState);
        book_price = findViewById (R.id.Shippingprice);
        contact_info = findViewById (R.id.contactinfo);


        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                DBHelper db = new DBHelper(AddBooks.this);
                db.addBook(book_name.getText().toString().trim(),
                        book_cat.getText().toString().trim(),
                        Integer.valueOf(book_price.getText().toString().trim()),
                        book_state.getText().toString().trim(),
                        Integer.valueOf(contact_info.getText().toString().trim()));

                Toast.makeText(AddBooks.this, "Added successfully", Toast.LENGTH_SHORT).show();
            }});



        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });



        findViewById(R.id.select_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage(AddBooks.this);
            }
        });
    }


    private void selectImage(Context context) {
        final CharSequence[] options = {"Take a picture", "Choose from gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose a picture");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("Take a picture")) {
                    Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, 0);

                } else if (options[item].equals("Choose from gallery")) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto, 1);//one can be replaced with any action code

                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            switch (requestCode) {
                case 0:
                    if (resultCode == RESULT_OK && data != null) {
                        Bitmap selectedImage = (Bitmap) data.getExtras().get("data");
                        imageSelected.setImageBitmap(selectedImage);
                    }

                    break;
                case 1:
                    if (resultCode == RESULT_OK && data != null) {
                        Uri selectedImage = data.getData();
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        if (selectedImage != null) {
                            Cursor cursor = getContentResolver().query(selectedImage,
                                    filePathColumn, null, null, null);
                            if (cursor != null) {
                                cursor.moveToFirst();

                                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                                String picturePath = cursor.getString(columnIndex);
                                imageSelected.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                                cursor.close();
                            }
                        }

                    }
                    break;
            }
        }
    }



    private void goBack(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);

    }*/

    }
}










