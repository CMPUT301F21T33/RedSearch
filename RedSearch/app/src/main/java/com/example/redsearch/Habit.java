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
    private int Daysplanned = 0;
    private int Dayshappened = 0;
    private String color;
    private boolean visible;
    private HabitEventList habitEventList = new HabitEventList();
    private boolean[] weekday = new boolean[7];

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
        setVisible(visible);
        setColor();
    }

    /**
     * Habit Class constructor
     * @param title {@code String} Title of Habit
     * @param reason {@code String} Reason of Habit
     * @param date {@code Date} Date the habit began
     * @param daysplanned {@code int} Number of days the habit is planned for
     * @param visible {@code boolean} True if habit is public, False if not
     */
    Habit(String title, String reason, Date date, int daysplanned, boolean visible){
        // a simple habit constructor overridden for days planned
        setTitle(title);
        setReason(reason);
        setStartDate(date);
        setDaysplanned(daysplanned);
        setVisible(visible);
        setColor();
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
     * @return {@code String} Hex code of color of habit
     */
    String getColor(){return this.color;}

    /**
     * Habit's visibility getter
     * @return {@code Boolean} True if habit is public, False if not
     */
    boolean getVisible(){return this.visible;}

    /**
     * Habit event list getter
     * @return {@code HabitEventList} Habit event list for particular habit
     */
    public HabitEventList getHabitEventList() {
        return habitEventList;
    }

    public boolean getWeekday(int dayNum) {
        if (dayNum < 0) {
            return false;
        } else if (dayNum > 6) {
            return false;
        } else {
            return weekday[dayNum];
        }
    }

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
    public void setDaysplanned(int daysplanned){
        this.Daysplanned = daysplanned;
        setColor();
    }

    /**
     * Habit's number of days happened setter
     * @param dayshappened {@code int} Number of days the habit happened
     */
    public void setDayshappened(int dayshappened){
        this.Dayshappened = dayshappened;
        setColor();
    }

    /**
     * Habit's visibility setter
     * @param visible {@code Boolean} True if habit is public, Flase is not
     */
    public void setVisible(boolean visible){this.visible = visible;}

    /**
     * Set color of habit
     * Grey if no days for the habit are planned.
     * Green if habit happens at least 75% of the days planned.
     * Yellow if habit happens at least 50% of the days planned
     * Red if habit happens less that 50% of the days planned
     */
    private void setColor(){
        if (this.Daysplanned == 0) {
            color = "#808080";  // grey, no days were planned
            return;
        }
        double percent = (double)this.Dayshappened/(double) this.Daysplanned * 100;
        if (percent >= 75.0) {
            color = "#00A36C";  // green, 75% of days planned happened
        } else if (percent >= 50.0) {
            color = "#FDDA0D";  // yellow, 50% of days planned happened
        } else {
            color = "#C41E3A"; // red, less than 50% of days planned happened
        }
    }

    /**
     * If weekday is set, then we plan the habit for that weekday
     * @param dayNum {@code int} Day of the week represented as an int
     *                          0 = Monday
     *                          1 = Tuesday
     *                          2 = Wednesday
     *                          3 = Thursday
     *                          4 = Friday
     *                          5 = Saturday
     *                          6 = Sunday
     */
    public void setWeekday(int dayNum) {
        if (dayNum < 0) {
            return;
        } else if (dayNum > 6) {
            return;
        } else {
            weekday[dayNum] = true;
        }
    }

    /**
     * Get the number of habit events for a particular habit
     * @return {@code int} Number of habit events
     */
    public int countHabitEvents() {
        return habitEventList.size();
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
