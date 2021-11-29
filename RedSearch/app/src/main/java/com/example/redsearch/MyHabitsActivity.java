package com.example.redsearch;

import static java.util.Comparator.naturalOrder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class MyHabitsActivity extends AppCompatActivity {

    public static final String TITLE = "com.example.redsearch.TITLE";
    public static final String REASON = "com.example.redsearch.REASON";
    public static final String DATE = "com.example.redsearch.DATE";
    ArrayList<Habit> myHabits = new ArrayList<Habit>();
    MyHabitList adapter;
    String username;

    /**
     * On creation of the activity
     * @param savedInstanceState {@code Bundle}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_habits);

        Toolbar toolbar = findViewById(R.id.toolbar_my_habits);
        setSupportActionBar(toolbar);
        setTitle("My Habits");

        Intent intent = getIntent();
        username = intent.getStringExtra("USER");

        ListView list = (ListView) findViewById(R.id.listView);


        DataBaseAccess db = new DataBaseAccess();  // Get access to the database
        while(!db.returnHabits(username, myHabits));  // Get habits from db

        // Look at all of our habits
        adapter = new MyHabitList(this,myHabits);

        list.setAdapter(adapter);

        // If a habit is clicked, open more details about it
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Habit habit = myHabits.get(i);
                goToViewHabit(view, habit);
            }
        });
    }

    /**
     * Creates an array for the days of the week an activity is planned for
     * The array will display true if the habit is planned for that day of the week, or false
     * @param habit {@code Habit} The habit to create the array for
     * @return {@code boolean[]} An array that contains information of the days of the week
     *                             an activity is planned for
     */
    private boolean[] weekdaysPlanned(Habit habit) {
        boolean[] weekdays = new boolean[7];  // Create array
        for (int i = 0; i < 7; i++) {  // Populate array based on the weekdays planned
            weekdays[i] = habit.getWeekday(i);
        }
        return weekdays;  // return array
    }

    /**
     * Go to the View Habit Activity
     * @param view {@code View}
     * @param habit {@code Habit} The habit to be displayed
     */
    public void goToViewHabit(View view, Habit habit){
        boolean[] weekdays = weekdaysPlanned(habit);
        Intent intent = new Intent(this, ViewHabitActivity.class);
        intent.putExtra(TITLE, habit.getTitle());
        intent.putExtra(REASON, habit.getReason());
        intent.putExtra(DATE, habit.getStartDate());
        intent.putExtra("Weekdays", weekdays);
        intent.putExtra("USER", username);
        startActivity(intent);
    }

    /**
     * Go to add Habit Activity
     * @param view {@code View}
     */
    public void goToAddHabit(View view) {
        Intent intent = new Intent(this, AddHabitActivity.class);
        startActivity(intent);
    }

    public void sortByName (View view) {
        Collections.sort(myHabits, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
    }

}