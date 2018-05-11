package com.example.thymen.restaurant;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements MenuRequest.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        MenuRequest menuRequest = new MenuRequest(this);
        menuRequest.getMenu(this);

        ListView listView = findViewById(R.id.listviewMenu);
        ListItemClickListener click = new ListItemClickListener();
        listView.setOnItemClickListener(click);

    }
    @Override
    public void gotMenu(ArrayList<MenuItem> menu) {
        ArrayAdapter<MenuItem> adapter = new CustomLayout(this, R.layout.custom_layout, menu);
        ListView listView = findViewById(R.id.listviewMenu);
        listView.setAdapter(adapter);
    }

    @Override
    public void gotMenuError(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_LONG).show();
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            MenuItem clickedItem = (MenuItem) parent.getItemAtPosition(position);

            Intent intent = new Intent(MenuActivity.this, MenuItemActivity.class);
            intent.putExtra("clickedItem", clickedItem);
            startActivity(intent);
        }
    }
}
