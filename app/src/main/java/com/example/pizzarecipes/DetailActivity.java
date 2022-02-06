package com.example.pizzarecipes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        ImageView imageView = findViewById(R.id.imageView);
        TextView titleTextView = findViewById(R.id.textView1);
        TextView summaryTextView = findViewById(R.id.textView2);

        imageView.setImageResource(intent.getIntExtra("imageResource", 0));

        titleTextView.setText(intent.getStringExtra("title"));
        summaryTextView.setText(intent.getStringExtra("summary"));
    }
}