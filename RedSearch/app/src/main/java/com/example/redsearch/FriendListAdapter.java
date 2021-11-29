package com.example.redsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Adapter for FriendsList view
 */
public class FriendListAdapter extends ArrayAdapter<String> {
    private ArrayList<String> friends;
    private Context context;

    /**
     * Friend list adapter constructor
     * @param context {@code Context} Context given
     * @param friends {@code ArrayList<User>} Friends list to be displayed
     */
    public FriendListAdapter(Context context, ArrayList<String> friends) {
        super(context, 0, friends);
        this.friends = friends;
        this.context = context;
    }

    /**
     * View to display per friend in list
     * @param position friend position in the list
     * @param convertView view to be editied
     * @param parent parent
     * @return View {@code View} edited view
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_friend_list, parent, false);
        }

        TextView friendText = (TextView) convertView.findViewById(R.id.friend_list_text);

        String user = friends.get(position);

        friendText.setText(user);

        return convertView;
    }
}
