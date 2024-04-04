package com.example.mechanicalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MenuViewHolder> {

    private List<menu> menuItems;

    public ItemClickListener clickListener;

    public void setClickListener(ItemClickListener myListener){
        this.clickListener = myListener;
    }

    public CustomAdapter(List<menu> menuItems) {
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_layout,parent,false);


        return new MenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {

        menu menu = menuItems.get(position);
        holder.text.setText(menu.text);
        holder.back.setImageResource(menu.back);
        holder.imageView.setImageResource(menu.img);


    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public class MenuViewHolder extends
            RecyclerView.ViewHolder implements View.OnClickListener{
        TextView text;
        ImageView back;
        ImageView imageView;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            back = itemView.findViewById(R.id.imageView);
            imageView = itemView.findViewById(R.id.img);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener != null){
                clickListener.onClick(v,getAdapterPosition());
            }
        }
    }
}
