package com.example.librarydb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LibraryActivity extends AppCompatActivity {
    Cursor cursor;
    RecyclerView recyclerView;
    MyAdapter adapter;
    SQLiteDatabase mDb;
    Button button;
    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        recyclerView = findViewById(R.id.library);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        Database mDBHelper = new Database(this);
        mDBHelper.updateDataBase();
        mDb = mDBHelper.getWritableDatabase();

        cursor = mDb.rawQuery("SELECT * FROM books", null);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        adapter = new MyAdapter(this, cursor);
        recyclerView.setAdapter(adapter);


        button = findViewById(R.id.buttonSearch);
        search = findViewById(R.id.search);
        //проверяем, есть ли пользователь в памяти телефона
        SharedPreferences preferences = getSharedPreferences("users", MODE_PRIVATE);
        if (preferences.getString("login", null) != null) {
            button.setVisibility(View.VISIBLE);
            search.setVisibility(View.VISIBLE);
        } else {
            button.setVisibility(View.INVISIBLE);
            search.setVisibility(View.INVISIBLE);
        }
    }

    public void search(View view) {
        String text = search.getText().toString();
        try {
            cursor = mDb.rawQuery("SELECT * FROM books WHERE title like ? ",
                    new String[]{"%" + text + "%"}, null);
            if (cursor != null && cursor.moveToFirst()) {
                adapter = new MyAdapter(this, cursor);
                recyclerView.setAdapter(adapter);
            }
        } catch (Exception e) {
            Toast.makeText(this, "Книга не найдена!", Toast.LENGTH_LONG).show();
        }
    }
}
