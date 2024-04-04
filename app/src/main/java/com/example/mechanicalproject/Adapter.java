package com.example.mechanicalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Model> viewList;

    public Adapter(List<Model> viewList) {
        this.viewList = viewList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.loads,parent,false);


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model = viewList.get(position);
        holder.Distance.setText(model.distance);
        holder.DistanceCount.setText(model.distanceCount);
        holder.Magnitude.setText(model.magnitude);
        holder.MagnitudeCount.setText(model.magnitudeCount);
        holder.imageView.setImageResource(model.back);
    }

    @Override
    public int getItemCount() {
        return viewList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView Distance, DistanceCount;
        TextView Magnitude, MagnitudeCount;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Distance = itemView.findViewById(R.id.distance);
            DistanceCount = itemView.findViewById(R.id.distanceCount);
            Magnitude = itemView.findViewById(R.id.mag);
            MagnitudeCount = itemView.findViewById(R.id.magCount);
            imageView = itemView.findViewById(R.id.loads_back);
        }
    }


}
