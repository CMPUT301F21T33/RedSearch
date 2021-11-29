package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FollowRequestActivity extends AppCompatActivity {
    DataBaseAccess db = new DataBaseAccess();
    FollowRequestAdapter adapter;
    public static final String USERNAME = "com.example.redsearch.USERNAME";
    public String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_request);

        Toolbar toolbar = findViewById(R.id.toolbar_follow_requests);
        setSupportActionBar(toolbar);
        setTitle("Follow Requests");

        Intent intent = getIntent();
        username = intent.getStringExtra(FriendsActivity.USERNAME);

        ListView list = (ListView) findViewById(R.id.listView);
        ArrayList<String> usernames = new ArrayList<>();

        while(!db.returnFollowerRequests(username,usernames)){}


        adapter = new FollowRequestAdapter(this,usernames);

        list.setAdapter(adapter);


    }

    public void addFollow(View v){
        String follower = (String)v.getTag();
        db.addFollowing(follower,username);
        deleteRequest(v);
        adapter.remove(follower);
    }

    public void deleteRequest(View v){
        String follower = (String)v.getTag();
        db.removeFollowerRequest(username,follower);
        adapter.remove(follower);
    }
}