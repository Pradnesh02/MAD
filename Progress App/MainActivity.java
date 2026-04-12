package com.example.progressapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button btn;
    RatingBar ratingBar;

    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link views correctly
        progressBar = findViewById(R.id.progress2);
        btn = findViewById(R.id.btn);
        ratingBar = findViewById(R.id.ratingBar);

        // Button click
        btn.setOnClickListener(v -> {
            progress += 10;

            if (progress > 100) {
                progress = 0; // reset to avoid crash
            }

            progressBar.setProgress(progress);
        });

        // Rating bar
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            Toast.makeText(MainActivity.this,
                    "Rating: " + rating,
                    Toast.LENGTH_SHORT).show();
        });
    }
}