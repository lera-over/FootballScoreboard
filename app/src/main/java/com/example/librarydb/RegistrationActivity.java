package com.example.librarydb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.awt.Cursor;

public class RegistrationActivity extends AppCompatActivity {
    Cursor cursor;
    private SQLiteDatabase mDb;
    EditText login;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);

        Database mDBHelper = new Database(this);
        mDBHelper.updateDataBase();
        mDb = mDBHelper.getWritableDatabase();
    }

    public void onClickBtnRegistration(View view) {
        if (login.getText().toString().trim().matches("") ||
                password.getText().toString().trim().matches("")) {
            Toast.makeText(this, "Заполните поля ввода!", Toast.LENGTH_LONG).show();
            return;
        }

        if (login.length() < 5 || password.length() < 5) {
            Toast.makeText(this, "Слишком короткий логин или пароль" +
                    '\n' + "(минимум 5 символов)", Toast.LENGTH_LONG).show();
            return;
        }

        cursor = mDb.rawQuery("SELECT * FROM users WHERE login = '" + login.getText().toString() + "'", null);
        if (cursor.getCount() <= 0) {
            mDb.execSQL("INSERT INTO users (login,password) VALUES ('" + login.getText().toString() + "','"
                    + password.getText().toString() + "')");
            Toast.makeText(this, "Добро пожаловать, " + login.getText().toString(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Логин уже существует!", Toast.LENGTH_LONG).show();
        }
    }
}
