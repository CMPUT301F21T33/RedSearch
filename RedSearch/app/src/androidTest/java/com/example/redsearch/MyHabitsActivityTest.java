/**
 * CMPUT 301 FALL 2021
 * RedSearch Project
 * @author Sam
 *
 * The {@code MyHabitsActivityTest} Class
 *
 * Test class for MyHabitActivity. All the UI tests are written here. Espresso test framework is
 * used
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

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MyHabitsActivityTest {
    @Rule
    public ActivityScenarioRule<MyHabitsActivity> activityRule =
            new ActivityScenarioRule<>(MyHabitsActivity.class);

    // Unsure what to replace this with as it is depreciated.
//    @Rule
//    public IntentsTestRule<MyHabitsActivity> intentsTestRule =
//            new IntentsTestRule<>(MyHabitsActivity.class);

    @Test
    public void testAddButton(){
        // Click plus button
        onView(withId(R.id.imageButton)).perform(click());

        // Check that the activity changed to creating a habit
        intended(hasComponent(AddHabitActivity.class.getName()));
    }

}
