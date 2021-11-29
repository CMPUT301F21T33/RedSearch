package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;


/**
 * This is an activity that is where the user can add a habit
 */

public class AddHabitActivity extends AppCompatActivity {

    DataBaseAccess db = new DataBaseAccess();
    private String username;

    /**
     * On creation of the activity
     * @param savedInstanceState {@code Bundle}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);

        Toolbar toolbar = findViewById(R.id.toolbar_add_habit);
        setSupportActionBar(toolbar);
        setTitle("Add Habit");

        Intent intent = getIntent();
        // Get username
        username = intent.getStringExtra("USER");

        // Get date instance to set the minimum start date of a habit as today
        Date date = new Date();
        DatePicker datePicker = findViewById(R.id.datePicker);
        datePicker.setMinDate(date.getDate());
    }

    /**
     * Read date from DatePicker in fragment
     * @return {@code date} The date extracted from DatePicker
     * */
    private Date readDatePicker(DatePicker datePicker){

        // Get day, month and year from DatePicker
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        // Create date instance
        Date date = new Date(year-1900,month,day);
        return date;
    }

    /**
     * Check for what days the habit is planned for
     * @param habit {@code Habit} The habit to be updated for days planned
     */
    private void checkDaysPlanned(Habit habit) {
        int daysPlanned = 0;  // Keep track of number of days planned

        // Find the checkboxes for all possible days
        CheckBox monday = findViewById(R.id.monday);
        CheckBox tuesday = findViewById(R.id.tuesday);
        CheckBox wednesday = findViewById(R.id.wednesday);
        CheckBox thursday = findViewById(R.id.thursday);
        CheckBox friday = findViewById(R.id.friday);
        CheckBox saturday = findViewById(R.id.saturday);
        CheckBox sunday = findViewById(R.id.sunday);

        if (monday.isChecked()) {  // If day is selected
            daysPlanned++;  // Update counter
            habit.setWeekday(0);  // Set day as planned in habit class
        }

        // Repeat for all weekdays
        if (tuesday.isChecked()) {
            daysPlanned++;
            habit.setWeekday(1);
        }
        if (wednesday.isChecked()) {
            daysPlanned++;
            habit.setWeekday(2);
        }
        if (thursday.isChecked()) {
            daysPlanned++;
            habit.setWeekday(3);
        }
        if (friday.isChecked()) {
            daysPlanned++;
            habit.setWeekday(4);
        }
        if (saturday.isChecked()) {
            daysPlanned++;
            habit.setWeekday(5);
        }
        if (sunday.isChecked()) {
            daysPlanned++;
            habit.setWeekday(6);
        }
        habit.setDaysplanned(daysPlanned);  // Update days planned in habit class
    }

    /**
     * This moves to the next activity when the habit is added
     * @param view (@code view} This is the view variable it takes in
     */
    public void goToMyHabits(View view) {

        // Find the UI elements
        EditText title = findViewById(R.id.editTextTitle);
        EditText reason = findViewById(R.id.editTextReason);
        DatePicker date = findViewById(R.id.datePicker);
        CheckBox visPublic = findViewById(R.id.checkBox);

        // Create new habit with inputted information
        Habit addedHabit = new Habit(title.getText().toString(), reason.getText().toString(),
                readDatePicker(date), visPublic.isChecked());
        checkDaysPlanned(addedHabit);  // Select the weekdays planned

        // Update the database
        db.dataInsert(username,addedHabit.getTitle(),addedHabit);

        // Change the activity
        Intent intent = new Intent(this, MyHabitsActivity.class);
        startActivity(intent);
    }
}