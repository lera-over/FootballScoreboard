package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.bakaeva.textcalculator.R;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = findViewById(R.id.expression);

        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            Integer num1 = arguments.getInt("First");
            Integer num2 = arguments.getInt("Second");
            Integer resSum = arguments.getInt("Result");

            if (resSum >= 0)  {
                textView.setText(num1 + " + " + num2 + " = " + resSum);
            }
            else {
                textView.setText(num1 + " + " + num2 + " = " + resSum);
            }
        }
    }
}
