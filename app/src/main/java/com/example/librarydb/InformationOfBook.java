package com.example.librarydb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InformationOfBook extends AppCompatActivity {
    Cursor cursor;
    Button button1;
    Button button2;
    Database mDBHelper;
    SQLiteDatabase mDb;
    String login;
    int result;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_of_book);
        Intent intent = getIntent();
        mDBHelper = new Database(this);
        mDBHelper.updateDataBase();
        mDb = mDBHelper.getWritableDatabase();
        String book = "";
        result = intent.getIntExtra("key", 0);
        cursor = mDb.rawQuery("SELECT * FROM books WHERE id=" + result, null);
        cursor.moveToFirst();
        book += "Автор: " + cursor.getString(1) + '\n' + "Название: " + cursor.getString(2) + '\n'
                + "Жанр: " + cursor.getString(3) + '\n' + "Год издания" + cursor.getString(4) + " г." + '\n'
                + "Описание: " + '\n' + cursor.getString(5) + '\n';
        cursor.close();
        TextView textView = findViewById(R.id.informationOfBook);
        textView.setText(book);

        SharedPreferences preferences = getSharedPreferences("users", MODE_PRIVATE);
        login = preferences.getString("login", null);
        button1 = findViewById(R.id.addBook);
        button2 = findViewById(R.id.basket);
        if (login != null) {
            button1.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
        } else {
            button1.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
        }
    }

    @SuppressLint("SetTextI18n")
    public void addBookToBasket(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", result);
        contentValues.put("login", login);
        mDb.insertWithOnConflict("basket", null, contentValues, SQLiteDatabase.CONFLICT_NONE);
        Toast.makeText(this, "Книга добавлена в корзину", Toast.LENGTH_LONG).show();
        cursor = mDb.rawQuery("SELECT * FROM basket", null);
        if(cursor.moveToFirst()){
            int idIndex = cursor.getColumnIndex("id");
            int loginIndex = cursor.getColumnIndex("login");
            do {
                Log.d("id/login", cursor.getString(idIndex) + "/" + cursor.getString(loginIndex));
            } while (cursor.moveToNext());
        }
        cursor.close();
    }

    public void onClickBtnBasket(View view){
        Intent intent = new Intent(this, BasketActivity.class);
        startActivity(intent);
    }
}
