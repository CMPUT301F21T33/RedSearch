package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Toolbar toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);
        setTitle("Today's Habits");
        //Get the username from the previous one

        //Intent intent = getIntent();
        //String username = intent.getStringExtra(MainActivity.USERNAME); // This is the username that the user gave in the login activity

        ListView list = (ListView) findViewById(R.id.listView);
        ArrayList<Habit> todayHabits = new ArrayList<Habit>();
        todayHabits.add(new Habit("Drink water","I am thirsty",new Date(),true));

        HabitListAdapter adapter = new HabitListAdapter(this,todayHabits);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), AddHabitEventActivity.class);
                startActivity(intent);
            }
        });


    }

    /**
     * This moves to the MyHabitsActivity when the ViewAll button is pressed
     * @param view {@code View} takes in the view
     */
    public void goToMyHabits(View view) {
        Intent intent = new Intent(this, MyHabitsActivity.class);
        startActivity(intent);
    }

    public void goToFriends(View view) {
        Intent intent = new Intent(this, FriendsActivity.class);
        startActivity(intent);
    }

    public void goToHabitEventList(View view) {
        Intent intent = new Intent(this, HabitEventListActivity.class);
        startActivity(intent);
    }

    /**
     * This moves to the FriendsActivity when the friendsButton is pressed
     * @param view {@code View} takes in the view
     */
    public void goToMyFriends(View view) {
        Intent intent = new Intent(this, FriendsActivity.class);
        startActivity(intent);
    }
}
