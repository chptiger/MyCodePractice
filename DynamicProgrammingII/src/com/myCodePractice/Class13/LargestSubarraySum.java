package com.myCodePractice.Class13;

import org.junit.Assert;
import org.junit.Test;

/*
Description
Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.

Assumptions

The given array is not null and has length of at least 1.
Examples

{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5

{-2, -1, -3}, the largest subarray sum is -1
*/
public class LargestSubarraySum {
    public int largestSum(int[] array) {
        // Write your solution here
        // assumption: input array is not null and length >0
        int globalMax = array[0]; // the global largest sum
        int cur = array[0]; // dp[i-1], if dp[i-1] >= 0, keep sum up
        for (int i = 1; i < array.length; i++) {
            cur = Math.max(array[i], array[i] + cur);
            globalMax= Math.max(globalMax, cur);
        }
        return globalMax;
    }

    @Test
    public void test_largestSum() {
        Assert.assertEquals(0, largestSum(new int[]{0, -1, -2, -3}));
        Assert.assertEquals(10, largestSum(new int[]{1, 2, 3, 4, -1}));
        Assert.assertEquals(109, largestSum(new int[]{1, 2, 3, 4, -1, 100}));
        Assert.assertEquals(5, largestSum(new int[]{2, -1, 4, -2, 1}));
        Assert.assertEquals(-1, largestSum(new int[]{-2, -1, -3}));
    }
}
