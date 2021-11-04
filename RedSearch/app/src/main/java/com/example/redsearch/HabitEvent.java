package com.example.redsearch;

import androidx.annotation.NonNull;

import java.util.Date;
import android.graphics.Bitmap;

public class HabitEvent{
    private String comment;
    private Date date;
    public Bitmap image;

    /**
     * Habit Event Class constructor
     * @param comment {@code String} comment associated with HabitEvent
     * @param date {@code Date} date HabitEvent was created
     */
    HabitEvent(String comment, Date date){
        // a simple habit event constructor
        setComment(comment);
        setDate(date);
    }

    /**
     * Habit Event Class constructor with image
     * @param comment {@code String} comment associated with HabitEvent
     * @param date {@code Date} date HabitEvent was created
     * @param image {@code Bitmap} image of HabitEvent
     */
    HabitEvent(String comment, Date date, Bitmap image) {
        // overloaded constructor
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
    private void setImage(Bitmap Image) {this.image = Image;}

    /**
     * HabitEvent date getter
     * @return {@code Date} Date the habitEvent was created
     */
    Date getDate(){return this.date;}

    /**
     * HabitEvent comment getter
     * @return {@code String} Comment associated with HabitEvent
     */
    String getComment(){return this.comment;}

    /**
     * HabitEvent image getter
     * @return {@code Bitmap} Image associated with HabitEvent
     */
    Bitmap getImage(){return this.image;}
}
