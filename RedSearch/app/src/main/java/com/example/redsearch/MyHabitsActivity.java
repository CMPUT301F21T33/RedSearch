package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MyHabitsActivity extends AppCompatActivity {

    public static final String TITLE = "com.example.redsearch.TITLE";
    public static final String REASON = "com.example.redsearch.REASON";
    public static final String DATE = "com.example.redsearch.DATE";
    public static final String WEEKDAYS = "com.example.redsearch.WEEKDAYS";

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
        myHabits.add(new Habit("Drink water","thirsty", new Date(), true));
        myHabits.add(new Habit("Do laundry","dirty", new Date(), true));

        MyHabitList adapter = new MyHabitList(this,myHabits);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String title = myHabits.get(i).getTitle();
                String reason = myHabits.get(i).getReason();
                String date = myHabits.get(i).getStartDate().toString();
                //String weekdays = myHabits.get(i).get

                goToViewHabit(view, title, reason, date);
            }
        });
    }

    public void goToViewHabit(View view, String title, String reason, String date){
        Intent intent = new Intent(this, ViewHabitActivity.class);
        intent.putExtra(TITLE, title);
        intent.putExtra(REASON, reason);
        intent.putExtra(DATE, date);
        startActivity(intent);
    }

    public void goToAddHabit(View view) {
        Intent intent = new Intent(this, AddHabitActivity.class);
        startActivity(intent);
    }
}