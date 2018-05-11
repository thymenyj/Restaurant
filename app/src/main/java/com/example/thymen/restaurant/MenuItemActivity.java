package com.example.thymen.restaurant;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MenuItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);

        Intent intent = getIntent();
        MenuItem retrievedItem = (MenuItem) intent.getSerializableExtra("clickedItem");

        TextView category = findViewById(R.id.itemCategory);
        TextView name = findViewById(R.id.itemName);
        TextView description = findViewById(R.id.itemDescription);
        TextView price = findViewById(R.id.itemPrice);
        ImageView photo = findViewById(R.id.itemPhoto);

        category.setText(retrievedItem.getCategory());
        name.setText(retrievedItem.getName());
        description.setText(retrievedItem.getDescription());
        price.setText(retrievedItem.getPrice());

        Picasso.with(getApplicationContext()).load(retrievedItem.getImageUrl()).into(photo);
    }
}
