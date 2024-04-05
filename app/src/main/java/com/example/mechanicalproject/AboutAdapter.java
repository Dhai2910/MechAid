package com.example.mechanicalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.ViewHolder>{

    private List<About_Us> aboutUsList;

    public AboutAdapter(List<About_Us> aboutUsList) {
        this.aboutUsList = aboutUsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.aboutus,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        About_Us aboutUs = aboutUsList.get(position);
        holder.About.setText(aboutUs.About);
        holder.image.setImageResource(aboutUs.image);
    }

    @Override
    public int getItemCount() {
        return aboutUsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView About;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            About = itemView.findViewById(R.id.about);
            image = itemView.findViewById(R.id.photo);
        }


    }

}
