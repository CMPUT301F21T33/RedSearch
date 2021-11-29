package com.example.redsearch;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

/**
 * This is the Activity where the current user can see who has requested to follow them
 * @author: Matt
 * @see DataBaseAccess
 */
public class FollowRequestActivity extends AppCompatActivity {
    DataBaseAccess db = new DataBaseAccess();
    FollowRequestAdapter adapter;

    /**
     * This is the onCreate method that happens when the class is created
     * @param savedInstanceState the bundle that is passed into the class
     */
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

    /**
     * This is method that adds a follower to the user
     * @param v the view method required for onClick functions
     */
    public void addFollow(View v){
        String follower = (String)v.getTag();
        db.addFollower("Sam","Lauren");
        deleteRequest(v);
        adapter.remove("Lauren");
    }

    /**
     * This is the delete request, where a user denies that they want this user to follow them
     * @param v
     */
    public void deleteRequest(View v){
        String follower = (String)v.getTag();
        db.removeFollowerRequest("Sam","Lauren");
        adapter.remove("Lauren");
    }
}