package com.example.visualsort;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.action.ViewActions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
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

    @Test
    public void testMultipleSpaces() {
        // Enter text with multiple spaces and close keyboard
        onView(withId(R.id.userInput)).perform(typeText("1  2   3"), closeSoftKeyboard());

        // Click the Sort button
        onView(withId(R.id.buttonSort)).perform(click());

        // Verify error message in displaySortTextView
        onView(withId(R.id.displaySortTextView)).check(matches(withText("Input cannot have multiple spaces")));
    }

    @Test
    public void testNegativeNumbers() {
        // Enter negative numbers
        onView(withId(R.id.userInput)).perform(typeText("1 -2 3"), closeSoftKeyboard());

        // Click Sort Button
        onView(withId(R.id.buttonSort)).perform(click());

        // Verify error message
        onView(withId(R.id.displaySortTextView)).check(matches(withText("Input cannot contain negative numbers")));
    }

    @Test
    public void testNonNumericInput() {
        // Enter non-numeric input
        onView(withId(R.id.userInput)).perform(typeText("2 3 K"), closeSoftKeyboard());

        // Click Sort button
        onView(withId(R.id.buttonSort)).perform(click());

        // Verify error message
        onView(withId(R.id.displaySortTextView)).check(matches(withText("Input must contain only numbers")));
    }

}