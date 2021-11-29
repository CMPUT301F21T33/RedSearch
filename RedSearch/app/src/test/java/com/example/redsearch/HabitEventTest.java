/**
 * CMPUT 301 FALL 2021
 * RedSearch Project
 * @author Balreet
 *
 * The {@code HabitEventTest} Class
 *
 * tests functionality of HabitEvent
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
