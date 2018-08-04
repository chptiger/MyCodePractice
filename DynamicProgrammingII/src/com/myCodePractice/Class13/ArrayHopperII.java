package com.myCodePractice.Class13;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/*
Description
Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
A[i] means the maximum jump distance from index i (you can only jump towards the end of the array).
Determine the minimum number of jumps you need to reach the end of array.
If you can not reach the end of the array, return -1.

Assumptions

The given array is not null and has length of at least 1.
Examples

{3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)

{2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
*/
public class ArrayHopperII {
    // assumption: input array is not null and not empty
    // method 1: DP
    public int minJump(int[] array) {
        // Write your solution here
        int n = array.length;
        int[] minJump = new int[n]; // minJump record the min number of jumps from 0 to each of indices
        minJump[0] = 0;
        for (int i = 1; i < n; i++) {
            minJump[i] = -1; // initialized as unreachable
            for (int j = i - 1; j >= 0; j--) {
                if (j + array[j] >= i && minJump[j] != -1) { // index j can jump to i, and j is reachable
                    if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) { // index i has not been processed or 0->i > 0->j+1
                        minJump[i] = minJump[j] + 1;
                    }
                }
            }
        }
        return minJump[n - 1];
    }

    // method 2: Greedy solution
    public int minJump2(int[] array) {
        if (array.length == 1) {
            return 0;
        }
        int jumps = 0; // num of jumps currently
        int cur = 0; // max index by current num of jumps
        int next = 0; // max index by current + 1 num of jumps
        for (int i = 0; i < array.length; i++) {
            // if index i cannot be reachd by current num of jumps
            // we need jump one more step
            if (i > cur) {
                jumps++;
                // if there is no progress by jumping one more step, means it is unreachable
                if (cur == next) {
                    return -1;
                }
                cur = next;
            }
            next = Math.max(next, array[i] + i);
        }
        return jumps;
    }

    @Test
    public void test_arrayHopperII() {
        Assert.assertEquals(2, minJump(new int[]{3, 3, 1, 0, 4}));
        Assert.assertEquals(-1, minJump(new int[]{2, 1, 1, 0, 2}));
        Assert.assertEquals(2, minJump2(new int[]{3, 3, 1, 0, 4}));
        Assert.assertEquals(-1, minJump2(new int[]{2, 1, 1, 0, 2}));
    }
}
