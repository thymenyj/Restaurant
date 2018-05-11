package com.example.thymen.restaurant;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MenuRequest implements Response.Listener<JSONObject>, Response.ErrorListener {
    public Callback activity;
    public Context context;

    public interface Callback {
        void gotMenu(ArrayList<MenuItem> menu);
        void gotMenuError(String message);
    }

    public MenuRequest(Context context) {
        this.context = context;
    }

    public void getMenu(Callback activity) {
        this.activity = activity;
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("https://resto.mprog.nl/menu", null, this, this);
        queue.add(jsonObjectRequest);
    }

    public void onResponse(JSONObject response) {
        try {
            JSONArray array = response.getJSONArray("items");
            int length = array.length();
            ArrayList<MenuItem> menu = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                MenuItem menuItem = new MenuItem();
                JSONObject item = array.getJSONObject(i);
                String category = item.getString("category");
                String description = item.getString("description");
                String price = item.getString("price");
                String imageUrl = item.getString("image_url");
                String name = item.getString("name");

                menuItem.setCategory(category);
                menuItem.setDescription(description);
                menuItem.setPrice(price);
                menuItem.setImageUrl(imageUrl);
                menuItem.setName(name);
                menu.add(menuItem);
            }
            activity.gotMenu(menu);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("RESPONSE", response.toString());
        }
    }

    public void onErrorResponse(VolleyError error) {
        String message = error.getMessage();
        activity.gotMenuError(message);
    }

}
