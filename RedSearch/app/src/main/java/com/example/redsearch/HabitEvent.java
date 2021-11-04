package com.example.redsearch;

import androidx.annotation.NonNull;

import java.util.Date;

public class HabitEvent{
    private String comment;
    private Date date;
    public String image;

    /**
     * Habit Class constructor
     * @param comment {@code String} comment associated with HabitEvent
     * @param date {@code Date} date HabitEvent was created
     * @param image {@code boolean} True if habit is public, False if not
     */
    HabitEvent(String comment, Date date, String image){
        // a simple habit constructor
        setComment(comment);
        setDate(date);
        setImage(image);
    }

    /**
     * HabitEvent's comment setter
     * The comment must be 20 characters or less.
     * If there are more than 20 characters, only the first 20 will be stored
     * @param Comment {@code String} Comment associated with HabitEvent
     */
    public void setComment(@NonNull String Comment){
        if (Comment.length() <= 20) {
            this.comment = Comment;
        } else {
            this.comment = Comment.substring(0,20);
        }
    }

    /**
     * HabitEvent's date setter
     * @param Date {@code Date} Date HabitEvent was created
     */
    public void setDate(Date Date){this.date = Date;}

    /**
     * HabitEvent's image setter
     * @param Image {@code Bitmap} image associated with HabitEvent
     */
    private void setImage(String Image) {this.image = Image;}
}
