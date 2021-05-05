package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Integer fstCounter = 0;
    private Integer sndCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("fstCount", fstCounter);
        outState.putInt("sndCount", sndCounter);
        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        fstCounter = savedInstanceState.getInt("fstCount");
        sndCounter = savedInstanceState.getInt("sndCount");
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void onClickFirstButton(View view) {
        fstCounter++;
        TextView fstTextCounter = findViewById(R.id.fstTeamCounter);
        fstTextCounter.setText(fstCounter.toString());
    }

    public void onClickSecondButton(View view) {
        sndCounter++;
        TextView sndTextCounter = findViewById(R.id.sndTeamCounter);
        sndTextCounter.setText(sndCounter.toString());
    }

    public void onClickResetButton(View view) {
        fstCounter = 0;
        sndCounter = 0;

        TextView fstTextCounter = findViewById(R.id.fstTeamCounter);
        fstTextCounter.setText(fstCounter.toString());
        TextView sndTextCounter = findViewById(R.id.sndTeamCounter);
        sndTextCounter.setText(sndCounter.toString());
    }
}
