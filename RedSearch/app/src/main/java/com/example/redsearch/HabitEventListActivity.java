package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * This is the HabiteventListActivity that shows all of the habit events from a given habit
 */

public class HabitEventListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_event_list);
    }
}