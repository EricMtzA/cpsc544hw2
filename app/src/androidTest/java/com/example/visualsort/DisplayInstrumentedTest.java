package com.example.visualsort;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class DisplayInstrumentedTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testSortButton_OnDefaultIsClickable() {
        onView(withId(R.id.buttonSort)).check(matches(isClickable()));
    }

    @Test
    public void testNewSortButton() {
        // input text and sort
        onView(withId(R.id.userInput)).perform(typeText("3 2 1"), closeSoftKeyboard());

        // click sort
        onView(withId(R.id.buttonSort)).perform(click());

        // Click new sort
        onView(withId(R.id.buttonNewSort)).perform(click());

        // Verify reset to initial state
        onView(withId(R.id.userInput)).check(matches(withText("")));
        onView(withId(R.id.displaySortTextView)).check(matches(withText(MainActivity.EXP_DISPLAY_SORT_TEXT)));
    }

    @Test
    public void testEmptyString() {
        // input empty string
        onView(withId(R.id.userInput)).perform(typeText(""), closeSoftKeyboard());

        // Click Sort button
        onView(withId(R.id.buttonSort)).perform(click());

        // Verify error message
        // inRoot(isDialog()) Look in dialog window instead of main window
        onView(withId(R.id.errorTitle)).inRoot(isDialog()).check(matches(withText("Error")));
        onView(withId(R.id.errorDesc)).inRoot(isDialog()).check(matches(withText("Input must contain at least 3 numbers")));
    }

    @Test
    public void testTooManyNumbers() {
        // Input 9 numbers
        // Expecting error message
        onView(withId(R.id.userInput)).perform(typeText("9 8 7 6 5 4 3 2 1"), closeSoftKeyboard());

        // Click Sort button
        onView(withId(R.id.buttonSort)).perform(click());

        // Verify error message
        // inRoot(isDialog()) Look in dialog window instead of main window
        onView(withId(R.id.errorTitle)).inRoot(isDialog()).check(matches(withText("Error")));
        onView(withId(R.id.errorDesc)).inRoot(isDialog()).check(matches(withText("Input must contain 8 or fewer numbers")));
    }

    @Test
    public void testTooLittleNumbers() {
        // Input 2 numbers
        // Expecting error message
        onView(withId(R.id.userInput)).perform(typeText("1 2"), closeSoftKeyboard());

        // Click Sort button
        onView(withId(R.id.buttonSort)).perform(click());

        // Verify Error Message
        // inRoot(isDialog()) Look in dialog window instead of main window
        onView(withId(R.id.errorTitle)).inRoot(isDialog()).check(matches(withText("Error")));
        onView(withId(R.id.errorDesc)).inRoot(isDialog()).check(matches(withText("Input must contain at least 3 numbers")));
    }

    @Test
    public void testNonNumericInput() {
        // input character
        onView(withId(R.id.userInput)).perform(typeText("2 3 K"), closeSoftKeyboard());

        // Click Sort button
        onView(withId(R.id.buttonSort)).perform(click());

        // Verify error message
        onView(withId(R.id.errorTitle)).inRoot(isDialog()).check(matches(withText("Error")));
        onView(withId(R.id.errorDesc)).inRoot(isDialog()).check(matches(withText("Input must contain only single-digit numbers")));
    }

    @Test
    public void testLargeNumbers() {
        //Input large number
        onView(withId(R.id.userInput)).perform(typeText("12 3 4"), closeSoftKeyboard());

        // Click sort
        onView(withId(R.id.buttonSort)).perform(click());

        //Verify Error message
        onView(withId(R.id.errorTitle)).inRoot(isDialog()).check(matches(withText("Error")));
        onView(withId(R.id.errorDesc)).inRoot(isDialog()).check(matches(withText("Numbers must be single digit")));
    }

    @Test
    public void testMultipleSpaces() {
        // input with multiple spaces
        onView(withId(R.id.userInput)).perform(typeText("1  2   3"), closeSoftKeyboard());

        // Click the Sort button
        onView(withId(R.id.buttonSort)).perform(click());

        // Verify display sort
        onView(withId(R.id.displaySortTextView)).check(matches(withSubstring("Input array:")));
    }

    @Test
    public void testNegativeNumbers() {
        // input with negative numbers
        onView(withId(R.id.userInput)).perform(typeText("1 -2 3"), closeSoftKeyboard());

        // Click Sort Button
        onView(withId(R.id.buttonSort)).perform(click());

        // Verify error message
        onView(withId(R.id.errorTitle)).inRoot(isDialog()).check(matches(withText("Error")));
        onView(withId(R.id.errorDesc)).inRoot(isDialog()).check(matches(withText("Input cannot contain negative numbers")));
    }

}
