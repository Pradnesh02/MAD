package com.example.menudemoapp;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btnPopup = findViewById(R.id.btnPopup);

        // Register context menu
        registerForContextMenu(textView);

        // -------- POPUP MENU --------
        btnPopup.setOnClickListener(view -> {

            PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {

                if (item.getItemId() == R.id.popup_edit) {
                    Toast.makeText(MainActivity.this, "Edit Clicked", Toast.LENGTH_SHORT).show();

                } else if (item.getItemId() == R.id.popup_delete) {
                    Toast.makeText(MainActivity.this, "Delete Clicked", Toast.LENGTH_SHORT).show();
                }

                return true;
            });

            popupMenu.show();
        });
    }

    // -------- OPTIONS MENU --------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_settings) {
            Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.menu_about) {
            Toast.makeText(this, "About Clicked", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.menu_exit) {
            finish();
        }

        return true;
    }

    // -------- CONTEXT MENU --------
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Context Menu");

        menu.add(0, v.getId(), 0, "Option 1");
        menu.add(0, v.getId(), 1, "Option 2");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle().equals("Option 1")) {
            Toast.makeText(this, "Option 1 selected", Toast.LENGTH_SHORT).show();

        } else if (item.getTitle().equals("Option 2")) {
            Toast.makeText(this, "Option 2 selected", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}