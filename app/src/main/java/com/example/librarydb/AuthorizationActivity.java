package com.example.librarydb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.awt.Cursor;

public class AuthorizationActivity extends AppCompatActivity {
    Cursor cursor;
    private SQLiteDatabase mDb;
    EditText login;
    EditText password;
    Button button;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);

        Database mDBHelper = new Database(this);
        mDBHelper.updateDataBase();
        mDb = mDBHelper.getWritableDatabase();

        preferences = getSharedPreferences("users", MODE_PRIVATE);
        if (preferences.getString("login", null) != null) {
            button = findViewById(R.id.btnExit);
            button.setVisibility(View.VISIBLE);
        }

        preferences = getSharedPreferences("users", MODE_PRIVATE);
    }

    public void onClickBtnAuthorization(View view) {
        if (login.getText().toString().trim().matches("") ||
                password.getText().toString().trim().matches("")) {
            Toast.makeText(this, "Заполните поля ввода!", Toast.LENGTH_LONG).show();
            return;
        }

        cursor = mDb.rawQuery("SELECT * FROM users WHERE login = '" +
                login.getText().toString() + "'", null);
        if (cursor != null && cursor.moveToFirst()) {
            if (cursor.getCount() <= 0) {
                Toast.makeText(this, "Пользователя не существует!", Toast.LENGTH_LONG).show();
                return;
            }
            if (cursor.getString(2).equals(password.getText().toString())) {
                Intent intent = new Intent(this, LibraryActivity.class);
                //пользователь заносится в память телефона
                editor = preferences.edit();
                editor.putString("login", login.getText().toString().trim());
                editor.apply();
                startActivity(intent);
            } else {
                Toast.makeText(this, "Пароль неверен!", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onClickBtnExit(View view){
        //удаление пользователя
        editor = preferences.edit();
        editor.remove("boolean");
        editor.apply();
        button.setVisibility(View.INVISIBLE);
    }
}
