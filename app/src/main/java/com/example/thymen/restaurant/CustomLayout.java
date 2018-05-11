package com.example.thymen.restaurant;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class CustomLayout extends ArrayAdapter<MenuItem> {

    private ArrayList<MenuItem> item;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MenuItem object = item.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_layout, parent, false);
        }
        TextView name = convertView.findViewById(R.id.nameItem);
        TextView price = convertView.findViewById(R.id.priceItem);

        name.setText(object.getName());
        price.setText(object.getPrice());

//        Error You must pass in a non null View
//        ImageView photo = convertView.findViewById(R.id.itemPhoto);
//        Glide.with(getContext()).load(object.getImageUrl()).into(photo);

        return convertView;
    }

    public CustomLayout(@NonNull Context context, int resource, @NonNull ArrayList<MenuItem> objects) {
        super(context, resource, objects);

        item = objects;

    }
}

