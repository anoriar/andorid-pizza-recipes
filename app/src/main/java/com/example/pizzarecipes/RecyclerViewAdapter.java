package com.example.pizzarecipes;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder> {

    ArrayList<PizzaRecipeRecyclerViewItem> arrayList;

    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }

    public RecyclerViewAdapter(ArrayList<PizzaRecipeRecyclerViewItem> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        RecyclerViewViewHolder recyclerViewViewHolder = new RecyclerViewViewHolder(view);
        return recyclerViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, int position) {
        PizzaRecipeRecyclerViewItem recyclerViewItem = this.arrayList.get(position);

        holder.imageView.setImageResource(recyclerViewItem.getImageResource());
        holder.textView1.setText(recyclerViewItem.getTitle());
        holder.textView2.setText(recyclerViewItem.getSummary());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent detailIntent = new Intent(view.getContext(), DetailActivity.class);

                detailIntent.putExtra("imageResource", arrayList.get(position).getImageResource());
                detailIntent.putExtra("title", arrayList.get(position).getTitle());
                detailIntent.putExtra("summary", arrayList.get(position).getSummary());
                view.getContext().startActivity(detailIntent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
