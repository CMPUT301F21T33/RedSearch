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

/**
 * Test class for MyHabitActivity. All the UI tests are written here. Espresso test framework is
 used
 */
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
