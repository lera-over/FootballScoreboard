package com.example.trafficlight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout backgroundColor;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backgroundColor = findViewById(R.id.background);
    }

    /**
     * При нажатии на красную кнопку - меняет цвет фона на красный
     */
    public void onRedButtonClick(View view) {
        backgroundColor.setBackgroundColor(getResources().getColor(R.color.red));
    }

    /**
     * При нажатии на желтую кнопку - меняет цвет фона на желтый
     */
    public void onYellowButtonClick(View view) {
        backgroundColor.setBackgroundColor(getResources().getColor(R.color.yellow));
    }

    /**
     * При нажатии на зеленую кнопку - меняет цвет фона на зеленый
     */
    public void onGreenButtonClick(View view) {
        backgroundColor.setBackgroundColor(getResources().getColor(R.color.green));
    }

}
