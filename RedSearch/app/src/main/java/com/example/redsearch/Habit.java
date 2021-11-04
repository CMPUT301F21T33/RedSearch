package com.example.redsearch;

import android.graphics.Color;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.util.Date;

public class Habit {
    private String title;
    private String reason;
    private Date startDate;
    private int Daysplanned;
    private int Dayshappened;
    private Color color;
    private boolean visible;

    /**
     * Habit Class constructor
     * @param title {@code String} Title of Habit
     * @param reason {@code String} Reason of Habit
     * @param date {@code Date} Date the habit began
     * @param visible {@code boolean} True if habit is public, False if not
     */
    Habit(String title, String reason, Date date, boolean visible){
        // a simple habit constructor
        setTitle(title);
        setReason(reason);
        setStartDate(date);
        setvisible(visible);
    }

    /**
     * Habit title getter
     * @return {@code String} Title of Habit
     */
    String getTitle(){return this.title;}

    /**
     * Habit reason getter
     * @return {@code String} Reason of Habit
     */
    String getReason(){return this.reason;}

    /**
     * Habit start date getter
     * @return {@code Date} Date the habit began
     */
    Date getStartDate(){return this.startDate;}

    /**
     * Habit's number of days planned getter
     * @return {@code int} Number of days the habit is planned for
     */
    int getDaysplanned(){return this.Daysplanned;}

    /**
     * Habit's number of days habit occurred getter
     * @return {@code int} Number of days the habit happened
     */
    int getDayshappened(){return this.Dayshappened;}

    /**
     * Habit's colour getter
     * @return {@code Color} Color of habit
     */
    Color getColor(){return this.color;}

    /**
     * Habit's visibility getter
     * @return {@code Boolean} True if habit is public, False if not
     */
    boolean getVisible(){return this.visible;}

    /**
     * Habit's title setter
     * The title must be 20 characters or less.
     * If there are more than 20 characters, only the first 20 will be stored
     * @param Title {@code String} Title of habit
     */
    public void setTitle(@NonNull String Title){
        if (Title.length() <= 20) {
            this.title = Title;
        } else {
            this.title = Title.substring(0,20);
        }
    }

    /**
     * Habit's reason setter
     * The reason must be 30 characters or less.
     * If there are more than 30 characters, only the first 30 will be stored
     * @param reason {@code String} Reason of habit
     */
    public void setReason(@NonNull String reason){
        if (reason.length() <= 30) {
            this.reason = reason;
        } else {
            this.reason = reason.substring(0,30);
        }
    }

    /**
     * Habit's start date setter
     * @param date {@code Date} Date habit began
     */
    public void setStartDate(Date date){this.startDate = date;}

    /**
     * Habit's number of days planned setter
     * @param daysplanned {@code int} Number of days the habit is planned for
     */
    public void setDaysplanned(int daysplanned){this.Daysplanned = daysplanned;}

    /**
     * Habit's number of days happened setter
     * @param dayshappened {@code int} Number of days the habit happened
     */
    public void setDayshappened(int dayshappened){this.Dayshappened = dayshappened;}

    /**
     * Habit's visibility setter
     * @param visible {@code Boolean} True if habit is public, Flase is not
     */
    public void setvisible(boolean visible){this.visible = visible;}

    @RequiresApi(api = Build.VERSION_CODES.O) // Made me put this in to do the colour part
    /**
     * Habit's colour setter
     */
    public void setColor(){
        float percent = (float)this.Dayshappened/(float) this.Daysplanned;
        float green = percent * 255; // This finds the value of the green part of the colour
        float red = 255 - green; // This finds the value of the blue part of the colour
        float blue = 0;  // I think we can just set this to 0, don't need "value of"
        this.color = Color.valueOf(red,green,blue);
    }

    /**
     * Overridden equals method to compare habits.
     * A habit is the same if the habit and reason are the exact same
     * @param obj {@code Object} The object class used for comparison
     * @return {@code boolean} True if objects are equal, False otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Habit)) {
            return false;
        }
        Habit habit = (Habit) obj;
        return this.title.equals(habit.title) && this.reason.equals(habit.reason);
    }
}
