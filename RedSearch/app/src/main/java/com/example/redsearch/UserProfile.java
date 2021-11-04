package com.example.redsearch;

public class UserProfile {
    private String username;
    private String password;
    private HabitList habitlist; // The list of habits that belong to this person
    //private FollowerList followerList; // This needs to be created so that the user can follow people commented out for now

    public UserProfile(String username, String password){
        this.username = username;
        this.password = password;
    }
}
