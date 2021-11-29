/**
 * CMPUT 301 FALL 2021
 * Project part 3
 * @author
 *
 * The {@code Habit} Class
 *
 * Copyright 2021
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Acknowledgements:
 * */

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
    private boolean Monday = false;
    private boolean Tuesday = false;
    private boolean Wednesday = false;
    private boolean Thursday = false;
    private boolean Friday = false;
    private boolean Saturday = false;
    private boolean Sunday = false;

    Habit(String title, String reason, Date startDate, int Daysplanned, int Dayshappened,
          Boolean visible, HabitEventList habitEventList, boolean Monday, boolean Tuesday,
          boolean Wednesday, boolean Thursday, boolean Friday, boolean Saturday, boolean Sunday){
        this.title = title;
        this.reason = reason;
        this.startDate = startDate;
        this.Daysplanned = Daysplanned;
        this.Dayshappened = Dayshappened;
        this.visible = visible;
        this.habitEventList = habitEventList;
        this.Monday = Monday;
        this.Tuesday = Tuesday;
        this.Wednesday = Wednesday;
        this.Thursday = Thursday;
        this.Friday = Friday;
        this.Saturday = Saturday;
        this.Sunday = Sunday;
    }

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
    public String getTitle(){return this.title;}

    /**
     * Habit reason getter
     * @return {@code String} Reason of Habit
     */
    public String getReason(){return this.reason;}

    /**
     * Habit start date getter
     * @return {@code Date} Date the habit began
     */
    public Date getStartDate(){return this.startDate;}

    /**
     * Habit's number of days planned getter
     * @return {@code int} Number of days the habit is planned for
     */
    public int getDaysplanned(){return this.Daysplanned;}

    /**
     * Habit's number of days habit occurred getter
     * @return {@code int} Number of days the habit happened
     */
    public int getDayshappened(){return this.Dayshappened;}

    /**
     * Habit's colour getter
     * @return {@code String} Hex code of color of habit
     */
    public String getColor(){return this.color;}

    /**
     * Habit's visibility getter
     * @return {@code Boolean} True if habit is public, False if not
     */
    public boolean getVisible(){return this.visible;}

    /**
     * Habit event list getter
     * @return {@code HabitEventList} Habit event list for particular habit
     */
    public HabitEventList getHabitEventList() {
        return habitEventList;
    }

    public boolean getMonday() {
        return Monday;
    }

    public boolean getTuesday() {
        return Tuesday;
    }

    public boolean getWednesday() {
        return Wednesday;
    }

    public boolean getThursday() {
        return Thursday;
    }

    public boolean getFriday() {
        return Friday;
    }

    public boolean getSaturday() {
        return Saturday;
    }

    public boolean getSunday() {
        return Sunday;
    }


    /**
     * Get if day of week is planned or not
     * @param dayNum {@code int} Day of the week represented as an int
     *                          0 = Monday
     *                          1 = Tuesday
     *                          2 = Wednesday
     *                          3 = Thursday
     *                          4 = Friday
     *                          5 = Saturday
     *                          6 = Sunday
     * @return {@code boolean} True if habit is planned for that day
     */
    public boolean getWeekday(int dayNum) {
        if (dayNum < 0) {
            return false;
        } else if (dayNum > 6) {
            return false;
        } else {
            if (dayNum == 0) {
                return getMonday();
            } else if (dayNum == 1) {
                return getTuesday();
            } else if (dayNum == 2) {
                return getWednesday();
            } else if (dayNum == 3) {
                return getThursday();
            } else if (dayNum == 4) {
                return  getFriday();
            } else if (dayNum == 5) {
                return getSaturday();
            } else {
                return getSunday();
            }
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
     * @param visible {@code boolean} True if habit is public, False if not
     */
    public void setVisible(boolean visible){this.visible = visible;}

    /**
     * Set color of habit
     * Grey if no days for the habit are planned.
     * Green if habit happens at least 75% of the days planned.
     * Yellow if habit happens at least 50% of the days planned
     * Red if habit happens less that 50% of the days planned
     */
    public void setColor(){
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
            if (dayNum == 0) {
                Monday = true;
            } else if (dayNum == 1) {
                Tuesday = true;
            } else if (dayNum == 2) {
                Wednesday = true;
            } else if (dayNum == 3) {
                Thursday = true;
            } else if (dayNum == 4) {
                Friday = true;
            } else if (dayNum == 5) {
                Saturday = true;
            } else {
                Sunday = true;
            }
        }
    }

    /**
     * If weekday is set, then we un-plan the habit for that weekday
     * @param dayNum {@code int} Day of the week represented as an int
     *                          0 = Monday
     *                          1 = Tuesday
     *                          2 = Wednesday
     *                          3 = Thursday
     *                          4 = Friday
     *                          5 = Saturday
     *                          6 = Sunday
     */
    public void delWeekdayPlan(int dayNum) {
        if (dayNum < 0) {
            return;
        } else if (dayNum > 6) {
            return;
        } else {
            if (dayNum == 0) {
                Monday = false;
            } else if (dayNum == 1) {
                Tuesday = false;
            } else if (dayNum == 2) {
                Wednesday = false;
            } else if (dayNum == 3) {
                Thursday = false;
            } else if (dayNum == 4) {
                Friday = false;
            } else if (dayNum == 5) {
                Saturday = false;
            } else {
                Sunday = false;
            }
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
