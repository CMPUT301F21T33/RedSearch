package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class MyHabitsActivity extends AppCompatActivity {

    ListView list;
    ArrayList<Habit> myHabits;
    MyHabitList adapter;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_habits);

        Toolbar toolbar = findViewById(R.id.toolbar_my_habits);
        setSupportActionBar(toolbar);
        setTitle("My Habits");

        //Get the username from the previous one
        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.USERNAME); // This is the username that the user gave in the login activity

        list = (ListView) findViewById(R.id.listView);
        myHabits = new ArrayList<Habit>();

        db = FirebaseFirestore.getInstance();
        final CollectionReference collectionReference = db.collection("Users");

        //pull data from db and put in myHabits

        adapter = new MyHabitList(this,myHabits);

        list.setAdapter(adapter);
    }

    public void goToAddHabit(View view) {
        Intent intent = new Intent(this, AddHabitActivity.class);
        startActivity(intent);
    }
}