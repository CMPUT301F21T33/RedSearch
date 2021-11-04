package com.example.redsearch;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class HabitList extends ArrayAdapter<Habit> {
    private ArrayList<Habit> habits;
    private Context context;

    public HabitList(MainActivity context, ArrayList<Habit> habits){
        // This is the general constructor
        super(context, 0, habits);
        this.habits = habits;
        this.context = context;
    }
}
