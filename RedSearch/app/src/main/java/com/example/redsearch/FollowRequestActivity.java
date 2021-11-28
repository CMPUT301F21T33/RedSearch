package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class FollowRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_request);

        Toolbar toolbar = findViewById(R.id.toolbar_follow_requests);
        setSupportActionBar(toolbar);
        setTitle("Follow Requests");
    }
}