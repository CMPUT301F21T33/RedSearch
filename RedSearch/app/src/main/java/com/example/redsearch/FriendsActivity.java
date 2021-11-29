package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FriendsActivity extends AppCompatActivity {

    private String username;
    public static final String FRIENDNAME = "com.example.redsearch.FRIENDNAME";
    public static final String USERNAME = "com.example.redsearch.USERNAME";

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
        ArrayList<User> friends = new ArrayList<>();
        friends.add(new User("foo1", "bar1"));

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

    public void goToSearchUsers(View view) {
        Intent intent = new Intent(this, SearchUsersActivity.class);
        intent.putExtra(USERNAME, username);
        startActivity(intent);
    }

    public void goToFollowRequest(View view) {
        Intent intent = new Intent(this, FollowRequestActivity.class);
        intent.putExtra(USERNAME, username);
        startActivity(intent);
    }
}