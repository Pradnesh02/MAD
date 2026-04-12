package com.example.alerttoastapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAlert, btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI components
        btnAlert = findViewById(R.id.btnAlert);
        btnToast = findViewById(R.id.btnToast);

        // Toast Button
        btnToast.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this,
                    "This is a Toast message",
                    Toast.LENGTH_SHORT).show();
        });

        // Alert Dialog Button
        btnAlert.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder.setTitle("Alert")
                    .setMessage("Do you want to continue?")
                    .setCancelable(false)

                    .setPositiveButton("Yes", (dialog, which) -> {
                        Toast.makeText(MainActivity.this,
                                "You clicked YES",
                                Toast.LENGTH_SHORT).show();
                    })

                    .setNegativeButton("No", (dialog, which) -> {
                        Toast.makeText(MainActivity.this,
                                "You clicked NO",
                                Toast.LENGTH_SHORT).show();
                    });

            // Show dialog
            builder.create().show();
        });
    }
}