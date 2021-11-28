/**
 * CMPUT 301 FALL 2021
 * Project part 3
 * @author
 *
 * The {@code HabitList} Class
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
