package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyHabitsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_habits);

        Toolbar toolbar = findViewById(R.id.toolbar_my_habits);
        setSupportActionBar(toolbar);
        setTitle("My Habits");
    }

    public void goToAddHabit(View view) {
        Intent intent = new Intent(this, AddHabitActivity.class);
        startActivity(intent);
    }
}