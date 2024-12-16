package com.luv.cricket;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class HighlightsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highlights);

        WebView webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());

        Intent intent = getIntent();

        String team1 = intent.getStringExtra("team1");
        String team2 = intent.getStringExtra("team2");
        String date = intent.getStringExtra("date");

        webView.loadUrl("https://www.google.com/search?q=" + team1 + "+vs " + team2 + " cricket full highlights " + date);
    }

}
