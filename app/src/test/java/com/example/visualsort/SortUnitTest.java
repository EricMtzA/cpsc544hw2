package com.example.visualsort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


/*
 * Input consists of a set of Integer numbers [between 0 and 9 only]. If the
 * input does not meet the min/max numbers, issue an error message, and ask
 * to correct for another chance.
 *  Use an array to align input values.
 *  The maximum input size = 8 (otherwise, issue an error message)
 *  The minimum input size = 3 (otherwise, issue an error message)
 */
public class SortUnitTest {
    @Test
    public void sort_empty() {
        VisualSort vs = new VisualSort();

        int[] expectedArray = { };
        int[] actualArray = vs.sort("");

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void sort_normal() {
        VisualSort vs = new VisualSort();

        int[] expectedArray = { 1, 2, 3, 4, 5 };
        int[] actualArray = vs.sort("5 4 3 2 1");

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void sort_ThrowException_WhenInputIsNull() {
        // Arrange
        VisualSort vs = new VisualSort();

        // Act & Assert
        Exception exception = assertThrows(NullPointerException.class, () -> vs.sort(null));

        // Verify exception message
        assertEquals("Input cannot be null", exception.getMessage());
    }

    @Test
    public void sort_checkBoundaryEightNumbers() {
        // Arrange
        int[] expectedArray = { 0, 1, 2, 2, 3, 4, 7, 9 };
        VisualSort vs = new VisualSort();

        // Act & Assert
        int[] actualArray = vs.sort("4 3 7 9 2 0 1 2");

        // Verify array is sorted
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void sort_ThrowException_WhenInputContainsMoreThanEightNumbers() {
        // Arrange
        VisualSort vs = new VisualSort();

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> vs.sort("1 2 3 4 5 6 7 8 9"));

        // Verify exception message
        assertEquals("Input must contain 8 or fewer numbers", exception.getMessage());
    }

    @Test
    public void sort_checkBoundaryThreeNumbers() {
        // Arrange
        int[] expectedArray = { 2, 5, 7 };
        VisualSort vs = new VisualSort();

        // Act & Assert
        int[] actualArray = vs.sort("5 2 7");

        // Verify array is sorted
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void sort_ThrowException_WhenInputContainsLessThanThreeNumbers() {
        // Arrange
        VisualSort vs = new VisualSort();

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> vs.sort("4 2"));

        // Verify exception message
        assertEquals("Input must contain at least 3 numbers", exception.getMessage());
    }

    @Test
    public void sort_ThrowException_WhenInputContainsNonNumbers() {
        // Arrange
        VisualSort vs = new VisualSort();

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> vs.sort("4 2 9 a 2 0"));

        // Verify exception message
        assertEquals("Input must contain only single-digit numbers", exception.getMessage());
    }

    @Test
    public void sort_ThrowException_WhenNumbersAreNotSingleDigit() {
        // Arrange
        VisualSort vs = new VisualSort();

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> vs.sort("2 8 3 87 10 3"));

        // Verify exception message
        assertEquals("Numbers must be single digit", exception.getMessage());
    }
}