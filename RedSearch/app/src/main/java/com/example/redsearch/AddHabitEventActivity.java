package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

/**
 * This is the AddHabitEventActivity that is used to add a habit event
 */

public class AddHabitEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit_event);

        Toolbar toolbar = findViewById(R.id.toolbar_add_habit_event);
        setSupportActionBar(toolbar);
        setTitle("Log Habit");
    }
}