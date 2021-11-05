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
