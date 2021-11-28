package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        Toolbar toolbar = findViewById(R.id.toolbar_friends);
        setSupportActionBar(toolbar);
        setTitle("Friends");
    }

    public void goToSearchUsers(View view) {
        Intent intent = new Intent(this, SearchUsersActivity.class);
        startActivity(intent);
    }

    public void goToFollowRequest(View view) {
        Intent intent = new Intent(this, FollowRequestActivity.class);
        startActivity(intent);
    }
}