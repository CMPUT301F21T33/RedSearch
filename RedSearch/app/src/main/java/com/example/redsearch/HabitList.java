package com.example.redsearch;

import java.util.ArrayList;

public class HabitList {
    private ArrayList<Habit> habitList = new ArrayList<Habit>();

    /**
     * Habit list constructor
     */
    public HabitList() {}

    /**
     * Get ArrayList of habits
     * @return {@code ArrayList<Habit>} List of habits
     */
    public ArrayList<Habit> getHabitList() {
        return habitList;
    }

    /**
     * Add habit to list
     * @param habit {@code Habit} Habit to be added
     */
    public void addHabit(Habit habit) {
        if(habitList.contains(habit)) {
            throw new IllegalArgumentException();
        }
        habitList.add(habit);
    }

    /**
     * Remove habit from list
     * @param habit {@code Habit} Habit to be removed
     */
    public void removeHabit(Habit habit) {
        if (!habitList.contains(habit)){
            throw new IllegalArgumentException();
        }
        habitList.remove(habit);
    }

    /**
     * Get habit from list
     * @param position {@code int} Position of habit in list
     * @return {@code Habit} The habit inquired about
     */
    public Habit getHabit(int position) {
        return habitList.get(position);
    }

    /**
     * Get size of habit list
     * @return {@code int} Length of habit list
     */
    public int size() {
        return habitList.size();
    }

    /**
     * Check if a habit exists in the habit list
     * @param habit {@code Habit} The inquired habit
     * @return {@code} True if habit exists, False otherwise
     */
    public boolean hasHabit(Habit habit) {
        if (habitList.contains(habit)) {
            return true;
        } else {
            return false;
        }
    }
}
