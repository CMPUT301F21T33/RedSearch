package com.example.redsearch;

import java.util.ArrayList;

public class HabitEventList {
    private ArrayList<HabitEvent> habitEventList = new ArrayList<HabitEvent>();

    /**
     * Habit list constructor
     */
    public HabitEventList() {}

    /**
     * Get ArrayList of habitEvents
     * @return {@code ArrayList<HabitEvent>} List of habitEvents
     */
    public ArrayList<HabitEvent> getHabitEventList() {
        return habitEventList;
    }

    /**
     * Add habit event to list
     * @param habitEvent {@code HabitEvent} HabitEvent to be added
     */
    public void addHabitEvent(HabitEvent habitEvent) {
        if(habitEventList.contains(habitEvent)) {
            throw new IllegalArgumentException();
        }
        habitEventList.add(habitEvent);
    }

    /**
     * Remove habitEvent from list
     * @param habitEvent {@code HabitEvent} Habit to be removed
     */
    public void removeHabitEvent(HabitEvent habitEvent) {
        if (!habitEventList.contains(habitEvent)){
            throw new IllegalArgumentException();
        }
        habitEventList.remove(habitEvent);
    }

    /**
     * Get habitEvent from list
     * @param position {@code int} Position of habitEvent in list
     * @return {@code HabitEvent} The habitEvent inquired about
     */
    public HabitEvent getHabitEvent(int position) {
        return habitEventList.get(position);
    }

    /**
     * Get size of habitEvent list
     * @return {@code int} Length of habitEvent list
     */
    public int size() {
        return habitEventList.size();
    }

    /**
     * Check if a habitEvent exists in the habitEvent list
     * @param habitEvent {@code HabitEvent} The inquired habitEvent
     * @return {@code} True if habitEvent exists, False otherwise
     */
    public boolean hasHabitEvent(HabitEvent habitEvent) {
        if (habitEventList.contains(habitEvent)) {
            return true;
        } else {
            return false;
        }
    }



}
