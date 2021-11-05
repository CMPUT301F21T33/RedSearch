package com.example.redsearch;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * This is the HabitEventListAdapter Class
 * This class exists to create an Adapter for the HabitEventList class
 */

public class HabitEventListAdapter extends ArrayAdapter<HabitEvent> {
    private ArrayList<HabitEvent> habitEvents;
    private Context context;

    /**
     * Habit list adapter constructor
     */
    public HabitEventListAdapter(Context context, ArrayList<HabitEvent> habitEvents){
        super(context, 0, habitEvents);
        this.habitEvents = habitEvents;
        this.context = context;
    }
}
