package com.example.cars;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
        RecyclerView recycler;
         ArrayList<String> type,url;
         ArrayList<Double> lat,lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AsyncHttpClient client=new AsyncHttpClient();
        client.get("https://pouyaheydari.com/vehicles.json",new  JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Gson gson=new Gson();
                type = new ArrayList<>();
                url = new ArrayList<>();
                lat = new ArrayList<>();
                lng = new ArrayList<>();

                ViewModel model = gson.fromJson(response.toString(), ViewModel.class);
                for(int i=0; i < model.getVehicles().size();i++) {
                    type.add("Type : "+model.getVehicles().get(i).getType().toString());
                    lat.add(model.getVehicles().get(i).getLat());
                    lng.add(model.getVehicles().get(i).getLng());
                    url.add(model.getVehicles().get(i).getImageUrl());
                }
                recycler=findViewById(R.id.Myrecycler);
                LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false);
                recycler.setLayoutManager(manager);
                carAdapter adapter = new carAdapter(type,lat,lng,url);
                recycler.setAdapter(adapter);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(MainActivity.this, "error" , Toast.LENGTH_SHORT).show();

            }
        });




    }
}