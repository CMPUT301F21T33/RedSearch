package com.example.redsearch;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import android.graphics.Color;

import java.util.Date;

public class HabitTest {
    private Habit habit;

    @Before
    public void createHabit() {
        habit = new Habit("Drink water", "To stay hydrated",
                new Date(2020, 2, 3), true);
    }

    @Test
    public void testHabitGetters() {
        assertEquals(habit.getTitle(), "Drink water");
        assertEquals(habit.getReason(), "To stay hydrated");
        assertEquals(habit.getStartDate(), new Date(2020, 2, 3));
        assertTrue(habit.getVisible());
    }

    @Test
    public void testHabitSetters() {
        habit.setTitle("Go to sleep");
        assertEquals(habit.getTitle(), "Go to sleep");
        habit.setReason("To get some sleep");
        assertEquals(habit.getReason(), "To get some sleep");
        habit.setvisible(false);
        assertFalse(habit.getVisible());
        habit.setStartDate(new Date(2021, 2, 2));
        assertEquals(habit.getStartDate(), new Date(2021 , 2,2));
        habit.setDaysplanned(2.0F);
        assertEquals(habit.getDaysplanned(), 2.0F, 0);
        habit.setDayshappened(1.0F);
        assertEquals(habit.getDayshappened(), 1.0F, 0);

    }


}
