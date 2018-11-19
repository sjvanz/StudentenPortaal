package com.example.user.studentportaal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class PortalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);
        WebView browser = findViewById(R.id.browser);
        final Portal portal = getIntent().getParcelableExtra(MainActivity.VIEW_PORTAL);

        browser.loadUrl(portal.getUrl());
    }
}
