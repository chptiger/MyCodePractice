package com.mycodepractice.Class01.ArrayAndSorting;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Given an array of integers, sort the elements in the array in ascending order. The selection sort algorithm should be used to solve this problem.

        Examples

        {1} is sorted to {1}
        {1, 2, 3} is sorted to {1, 2, 3}
        {3, 2, 1} is sorted to {1, 2, 3}
        {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
        Corner Cases

        What if the given array is null? In this case, we do not need to do anything.
        What if the given array is of length zero? In this case, we do not need to do anything.*/
public class SelectionSort {
    public int[] solve(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) { // i goes on until the second last element
            int min = i;
            for (int j = i; j < array.length; j++) { // j goes on from i-th to the end
                if (array[j] < array[min]) {
                    min = j; // find the minest between i-th and the last element
                }
            }
            // swap the i-th and minest element, i-th element will be evaluate in later loop
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        return array;
    }

    @Test
    public void test_selectionSort() {
        Assert.assertArrayEquals(new int[]{1}, solve(new int[]{1}));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, solve(new int[]{1, 2, 3}));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, solve(new int[]{3, 2, 1}));
        Assert.assertArrayEquals(new int[]{-3, 1, 2, 4, 6}, solve(new int[]{4, 2, -3, 6, 1}));
    }

}
