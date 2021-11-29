package com.example.redsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 * This is the adapter for the FollowRequest List
 * @author: Matt
 * @see DataBaseAccess
 */
public class FollowRequestAdapter extends ArrayAdapter<String> {
    DataBaseAccess db = new DataBaseAccess();
    private ArrayList<String> requests;
    private Context context;

    /**
     * This is the creation function for the adapter
     * @param context the current context
     * @param requests is an arraylist of strings filled with the people requesting
     */
    public FollowRequestAdapter(Context context, ArrayList<String> requests){
        super(context, 0, requests);
        this.requests = requests;
        this.context = context;
    }

    /**
     * Get the view of the adapter
     * @param position
     * @param convertView
     * @param parent
     * @return View - the view of the adapter
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_follow_list_test, parent,false);
        }
        //Get the position of the string request
        String request = requests.get(position);

        TextView list_txt = (TextView) convertView.findViewById(R.id.list_txt);
        ImageButton list_check = (ImageButton) convertView.findViewById(R.id.list_check);
        ImageButton list_close = (ImageButton) convertView.findViewById(R.id.list_close);

        //set text of TextView
        list_txt.setText(request);



        return convertView;

    }
}
