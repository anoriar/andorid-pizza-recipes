package com.example.pizzarecipes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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
        recyclerViewItems.add(new PizzaRecipeRecyclerViewItem(R.drawable.goats_cheese_pizza_c23fce6, "Next level Margherita pizza", "Forget takeaways – you can’t beat a homemade Margherita pizza topped with fresh tomato sauce and melted cheese. Here's how to master this everyday classic..."));
        recyclerViewItems.add(new PizzaRecipeRecyclerViewItem(R.drawable.marghuerita_6e61fd5, "Pizza Margherita in 4 easy steps", "Even a novice cook can master the art of pizza with our simple step-by-step guide. Bellissimo!"));
        recyclerViewItems.add(new PizzaRecipeRecyclerViewItem(R.drawable.recipe_image_legacy_id_51643_11_2f4a2cc, "Caramelised onion & goat's cheese pizza", "Make a veggie pizza that's healthy and low-fat instead of ordering a takeaway. This easy recipe uses goat's cheese for tang while the onions give it sweetness"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new RecyclerViewAdapter(recyclerViewItems, this.getApplicationContext());
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}