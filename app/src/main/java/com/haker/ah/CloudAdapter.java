package com.haker.ah;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by js on 2018-05-28.
 */

public class CloudAdapter extends RecyclerView.Adapter<CloudAdapter.MyViewHolder>{
    private ArrayList<CloudData> mDataset;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, lan, lon;

        //ViewHolder
        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
        }
    }

    public CloudAdapter(ArrayList<CloudData> myData){
        this.mDataset = myData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cloud_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CloudAdapter.MyViewHolder holder, int position) {

        holder.name.setText(mDataset.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
