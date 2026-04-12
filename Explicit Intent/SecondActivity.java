package com.example.explicitintent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtInfo = findViewById(R.id.txtInfo);

        // Receiving Data
        String name = getIntent().getStringExtra("name");
        String roll = getIntent().getStringExtra("roll");
        String batch = getIntent().getStringExtra("batch");

        txtInfo.setText(
                "Name: " + name +
                        "\nRoll No: " + roll +
                        "\nBatch: " + batch
        );
    }
}
