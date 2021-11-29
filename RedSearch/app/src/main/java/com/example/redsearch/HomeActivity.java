package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);
        setTitle("Today's Habits");

        Intent intent = getIntent();

        // This is the username that the user gave in the login activity
        username = intent.getStringExtra(MainActivity.USERNAME);

        ListView list = (ListView) findViewById(R.id.listView);

        DataBaseAccess db = new DataBaseAccess();  // Get access to the database
        ArrayList<Habit> allHabits = new ArrayList<Habit>(); // List to store habits from db
        while(!db.returnHabits(username, allHabits));  // Get habits from db
        ArrayList<Habit> todayHabits = getTodayHabits(allHabits);  // Get today's habits

        // Display today's habits
        HabitListAdapter adapter = new HabitListAdapter(this,todayHabits);
        list.setAdapter(adapter);

        String finalUsername = username;
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), AddHabitEventActivity.class);
                intent.putExtra("USER", finalUsername);
                intent.putExtra("HABIT", todayHabits.get(i).getTitle());
                startActivity(intent);
            }
        });


    }

    /**
     * Create an array list that consists of today's habits
     * @param allHabits {@code ArrayList<Habit>} All habits retrieved from the database
     * @return {@code ArrayList<Habit>} Array list of today's habits only
     */
    private ArrayList<Habit> getTodayHabits(ArrayList<Habit> allHabits) {

        // Get today's weekday
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        int today = Calendar.DAY_OF_WEEK - 1;

        // A new array list for today's habits
        ArrayList<Habit> todayHabits = new ArrayList<Habit>();

        // Add the habit to today's habit list if the habit was planned for the current weekday
        for (int i = 0; i < allHabits.size(); i++) {
            if (allHabits.get(i).getWeekday(today)) {
                todayHabits.add(allHabits.get(i));
            }
        }
        return todayHabits;  // return today's habits
    }

    /**
     * This moves to the MyHabitsActivity when the ViewAll button is pressed
     * @param view {@code View} takes in the view
     */
    public void goToMyHabits(View view) {
        Intent intent = new Intent(this, MyHabitsActivity.class);
        intent.putExtra("USER", username);
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
