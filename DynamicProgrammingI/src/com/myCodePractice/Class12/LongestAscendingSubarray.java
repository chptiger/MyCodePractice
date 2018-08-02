package com.myCodePractice.Class12;

import org.junit.Assert;
import org.junit.Test;

/*
Description
Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.

Assumptions

The given array is not null
Examples

{7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.

{1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
*/
public class LongestAscendingSubarray {
    public int longest(int[] array) {
        // Write your solution here
        // assumption: input array is not null
        if (array.length == 0) {
            return 0;
        }
        int globalMax = 1;
        int curMax = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                curMax++;
                globalMax = Math.max(curMax, globalMax);
            }else{
                curMax = 1;
            }
        }
        return globalMax;
    }

    @Test
    public void test_LongestAscSubarray() {
        Assert.assertEquals(4, longest( new int[]{7, 2, 3, 1, 5, 8, 9, 6}));
        Assert.assertEquals(5, longest(new int[]{0, 1, 2, 3, 4, 3, 4, 5, 6}));
        Assert.assertEquals(1, longest(new int[]{7, 6, 5, 4, 3}));
        Assert.assertEquals(0, longest(new int[]{}));
        Assert.assertEquals(1, longest(new int[]{3, 2, 1}));
    }
}
