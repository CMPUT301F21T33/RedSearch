/**
 * CMPUT 301 FALL 2021
 * RedSearch Project
 * @author Balreet
 *
 * The {@code HabitListTest} Class
 *
 * Tests functionality of HabitList
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
 * N/A
 * */

package com.example.redsearch;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;

public class HabitListTest {
    private HabitList habitList = new HabitList();
    
    private Habit mockHabit() {
        return new Habit("Eat food", "To be full",
                new Date(2021, 2, 2), true);
    }

    private Habit fakeHabit() {
        return new Habit("Dance", "Why not?",
                new Date(2023, 2, 2), false);
    }

    @Test
    public void testAddHabit() {
        habitList.addHabit(mockHabit());
        assertEquals(1, habitList.getHabitList().size());
        assertEquals(1, habitList.size());  // Also check size method
    }

    @Test
    public void testFailedAddHabit() {
        habitList.addHabit(mockHabit());
        assertEquals(habitList.size(), 1);  // Also check size method
        assertThrows(IllegalArgumentException.class, () -> {
            habitList.addHabit(mockHabit());
        });
    }

    @Test
    public void testRemoveHabit() {
        habitList.addHabit(mockHabit());
        assertEquals(habitList.size(), 1);
        habitList.removeHabit(mockHabit());
        assertEquals(habitList.size(), 0);
    }

    @Test
    public void testFailedRemoveHabit() {
        habitList.addHabit(mockHabit());
        assertEquals(habitList.size(), 1);
        assertThrows(IllegalArgumentException.class, () -> {
            habitList.removeHabit(fakeHabit());
        });
    }

    @Test
    public void testHasHabit() {
        habitList.addHabit(mockHabit());
        assertTrue(habitList.hasHabit(mockHabit()));
        assertFalse(habitList.hasHabit(fakeHabit()));
    }

    @Test
    public void testgetHabit() {
        habitList.addHabit(mockHabit());
        assertEquals(habitList.getHabit(0), mockHabit());
    }
}
