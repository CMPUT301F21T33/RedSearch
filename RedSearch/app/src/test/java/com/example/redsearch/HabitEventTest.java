package com.example.redsearch;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.Date;

public class HabitEventTest {

    private HabitEvent habitEvent;

    @Before
    public void createHabitEvent() {
        habitEvent = new HabitEvent("Dogged a bus",
                new Date(2025, 11, 23));
    }

    @Test
    public void testHabitEventGetters() {
        assertEquals("Dogged a bus", habitEvent.getComment());
        assertEquals(new Date(2025, 11, 23), habitEvent.getDate());
    }

    @Test
    public void testSetComment() {
        habitEvent.setComment("Swerved at the bus");
        assertEquals("Swerved at the bus", habitEvent.getComment());
    }

    @Test
    public void testSetDate() {
        habitEvent.setDate(new Date(2011, 3, 4));
        assertEquals(new Date(2011, 3, 4), habitEvent.getDate());
    }
}
