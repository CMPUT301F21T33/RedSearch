package com.example.redsearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

/**
 * @author: Matt
 * @see FriendListAdapter
 */
public class FriendsActivity extends AppCompatActivity {

    private String username;
    public static final String FRIENDNAME = "com.example.redsearch.FRIENDNAME";

    /**
     * This the method that is called upon starting the activity
     * @param savedInstanceState - the bundle must contain the previous user
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        // Get the previous intent for the current user who is using it
        Intent intent = getIntent();
        username = intent.getStringExtra("USER");

        //Set the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_friends);
        setSupportActionBar(toolbar);
        setTitle("Friends");

        //Setting the Listview
        ListView friendList = (ListView) findViewById(R.id.friendView);
        ArrayList<User> friends = new ArrayList<>();
        friends.add(new User("foo1", "bar1"));

        // Set the adapter
        FriendListAdapter adapter = new FriendListAdapter(this, friends);
        friendList.setAdapter(adapter);

        friendList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), ViewFriendActivity.class);
                User user = adapter.getItem(i);
                intent.putExtra(FRIENDNAME, user.getUsername());
                intent.putExtra("USER", username);
                startActivity(intent);
            }
        });
    }

    /**
     * The onclick method that moves to SearchUsersActivity
     * @param view
     */
    public void goToSearchUsers(View view) {
        Intent intent = new Intent(this, SearchUsersActivity.class);
        startActivity(intent);
    }

    /**
     * This moves to the FollowRequestActivity
     * @param view this is required for the onClick methods
     */
    public void goToFollowRequest(View view) {
        Intent intent = new Intent(this, FollowRequestActivity.class);
        startActivity(intent);
    }
}