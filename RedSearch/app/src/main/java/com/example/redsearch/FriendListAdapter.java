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

/**
 * @author Justin, Matt, Balreet
 */
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

    /**
     * Get the View of the adapter
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_friend_list, parent, false);
        }

        TextView friendText = (TextView) convertView.findViewById(R.id.friend_list_text);

        User user = friends.get(position);

        friendText.setText(user.getUsername());

        return convertView;
    }
}
