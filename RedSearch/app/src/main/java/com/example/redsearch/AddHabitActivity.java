package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * This is an activity that is where the user can add a habit
 */

public class AddHabitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);

        Toolbar toolbar = findViewById(R.id.toolbar_add_habit);
        setSupportActionBar(toolbar);
        setTitle("Add Habit");
    }

    /**
     * This moves to the next activity when the habit is added
     * @param view (@code view} This is the view variable it takes in
     */
    public void goToMyHabits(View view) {
        Intent intent = new Intent(this, MyHabitsActivity.class);
        startActivity(intent);
    }
}