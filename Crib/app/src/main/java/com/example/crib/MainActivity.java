package com.example.crib;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] mTitle = {"Photoshop", "Illustrator", "InDesign", "After Effects", "Lightroom",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] mTitle = {"Photoshop", "Illustrator", "InDesign", "After Effects", "Lightroom",};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mTitle);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                intent.putExtra("story_key", mTitle[position] + ".html");
                startActivity(intent);
            }
        });
    }
}
