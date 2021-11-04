package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Get the username from the previous one
        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.USERNAME); // This is the username that the user gave in the login activity
    }

    /*
     * When the user clicks View All they will be taken to the my habits page
     */
    public void goToMyHabits(View view) {
        Intent intent = new Intent(this, MyHabitsActivity.class);
        startActivity(intent);
    }
}