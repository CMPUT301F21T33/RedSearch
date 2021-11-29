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

/**
 * Test class for HomeActivity. All the UI tests are written here. Espresso test framework is
 used
 */
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
