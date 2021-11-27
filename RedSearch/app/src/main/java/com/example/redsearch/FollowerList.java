package com.example.redsearch;

import java.util.ArrayList;

public class FollowerList {
    private ArrayList<User> followerList = new ArrayList<>();

    /**
     * Follower List Constructor
     */
    public FollowerList() {}

    /**
     * Get ArrayList of followers
     * @return {@code ArrayList<User>} List of User's following
     */
    public ArrayList<User> getFollowerList() {
        return followerList;
    }

    /**
     * Add user to follower list
     * @param user {@code User} User to be added
     */
    public void addFollower(User user) {
        if (followerList.contains(user)) {
            return;
        }
        followerList.add(user);
    }

    /**
     * Remove user from follower list
     * @param user {@code User} User to be removed
     */
    public void removeFollower(User user) {
        if (!followerList.contains(user)) {
            return;
        }
        followerList.remove(user);
    }


}
