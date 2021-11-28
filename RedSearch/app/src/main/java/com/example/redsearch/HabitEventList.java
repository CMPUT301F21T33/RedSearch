/**
 * CMPUT 301 FALL 2021
 * Project part 3
 * @author
 *
 * The {@code HabitEventList} Class
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
     * @return {@code boolean} True if habitEvent exists, False otherwise
     */
    public boolean hasHabitEvent(HabitEvent habitEvent) {
        if (habitEventList.contains(habitEvent)) {
            return true;
        } else {
            return false;
        }
    }



}
