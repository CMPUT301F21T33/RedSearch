package com.example.redsearch;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

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
        assertEquals("Drink water", habit.getTitle());
        assertEquals("To stay hydrated", habit.getReason());
        assertEquals(new Date(2020, 2, 3), habit.getStartDate());
        assertTrue(habit.getVisible());
    }

    @Test
    public void testSetTitle() {
        habit.setTitle("Go to sleep");
        assertEquals("Go to sleep", habit.getTitle());
    }

    @Test
    public void testSetReason() {
        habit.setReason("To get some sleep");
        assertEquals("To get some sleep", habit.getReason());
    }

    @Test
    public void testSetVisible() {
        habit.setVisible(false);
        assertFalse(habit.getVisible());
    }

    @Test
    public void testSetStartDate() {
        habit.setStartDate(new Date(2021, 2, 2));
        assertEquals(new Date(2021 , 2,2), habit.getStartDate());
    }

    @Test
    public void testSetDaysplanned() {
        habit.setDaysplanned(2);
        assertEquals(2, habit.getDaysplanned());
    }

    @Test
    public void testSetDayshappened() {
        habit.setDayshappened(1);
        assertEquals(1, habit.getDayshappened());
    }


    @Test
    public void testHabitOverridden() {
        Habit habit_overriden = new Habit("Don't get hit by a bus", "To not die",
                new Date(2021 , 2,2), 3, true);
        assertEquals(3, habit_overriden.getDaysplanned());
    }

    @Test
    public void testColors() {
        // Grey color
        assertEquals("#808080", habit.getColor());
        habit.setDaysplanned(3);

        // Red color
        assertEquals("#C41E3A", habit.getColor());
        habit.setDayshappened(2);

        // Yellow color
        assertEquals("#FDDA0D", habit.getColor());
        habit.setDayshappened(3);

        // Green color
        assertEquals("#00A36C", habit.getColor());
    }

    @Test
    public void testSetWeekday() {
        habit.setWeekday(1);
        assertTrue(habit.getWeekday(1));
    }

    @Test
    public void testdelWeekday() {
        habit.setWeekday(1);
        assertTrue(habit.getWeekday(1));
        habit.delWeekdayPlan(1);
        assertFalse(habit.getWeekday(1));
    }

    @Test
    public void testHabitEventList() {
        assertEquals(0, habit.countHabitEvents());
        habit.getHabitEventList().addHabitEvent(new HabitEvent("Dogged a bus",
                new Date(2025, 11, 23)));
        assertEquals(1, habit.countHabitEvents());
        habit.getHabitEventList().removeHabitEvent(new HabitEvent("Dogged a bus",
                new Date(2025, 11, 23)));
        assertEquals(0, habit.countHabitEvents());
    }


}
