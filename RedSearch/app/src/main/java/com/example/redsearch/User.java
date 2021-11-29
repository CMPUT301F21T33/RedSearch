package com.example.redsearch;

import android.content.Context;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private HabitList habitlist;
    private ArrayList<Habit> habits;// The list of habits that belong to this person
    //private FollowerList followerList; // This needs to be created so that the user can follow people commented out for now

    /**
     * This is the User constructor
     * @param username
     * @param password
     */
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * getter for username
     * @return username {@code String} user's username
     */
    public String getUsername() {
        return username;
    }

}
