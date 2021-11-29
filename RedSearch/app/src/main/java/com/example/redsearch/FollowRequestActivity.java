package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FollowRequestActivity extends AppCompatActivity {
    DataBaseAccess db = new DataBaseAccess();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_request);

        Toolbar toolbar = findViewById(R.id.toolbar_follow_requests);
        setSupportActionBar(toolbar);
        setTitle("Follow Requests");

        ListView list = (ListView) findViewById(R.id.listView);
        ArrayList<String> usernames = new ArrayList<>();

        //while(!db.returnFollowerRequests("Sam",usernames)){}

        if(!db.returnFollowerRequests("Sam",usernames)){
            usernames.add("Max");
            usernames.add("Dave");
        }

        FollowRequestAdapter adapter = new FollowRequestAdapter(this,usernames);

        list.setAdapter(adapter);
    }
}