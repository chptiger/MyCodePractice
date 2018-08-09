package com.myCodePractice.Class15;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Description
Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.

Assumptions

The given array is not null
Examples

{0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.
*/
public class LongestConsecutive1s {
    public int longest(int[] array) {
        // Write your solution here
        // assumption: input array is not null
        int globalMax = 0;
        int curMax = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1){
                if (i == 0 || array[i-1] == 0){
                    curMax = 1;
                }else{
                    curMax++;
                }
            }
            globalMax = Math.max(curMax, globalMax);
        }
        return globalMax;
    }

    @Test
    public void testLongestConsecutive1s() {
        Assert.assertEquals(3, longest(new int[]{0, 1, 0, 1, 1, 1, 0}));
        Assert.assertEquals(1, longest(new int[]{0, 1, 0, 1, 0}));
    }
}
