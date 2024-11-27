package com.example.visualsort;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.action.ViewActions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testSortButton_OnDefaultIsClickable() {
        onView(withId(R.id.buttonSort)).check(matches(isClickable()));
    }

    @Test
    public void testSortButton_OnDefaultIsVisible() {
        onView(withId(R.id.buttonSort)).check(matches(isDisplayed()));
    }

    @Test
    public void testNewSortButton_OnDefaultIsClickable() {
        onView(withId(R.id.buttonNewSort)).check(matches(isClickable()));
    }

    @Test
    public void testNewSortButton_OnDefaultIsVisible() {
        onView(withId(R.id.buttonNewSort)).check(matches(isDisplayed()));
    }

    @Test
    public void testNewSortButton_ResetsApp() {
        onView(withId(R.id.buttonNewSort)).perform(ViewActions.click());

        // Expectations:
        // 1) userInput is cleared
        // 2) displaySortTextView has default text
        onView(withId(R.id.userInput)).check(matches(withText("")));
        onView(withId(R.id.displaySortTextView)).check(matches(withText(MainActivity.EXP_DISPLAY_SORT_TEXT)));
    }

    @Test
    public void testClearButtonClearsEditText() {
        // Enter text into the EditText
        onView(withId(R.id.userInput)).perform(ViewActions.typeText("Test input"), closeSoftKeyboard());

        // Click the Clear button
        onView(withId(R.id.buttonClear)).perform(ViewActions.click());

        // Verify the EditText is cleared
        onView(withId(R.id.userInput)).check(matches(withText("")));
    }

}