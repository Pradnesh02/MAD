package com.example.implicitintent;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnInstagram, btnSnapchat, btnMaps, btnPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInstagram = findViewById(R.id.btnInstagram);
        btnSnapchat = findViewById(R.id.btnSnapchat);
        btnMaps = findViewById(R.id.btnMaps);
        btnPhone = findViewById(R.id.btnPhone);

        // Instagram
        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApp("com.instagram.android");
            }
        });

        // Snapchat
        btnSnapchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApp("com.snapchat.android");
            }
        });

        // Google Maps
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=India"));
                startActivity(mapIntent);
            }
        });

        // Phone Dialer
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                startActivity(phoneIntent);
            }
        });
    }

    // Method to open apps like Instagram & Snapchat
    private void openApp(String packageName) {
        PackageManager pm = getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage(packageName);

        if (intent != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "App not installed", Toast.LENGTH_SHORT).show();
        }
    }
}
