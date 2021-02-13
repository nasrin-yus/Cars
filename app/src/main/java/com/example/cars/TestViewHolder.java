package com.example.cars;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TestViewHolder extends RecyclerView.ViewHolder {
    TextView txttype;
    TextView txtlat;
    TextView txtlong;
    ImageView  imgcar;
    public TestViewHolder(@NonNull View itemView) {
        super(itemView);
        txttype = itemView.findViewById(R.id.txttype);
        txtlat = itemView.findViewById(R.id.txtlat);
        txtlong = itemView.findViewById(R.id.txtlong);
        imgcar=itemView.findViewById(R.id.imgcar);


    }
}
