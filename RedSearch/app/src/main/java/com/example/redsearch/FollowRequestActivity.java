package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FollowRequestActivity extends AppCompatActivity {
    DataBaseAccess db = new DataBaseAccess();
    FollowRequestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_request);

        Toolbar toolbar = findViewById(R.id.toolbar_follow_requests);
        setSupportActionBar(toolbar);
        setTitle("Follow Requests");

        ListView list = (ListView) findViewById(R.id.listView);
        ArrayList<String> usernames = new ArrayList<>();

        while(!db.returnFollowerRequests("Sam",usernames)){}


        adapter = new FollowRequestAdapter(this,usernames);

        list.setAdapter(adapter);


    }

    public void addFollow(View v){
        String follower = (String)v.getTag();
        db.addFollower("Sam","Lauren");
        deleteRequest(v);
        adapter.remove("Lauren");
    }

    public void deleteRequest(View v){
        String follower = (String)v.getTag();
        db.removeFollowerRequest("Sam","Lauren");
        adapter.remove("Lauren");
    }
}