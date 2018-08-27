package com.mycodepractice.Class01.ArrayAndSorting;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Given an array of balls, where the color of the balls can only be Red, Green or Blue,
        sort the balls such that all the Red balls are grouped on the left side,
        all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side.
        (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).

        Examples

        {0} is sorted to {0}
        {1, 0} is sorted to {0, 1}
        {1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}
        Assumptions

        The input array is not null.
        Corner Cases

        What if the input array is of length zero? In this case, we should not do anything as well.*/
public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int curCursor = 0; // start from here to posBound: elements to be determined
        int negBound = 0; // before negBound (include negBound itself): neg numbers
        int posBound = array.length - 1; // from here (include posBound itself) to end: pos numbers
        while (curCursor <= posBound) {
            if (array[curCursor] == -1) {
                swap(array, curCursor++, negBound++);
            } else if (array[curCursor] == 0) {
                curCursor++;
            } else {
                swap(array, curCursor, posBound--);
            }
        }
        return array;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    @Test
    public void test_rainbow() {
        Assert.assertArrayEquals(new int[]{0}, rainbowSort(new int[]{0}));
        Assert.assertArrayEquals(new int[]{0, 1}, rainbowSort(new int[]{1, 0}));
        Assert.assertArrayEquals(new int[]{-1, 0, 0, 1, 1}, rainbowSort(new int[]{1, 0, 1, -1, 0}));
    }
}
