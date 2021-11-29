package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Activity for view friends followed
 */
public class FriendsActivity extends AppCompatActivity {

    private String username;
    public static final String FRIENDNAME = "com.example.redsearch.FRIENDNAME";
    public static final String USERNAME = "com.example.redsearch.USERNAME";
    private DataBaseAccess db = new DataBaseAccess();

    /**
     * Function called on activity creation
     * @param savedInstanceState {@code Bundle} Saved Data
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        Intent intent = getIntent();
        username = intent.getStringExtra(USERNAME);

        Toolbar toolbar = findViewById(R.id.toolbar_friends);
        setSupportActionBar(toolbar);
        setTitle("Friends");

        ListView friendList = (ListView) findViewById(R.id.friendView);
        ArrayList<String> friends = new ArrayList<>();

        while(!db.returnFollowers(username, friends));

        FriendListAdapter adapter = new FriendListAdapter(this, friends);
        friendList.setAdapter(adapter);

        friendList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), ViewFriendActivity.class);
                String user = adapter.getItem(i);
                intent.putExtra(FRIENDNAME, user);
                intent.putExtra("USER", username);
                startActivity(intent);
            }
        });
    }

    /**
     * This moves to the SearchUsersActivity
     * @param view {@code View} takes in the view
     */
    public void goToSearchUsers(View view) {
        Intent intent = new Intent(this, SearchUsersActivity.class);
        intent.putExtra(USERNAME, username);
        startActivity(intent);
    }

    /**
     * This moves to the FollowRequestActivity
     * @param view {@code View} takes in the view
     */
    public void goToFollowRequest(View view) {
        Intent intent = new Intent(this, FollowRequestActivity.class);
        intent.putExtra(USERNAME, username);
        startActivity(intent);
    }
}