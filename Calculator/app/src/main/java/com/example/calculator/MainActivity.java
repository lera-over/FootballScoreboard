package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bakaeva.textcalculator.R;

public class MainActivity extends AppCompatActivity {
    private EditText element1, element2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        element1 = findViewById(R.id.num1);
        element2 = findViewById(R.id.num2);
    }

    @SuppressLint("SetTextI18n")
    public void onButtonClick(View view) {

        try {
            int num1 = Integer.parseInt(element1.getText().toString());
            int num2 = Integer.parseInt(element2.getText().toString());
            int resSum = num1 + num2;
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("First", num1);
            intent.putExtra("Second", num2);
            intent.putExtra("Result", resSum);
            startActivity(intent);
        }
        catch (NumberFormatException e) {
            Toast.makeText(this, "Значения не введены или введены неправильно!", Toast.LENGTH_LONG).show();
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("element1", element1.getText().toString());
        outState.putString("element2", element2.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        element1.setText(savedInstanceState.getString("element1"));
        element2.setText(savedInstanceState.getString("element2"));

        super.onRestoreInstanceState(savedInstanceState);
    }
}