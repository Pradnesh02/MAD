package com.example.simplecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Spinner spinnerOperation;
    Button btnSubmit, btnAdd, btnSub, btnMul, btnDiv;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        spinnerOperation = findViewById(R.id.spinnerOperation);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        tvResult = findViewById(R.id.tvResult);

        // Spinner Submit Button
        btnSubmit.setOnClickListener(v -> {
            String operation = spinnerOperation.getSelectedItem().toString();
            calculate(operation);
        });

        // Separate Buttons
        btnAdd.setOnClickListener(v -> calculate("Addition"));
        btnSub.setOnClickListener(v -> calculate("Subtraction"));
        btnMul.setOnClickListener(v -> calculate("Multiplication"));
        btnDiv.setOnClickListener(v -> calculate("Division"));
    }

    private void calculate(String operation) {

        if(number1.getText().toString().isEmpty() ||
                number2.getText().toString().isEmpty()) {

            Toast.makeText(this,
                    "Please enter both numbers",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(number1.getText().toString());
        double num2 = Double.parseDouble(number2.getText().toString());
        double result = 0;

        switch (operation) {

            case "Addition":
                result = num1 + num2;
                break;

            case "Subtraction":
                result = num1 - num2;
                break;

            case "Multiplication":
                result = num1 * num2;
                break;

            case "Division":
                if(num2 == 0){
                    Toast.makeText(this,
                            "Cannot divide by zero",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 / num2;
                break;
        }

        tvResult.setText("Result: " + result);
    }
}