package com.example.crib;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class ContentActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        webView = findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/" +getIntent().getStringExtra("story_key"));
    }

}
