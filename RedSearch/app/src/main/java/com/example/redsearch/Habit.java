package com.example.redsearch;

import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Date;

public class Habit {
    private String title;
    private String reason;
    private Date startDate;
    private Float Daysplanned;
    private Float Dayshappened;
    private Color color;

    public Habit(){ }

    Habit(String title, String reason, Date date,Float Daysplanned, Float Dayshappened, Color color){
        // a simple habit constructor
        this.title = title;
        this.reason = reason;
        this.startDate = date;
        this.Daysplanned = Daysplanned;
        this.Dayshappened = Dayshappened;
        this.color = color;
    }

    /**
     * This version of the constuctor is only used within the database data retrieval,
     * it needs all data we are storing else it will not be able to retrieve data properly
     * @param title
     * @param reason
     * @param date
     */
    Habit(String title, String reason, Date date){
        // a simple habit constructor
        this.title = title;
        this.reason = reason;
        this.startDate = date;
    }

    //getters for each of the states of the object
    public String getTitle(){return this.title;}
    public String getReason(){return this.reason;}
    public Date getStartDate(){return this.startDate;}
    Float getDaysplanned(){return this.Daysplanned;}
    Float getDayshappened(){return  this.Dayshappened;}
    Color getColor(){return this.color;}

    //Setting the states of the object
    public void setTitle(String Title){this.title = Title;}
    public void setReason(String reason){this.reason = reason;}
    public void setStartDate(Date date){this.startDate = date;}
    public void setDaysplanned(Float daysplanned){this.Daysplanned = daysplanned;}
    public void setDayshappened(Float dayshappened){this.Dayshappened = dayshappened;}
    @RequiresApi(api = Build.VERSION_CODES.O) // Made me put this in to do the colour part
    public void setColor(){
        Float percent = this.Dayshappened/this.Daysplanned;
        Float green = percent * 255; // This finds the value of the green part of the colour
        Float red = 255 - green; // This finds the value of the blue part of the colour
        Float blue = Float.valueOf(0);
        this.color = Color.valueOf(red,green,blue);
    }

    //Resetting the details of the habit
    public void setHabit(String title, String reason, Date date){
        setTitle(title);
        setReason(reason);
        setStartDate(date);
    }

}
