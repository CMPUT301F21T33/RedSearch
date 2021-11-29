package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class ViewHabitActivity extends AppCompatActivity {

    TextView titleText;
    TextView reasonText;
    TextView dateText;
    TextView weekdaysText;
    String username;
    String title;

    /**
     * On creation of activity
     * @param savedInstanceState {@code Bundle}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_habit);

        // Receive the intent from the previous activity and store it
        Intent intent = getIntent();
        username = intent.getStringExtra("USER");
        title = intent.getStringExtra(MyHabitsActivity.TITLE); // This is the username that the user g
        String reason = intent.getStringExtra(MyHabitsActivity.REASON);
        String date = intent.getStringExtra(MyHabitsActivity.DATE);
        boolean[] weekdays = intent.getBooleanArrayExtra("Weekdays");

        // Find the UI elements
        titleText = findViewById(R.id.titleText);
        reasonText = findViewById(R.id.reasonText);
        dateText = findViewById(R.id.dateText);
        weekdaysText = findViewById(R.id.textView6);

        // Get the string that will display the days planned
        String weekdaysplanned = getDaysString(weekdays);

        // Update the text on the UI to reflect the current habit
        titleText.setText(title);
        reasonText.setText(reason);
        dateText.setText(date);
        weekdaysText.setText(weekdaysplanned);
    }

    public void deleteHabit(View view){
        DataBaseAccess db = new DataBaseAccess();
        Intent intent = new Intent(this, MyHabitsActivity.class);
        intent.putExtra("USER", username);
        db.dataRemove(username, title);
        startActivity(intent);
    }

    public void editHabit(View view){
        DataBaseAccess db = new DataBaseAccess();
        Intent intent = new Intent(this, AddHabitActivity.class);
        intent.putExtra("USER", username);
        db.dataRemove(username, title);
        startActivity(intent);
    }
        /**
         * Create a string that displays the days of the week a habit is planned for
         * @param weekdays {@code boolean[]} Array that stores the days of the week a habit is
         *                                  planned for. True if planned for that day, False if not.
         * @return {@code String} The days of the week the habit is planned for
         */
    private String getDaysString(boolean[] weekdays) {
        String daysPlanned = "";  // Create empty string to append to
        if (weekdays[0]) {  // If habit is planned for Monday, add it to the string
            daysPlanned = daysPlanned + "Mon. ";
        }
        if (weekdays[1]) { // If habit is planned for Tuesday, add it to the string
            daysPlanned = daysPlanned + "Tue. ";
        }
        if (weekdays[2]) {  // If habit is planned for Wednesday, add it to the string
            daysPlanned = daysPlanned + "Wed. ";
        }
        if (weekdays[3]) {  // If habit is planned for Thursday, add it to the string
            daysPlanned = daysPlanned + "Thu. ";
        }
        if (weekdays[4]) {  // If habit is planned for Friday, add it to the string
            daysPlanned = daysPlanned + "Fri. ";
        }
        if (weekdays[5]) {  // If habit is planned for Saturday, add it to the string
            daysPlanned = daysPlanned + "Sat. ";
        }
        if (weekdays[6]) {  // If habit is planned for Sunday, add it to the string
            daysPlanned = daysPlanned + "Sun. ";
        }
        return daysPlanned;
    }
}