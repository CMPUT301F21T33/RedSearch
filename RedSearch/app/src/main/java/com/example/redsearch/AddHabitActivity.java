package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddHabitActivity extends AppCompatActivity {
    DataBaseAccess db = new DataBaseAccess();
    //EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);

        Toolbar toolbar = findViewById(R.id.toolbar_add_habit);
        setSupportActionBar(toolbar);
        setTitle("Add Habit");

        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.USERNAME);
    }

    public void goToMyHabits(View view) {

        Intent intent = new Intent(this, MyHabitsActivity.class);
        startActivity(intent);
    }
}