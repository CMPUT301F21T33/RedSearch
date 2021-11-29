/**
 * CMPUT 301 FALL 2021
 * RedSearch Project
 * @author Sam
 *
 * The {@code HomeActivityTest} Class
 *
 * Test class for HomeActivityTest. All the UI tests are written here. Espresso test framework is
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
 * https://developer.android.com/training/testing/espresso/intents
 * https://www.vogella.com/tutorials/AndroidTestingEspresso/article.html#tutorial_unittestactivity
 * https://stackoverflow.com/questions/25998659/espresso-how-can-i-check-if-an-activity-is-launched-after-performing-a-certain
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

import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {
    @Rule
    public ActivityScenarioRule<HomeActivity> activityRule =
            new ActivityScenarioRule<>(HomeActivity.class);

    // Unsure what to replace this with as it is depreciated.
//    @Rule
//    public IntentsTestRule<HomeActivity> intentsTestRule =
//            new IntentsTestRule<>(HomeActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testViewAllButton(){
        // Click view all button
        onView(withId(R.id.viewAll)).perform(click());

        // Check that the activity changed to MyHabitsActivity
        intended(hasComponent(MyHabitsActivity.class.getName()));
    }

    @Test
    public void testFriendsButton(){
        // Click friends button
        onView(withId(R.id.friendsButton)).perform(click());

        // Check that the activity changed to MyHabitsActivity
        intended(hasComponent(FriendsActivity.class.getName()));
    }

    @Test
    public void testEventButton(){
        // Click event button
        onView(withId(R.id.eventButton)).perform(click());

        // Check that the activity changed to MyHabitsActivity
        intended(hasComponent(MyHabitsActivity.class.getName()));
    }

}
