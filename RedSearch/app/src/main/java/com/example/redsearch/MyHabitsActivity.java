package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MyHabitsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_habits);

        Toolbar toolbar = findViewById(R.id.toolbar_my_habits);
        setSupportActionBar(toolbar);
        setTitle("My Habits");

        ListView list = (ListView) findViewById(R.id.listView);
        ArrayList<Habit> myHabits = new ArrayList<Habit>();

        /*
        db = FirebaseFirestore.getInstance();
        final CollectionReference collectionReference = db.collection("Users");*/

        //pull data from db and put in myHabits

        //Habit testHab = new Habit("TestHabit","Reason", new Date(), true);
        myHabits.add(new Habit("Drink water","Reason", new Date(), true));
        myHabits.add(new Habit("Do laundry","Reason", new Date(), true));

        MyHabitList adapter = new MyHabitList(this,myHabits);

        list.setAdapter(adapter);
    }

    public void goToAddHabit(View view) {
        Intent intent = new Intent(this, AddHabitActivity.class);
        startActivity(intent);
    }
}