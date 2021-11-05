package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

public class AddHabitActivity extends AppCompatActivity {

    DataBaseAccess db = new DataBaseAccess();

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
     * @param view
     */
    public void goToMyHabits(View view) {
        EditText title = (EditText) findViewById(R.id.editTextTitle);
        EditText reason = (EditText) findViewById(R.id.editTextReason);
        EditText date = (EditText) findViewById(R.id.editTextDate);
        Habit addedHabit = new Habit(title.getText().toString(), reason.getText().toString(),new Date(date.getText().toString()), true);

        /*
        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.USERNAME);
        db.dataInsert(username,title.getText().toString(),addedHabit);*/

        Intent intent = new Intent(this, MyHabitsActivity.class);
        startActivity(intent);
    }
}