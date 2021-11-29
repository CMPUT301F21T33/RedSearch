package com.example.redsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FollowRequestAdapter extends ArrayAdapter<String> {
    private ArrayList<String> requests;
    private Context context;

    public FollowRequestAdapter(Context context, ArrayList<String> requests){
        super(context, 0, requests);
        this.requests = requests;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_follow_list, parent,false);
        }

        String request = requests.get(position);

        TextView list_txt = (TextView) convertView.findViewById(R.id.list_txt);
        //ImageView list_ind = (ImageView) convertView.findViewById(R.id.list_ind);

        //set text of TextView
        list_txt.setText(request);
        //change indicator color
        //list_ind.setColorFilter(Color.parseColor(habit.getColor()), PorterDuff.Mode.MULTIPLY);

        return convertView;

    }
}
