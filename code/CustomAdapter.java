package com.example.letsswap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList book_id, book_name, book_price, book_status, cont;
    private ArrayList<byte[]>image;

    CustomAdapter(Activity activity, Context context, ArrayList book_id, ArrayList book_name, ArrayList book_price,
                  ArrayList book_status, ArrayList cont , ArrayList image){
        this.activity = activity;
        this.context = context;
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_price = book_price;
        this.book_status = book_status;
        this.cont = cont;
        this.image=image;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.book_name_txt.setText(String.valueOf(book_name.get(position)));
        holder.book_price_txt.setText("Price: "+String.valueOf(book_price.get(position))+" SR ");
        holder.book_status_txt.setText("Status: "+String.valueOf(book_status.get(position)));
        holder.cont_txt.setText("Contact: "+String.valueOf(cont.get(position)));
        Bitmap bitmap = getImage(image.get(position));
        holder.image.setImageBitmap(bitmap);


        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Checkout.class);
                intent.putExtra("bookName", String.valueOf(book_name.get(position)));
                intent.putExtra("price", String.valueOf(book_price.get(position)));
                intent.putExtra("bookStatus", String.valueOf(book_status.get(position)));
                intent.putExtra("contact", String.valueOf(cont.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }
    public  Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    @Override
    public int getItemCount() {
        return book_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView book_name_txt, book_price_txt, book_status_txt, cont_txt;
        ImageView image;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_name_txt = itemView.findViewById(R.id.book_name_txt);
            book_price_txt = itemView.findViewById(R.id.book_price_txt);
            book_status_txt = itemView.findViewById(R.id.book_status_txt);
            cont_txt = itemView.findViewById(R.id.cont_txt);
            image = itemView.findViewById(R.id.select_img);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
