package com.example.redsearch;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class HabitListAdapter extends ArrayAdapter<Habit> {
    private ArrayList<Habit> habits;
    private Context context;

    /**
     * Habit list adapter constructor
     */
    public HabitListAdapter(Context context, ArrayList<Habit> habits){
        super(context, 0, habits);
        this.habits = habits;
        this.context = context;
    }
}
