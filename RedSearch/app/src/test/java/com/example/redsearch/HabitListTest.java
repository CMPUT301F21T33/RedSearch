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
        assertEquals(habitList.getHabitList().size(), 1);
        assertEquals(habitList.size(), 1);  // Also check size method
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
