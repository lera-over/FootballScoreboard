package com.example.librarydb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BasketActivity extends AppCompatActivity {
    Cursor cursor;
    Database mDBHelper;
    SQLiteDatabase mDb;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        SharedPreferences preferences = getSharedPreferences("users", MODE_PRIVATE);
        mDBHelper = new Database(this);
        mDBHelper.updateDataBase();
        mDb = mDBHelper.getWritableDatabase();
        String login = preferences.getString("login", null);
        cursor = mDb.query("basket", new String[]{"id"}, "login = ?", new String[]{login}, null, null, null);
        int[] args = new int[cursor.getCount()];
        if (cursor.moveToFirst()) {
            for (int i = 0; i < args.length; i++) {
                args[i] = cursor.getInt(cursor.getColumnIndex("id"));
                cursor.moveToNext();
            }
        }
        cursor.close();
        String idArgs = getArgs(args);
        Log.d("ids", idArgs);
        cursor = mDb.rawQuery("SELECT author, title FROM books WHERE " + idArgs, null);
        if (cursor.moveToFirst()) {
            TextView textView = findViewById(R.id.informationOfBasket);
            textView.setText("В вашей корзине: " + '\n');
            int idAuthor = cursor.getColumnIndex("author");
            int idTitle = cursor.getColumnIndex("title");
            String author;
            String title;
            do {
                author = cursor.getString(idAuthor);
                title = cursor.getString(idTitle);
                textView.setText(textView.getText().toString() + author + " " + title + '\n');
            } while (cursor.moveToNext());
        }
    }

    public String getArgs(int[] args) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i == args.length - 1) {
                text.append("id = ").append(args[i]);
            } else {
                text.append("id = ").append(args[i]).append(" or ");
            }
        }
        return text.toString();
    }

    public void onClickBtnOrder(View view){
        Toast.makeText(this, "Заказ выполнен!" + '\n' + "Заберите книги в библиотеке", Toast.LENGTH_LONG).show();
    }
}
