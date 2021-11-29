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
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test class for MainActivity. All the UI tests are written here. Espresso test framework is
 used
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testUsernameSignUp(){
        // Type text and then press the button.
        onView(withId(R.id.username))
                .perform(typeText("test"), closeSoftKeyboard());
        onView(withId(R.id.password))
                .perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.signUp)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.username))
                .check(matches(withText("test")));
        onView(withId(R.id.password))
                .check(matches(withText("123")));

        // Check that the activity changed to home page
        intended(hasComponent(HomeActivity.class.getName()));
    }

    @Test
    public void testUsernameSignIn(){
        // Type text and then press the button.
        onView(withId(R.id.username))
                .perform(typeText("test"), closeSoftKeyboard());
        onView(withId(R.id.password))
                .perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.signIn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.username))
                .check(matches(withText("test")));
        onView(withId(R.id.password))
                .check(matches(withText("123")));

        // Check that the activity changed to home page
        intended(hasComponent(HomeActivity.class.getName()));

    }
}
