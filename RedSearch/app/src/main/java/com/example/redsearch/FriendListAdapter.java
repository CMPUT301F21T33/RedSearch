package com.example.redsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FriendListAdapter extends ArrayAdapter<User> {
    private ArrayList<User> friends;
    private Context context;

    /**
     * Friend list adapter constructor
     * @param context {@code Context} Context given
     * @param friends {@code ArrayList<User>} Friends list to be displayed
     */
    public FriendListAdapter(Context context, ArrayList<User> friends) {
        super(context, 0, friends);
        this.friends = friends;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_friend_list, parent, false);
        }

        User user = friends.get(position);

        return convertView;
    }
}
