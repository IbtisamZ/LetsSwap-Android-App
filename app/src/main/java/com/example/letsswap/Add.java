package com.example.letsswap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Add extends AppCompatActivity {
    private ImageView imageSelected;
    EditText book_name, book_state, book_price, contact_info;
    byte[] image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final Spinner book_cat = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(Add.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.categories));
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        book_cat.setAdapter(Adapter);

        imageSelected = (ImageView) findViewById(R.id.select_img);
        book_name = findViewById(R.id.BookName);
        book_state = findViewById(R.id.BookState);
        book_price = findViewById(R.id.Shippingprice);
        contact_info = findViewById(R.id.contactinfo);

        findViewById(R.id.select_btn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                selectImage(Add.this);
            }
        });
        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(Add.this);
                String cate = book_cat.getSelectedItem().toString();
                if (book_name.getText().toString().isEmpty() || book_price.getText().toString().isEmpty() || book_state.getText().toString().isEmpty() || contact_info.getText().toString().isEmpty() ) {
                    Toast.makeText(Add.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean add = db.addBook(book_name.getText().toString().trim(),
                            cate.trim(),
                            book_price.getText().toString().trim(),
                            book_state.getText().toString().trim(),
                            contact_info.getText().toString().trim(),
                            image);


                    if (add == true) {
                        Toast.makeText(Add.this, "Added successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomePage.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Add.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
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
    public  byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
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
                        // InputStream is = getApplicationContext().getContentResolver().openInputStream(data.getData());
                        Uri uri = data.getData();
                        imageSelected.setImageURI(uri);
                        Bitmap bitmap = null;
                        try {
                            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        image = getBytes(bitmap);

                    }
                    break;
            }
        }
    }


}

