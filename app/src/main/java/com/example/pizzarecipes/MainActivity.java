package com.example.pizzarecipes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initPizzaRecipesRecyclerView();

    }

    private void initPizzaRecipesRecyclerView() {
        ArrayList<PizzaRecipeRecyclerViewItem> recyclerViewItems = new ArrayList<PizzaRecipeRecyclerViewItem>();
        recyclerViewItems.add(new PizzaRecipeRecyclerViewItem(R.drawable.goats_cheese_pizza_c23fce6, getResources().getString(R.string.pizza_1_title), getResources().getString(R.string.pizza_1_summary)));
        recyclerViewItems.add(new PizzaRecipeRecyclerViewItem(R.drawable.marghuerita_6e61fd5, getResources().getString(R.string.pizza_2_title), getResources().getString(R.string.pizza_2_summary)));
        recyclerViewItems.add(new PizzaRecipeRecyclerViewItem(R.drawable.recipe_image_legacy_id_51643_11_2f4a2cc, getResources().getString(R.string.pizza_3_title), getResources().getString(R.string.pizza_3_summary)));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new RecyclerViewAdapter(recyclerViewItems, this.getApplicationContext());
        layoutManager = new GridLayoutManager(this, getResources().getInteger(R.integer.column_count));

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}