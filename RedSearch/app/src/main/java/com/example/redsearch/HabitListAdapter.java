package com.example.redsearch;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;

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

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_homelist, parent,false);
        }

        Habit habit = habits.get(position);

        TextView list_txt = (TextView) convertView.findViewById(R.id.list_txt);
        ImageView list_ind = (ImageView) convertView.findViewById(R.id.list_ind);

        //set text of TextView
        list_txt.setText(habit.getTitle());

        Date date = new Date();

        //change indicator color by ensuring that the habit event was completed today
        for (int i = 0; i < habits.size(); i++) {
            Habit habit1 = habits.get(i);
            for (int j = 0; j < habit1.getHabitEventList().size(); j++) {
                Date habitDate = habit1.getHabitEventList().getHabitEvent(j).getDate();
                if (date.compareTo(habitDate) == 0) {
                    list_ind.setColorFilter(Color.parseColor("#FF0000"), PorterDuff.Mode.MULTIPLY);
                }
            }
        }

        return convertView;

    }
}
