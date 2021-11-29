/**
 * CMPUT 301 FALL 2021
 * RedSarch Project
 * @author Balreet
 *
 * The {@code HabitEventTest} Class
 *
 * tests functionality of HabitEventList
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

public class HabitEventListTest {
    private HabitEventList habitEventList = new HabitEventList();

    private HabitEvent mockHabitEvent() {
        return new HabitEvent("Drank 20mL water",
                new Date(2021, 2, 2));
    }

    private HabitEvent fakeHabitEvent() {
        return new HabitEvent("Danced a tango",
                new Date(2021, 3, 4));
    }

    @Test
    public void testAddHabitEvent() {
        habitEventList.addHabitEvent(mockHabitEvent());
        assertEquals(1, habitEventList.getHabitEventList().size());
        assertEquals(1, habitEventList.size());
    }

    @Test
    public void testFailedAddHabitEvent() {
        habitEventList.addHabitEvent(mockHabitEvent());
        assertEquals(1, habitEventList.size());  // Also check size method
        assertThrows(IllegalArgumentException.class, () -> {
            habitEventList.addHabitEvent(mockHabitEvent());
        });
    }

    @Test
    public void testRemHabitEvent() {
        habitEventList.addHabitEvent(mockHabitEvent());
        assertEquals(1, habitEventList.size());
        habitEventList.removeHabitEvent(mockHabitEvent());
        assertEquals(0, habitEventList.size());
    }

    @Test
    public void testFailedRemHabitEvent() {
        habitEventList.addHabitEvent(mockHabitEvent());
        assertEquals(1, habitEventList.size());
        assertThrows(IllegalArgumentException.class, () -> {
            habitEventList.removeHabitEvent(fakeHabitEvent());
        });
    }

    @Test
    public void testGetHabitEvent() {
        habitEventList.addHabitEvent(mockHabitEvent());
        assertEquals(1, habitEventList.size());
        assertEquals(mockHabitEvent(), habitEventList.getHabitEvent(0));
    }

    @Test
    public void testHasHabitEvent() {
        habitEventList.addHabitEvent(mockHabitEvent());
        assertEquals(1, habitEventList.size());
        assertTrue(habitEventList.hasHabitEvent(mockHabitEvent()));
        assertFalse(habitEventList.hasHabitEvent(fakeHabitEvent()));
    }

}
