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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyHabitList extends ArrayAdapter<Habit> {
    private ArrayList<Habit> habits;
    private Context context;

    public MyHabitList(Context context, ArrayList<Habit> habits){
        super(context, 0, habits);
        this.habits = habits;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_listview, parent,false);
        }

        Habit habit = habits.get(position);

        TextView list_txt = (TextView) convertView.findViewById(R.id.list_txt);
        ImageView list_ind = (ImageView) convertView.findViewById(R.id.list_ind);

        list_txt.setText(habit.getTitle());
        list_ind.setColorFilter(Color.parseColor(habit.getColor()), PorterDuff.Mode.MULTIPLY);

        return convertView;

    }
}
