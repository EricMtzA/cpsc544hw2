package com.example.visualsort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void sort_empty() {
        VisualSort vs = new VisualSort();

        int[] expectedArray = { };
        int[] actualArray = vs.sort("");
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testMinInput() {
        // Unit Test 1: Verify if the input has a minimum of 3 numbers
        VisualSort vs = new VisualSort();
        int[] expectedArray = new int[]{ }; //Return Empty Array with Invalid input
        int[] actualArray = vs.sort("1 2"); //User Provides 2 Numbers
        assertArrayEquals("Invalid Input: Need at Least 3 Numbers",expectedArray, actualArray);
    }

    @Test
    public void testMaxInput() {
        // Unit Test 2: Verify if the input has less than 8 numbers
        VisualSort vs = new VisualSort();
        int[] expectedArray = new int[]{ }; //Return Empty Array with Invalid input
        int[] actualArray = vs.sort("1 2 3 4 5 6 7 8 9"); //User Provides 9 Numbers
        assertArrayEquals("Invalid Input: Maximum of 8 Numbers Allowed",expectedArray, actualArray);
    }

}