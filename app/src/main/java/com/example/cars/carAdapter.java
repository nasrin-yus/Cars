package com.example.cars;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class carAdapter extends RecyclerView.Adapter<TestViewHolder> {
    ArrayList<String> type, url;
    ArrayList<Double> lat, lng;

    public carAdapter(ArrayList<String> type,ArrayList<Double> lat,ArrayList<Double> lng,ArrayList<String> url) {

        this.type = type;
        this.lat = lat;
        this.lng = lng;
        this.url = url;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_recycler, parent, false);
        TestViewHolder holder = new TestViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        holder.txttype.setText(type.get(position));
        holder.txtlat.setText("lat:" + lat.get(position).toString());
        holder.txtlong.setText("long:" + lng.get(position).toString());
        Picasso.get().load(url.get(position)).fit().into(holder.imgcar);
    }

    @Override

    public int getItemCount() {
        int i = 0;
        if (type != null)
            i = type.size();
        return i;
    }

}