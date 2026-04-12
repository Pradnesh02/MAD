package com.example.uicontrolsapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    CheckBox checkBox;
    RadioGroup radioGroup;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        checkBox = findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.spinner);

        // Toggle
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(this, isChecked ? "Toggle ON" : "Toggle OFF", Toast.LENGTH_SHORT).show();
        });

        // CheckBox
        checkBox.setOnClickListener(v -> {
            Toast.makeText(this,
                    checkBox.isChecked() ? "Checked" : "Unchecked",
                    Toast.LENGTH_SHORT).show();
        });

        // Radio
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton rb = findViewById(checkedId);
            Toast.makeText(this, rb.getText(), Toast.LENGTH_SHORT).show();
        });

        // Spinner
        String[] items = {"Select", "Java", "Python", "C++"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id) {
                Toast.makeText(MainActivity.this, items[position], Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
}