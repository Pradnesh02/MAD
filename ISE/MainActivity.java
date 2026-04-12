package com.example.studentlistapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    static ArrayList<String> students = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String roll = intent.getStringExtra("roll");
        String phone = intent.getStringExtra("phone");

        if(name != null && phone != null){
            students.add("Name: " + name + "\nRoll: " + roll + "\nPhone: " + phone);
        }

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                students
        );

        listView.setAdapter(adapter);
    }
}