package com.example.thymen.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements MenuRequest.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        MenuRequest menuRequest = new MenuRequest(this);
        menuRequest.getMenu(this);

    }
    @Override
    public void gotMenu(ArrayList<MenuItem> menu) {
        ArrayAdapter<MenuItem> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menu);
        ListView listView = findViewById(R.id.listviewMenu);
        listView.setAdapter(adapter);
    }

    @Override
    public void gotMenuError(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_LONG).show();
    }

}
