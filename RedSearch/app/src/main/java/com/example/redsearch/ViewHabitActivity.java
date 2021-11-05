package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewHabitActivity extends AppCompatActivity {

    TextView titleText;
    TextView reasonText;
    TextView dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_habit);


        Intent intent = getIntent();
        String title = intent.getStringExtra(MyHabitsActivity.TITLE); // This is the username that the user g
        String reason = intent.getStringExtra(MyHabitsActivity.REASON);
        String date = intent.getStringExtra(MyHabitsActivity.DATE);

        titleText = findViewById(R.id.titleText);
        reasonText = findViewById(R.id.reasonText);
        dateText = findViewById(R.id.dateText);

        titleText.setText(title);
        reasonText.setText(reason);
        dateText.setText(date);
    }
}