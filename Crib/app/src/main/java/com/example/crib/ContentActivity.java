package com.example.crib;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ContentActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        webView = findViewById(R.id.webView);

        int position = getIntent().getIntExtra("story_key", 0);

        if (position == 0) {
            webView.loadUrl("file:///android_asset/Photoshop.html");
        }
        if (position == 1) {
            webView.loadUrl("file:///android_asset/Illustrator.html");
        }
        if (position == 2) {
            webView.loadUrl("file:///android_asset/InDesign.html");
        }
        if (position == 3) {
            webView.loadUrl("file:///android_asset/AfterEffect.html");
        }
        if (position == 4) {
            webView.loadUrl("file:///android_asset/Lightroom.html");
        }
        webView.setWebViewClient(new MyWebViewClient());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class MyWebViewClient extends WebViewClient {
        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }
}

