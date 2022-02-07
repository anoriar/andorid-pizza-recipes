package com.example.pizzarecipes;

import android.content.Context;
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
    Context context;

    public class RecyclerViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
        }


        @Override
        public void onClick(View view) {
            Intent detailIntent = new Intent(view.getContext(), DetailActivity.class);
            int position = getAdapterPosition();
            PizzaRecipeRecyclerViewItem pizzaRecipeItem = arrayList.get(position);

            detailIntent.putExtra("imageResource", pizzaRecipeItem.getImageResource());
            detailIntent.putExtra("title", pizzaRecipeItem.getTitle());
            detailIntent.putExtra("summary", pizzaRecipeItem.getSummary());
            view.getContext().startActivity(detailIntent);
        }
    }

    public RecyclerViewAdapter(ArrayList<PizzaRecipeRecyclerViewItem> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
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
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
