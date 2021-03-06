package com.myCodePractice.Class12;

import org.junit.Assert;
import org.junit.Test;

/*
Description
Jump Game
Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
A[i] means the maximum jump distance from that position (you can only jump towards the end of the array).
Determine if you are able to reach the last index.

Assumptions

The given array is not null and has length of at least 1.
Examples

{1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)

{2, 1, 1, 0, 2}, we are not able to reach the end of array
*/
public class ArrayHopperI {
    // assumption: array is not null and not empty, the 1st element is not 0
    // method 1: DP, canJump[i] means from index 0, can jump to i -> from head to end
    public boolean canJump(int[] array) {
        // Write your solution here
        boolean[] canJump = new boolean[array.length];
        canJump[0] = true;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                // if index j is reachable from index 0, and from index j, it is possible to jump to index i
                if (canJump[j] && array[j] + j >= i) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[array.length - 1];
    }

    // method 2: DP, canJump[i] means from index i can jump to end -> from end to head
    public boolean canJump2(int[] array) {
        if (array.length == 1) {
            return true;
        }
        boolean[] canJump = new boolean[array.length];
        for (int i = array.length - 2; i >= 0; i--) {
            // if from index i, it is already possible to jump to the end
            if (i + array[i] >= array.length - 1) {
                canJump[i] = true;
            } else {
                // if any of the reachable indices from index i is reachable to the end
                for (int j = array[i]; j >= 1; j--) {
                    if (canJump[j + i]) {
                        canJump[i] = true;
                        break;
                    }
                }
            }
        }
        return canJump[0];
    }

    // method 3: Greedy solution
    // keep the max index reachable by jumping * steps, and the max index reachable by jumping x+1 steps
    public boolean canJump3(int[] array) {
        if (array.length == 1) {
            return true;
        }
        // the max index jumping current steps can reach
        int cur = 0;
        // the max index jumping current + 1 steps can reach
        int next = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > cur) {
                // if i > cur, we can not use use current steps to jump to i
                if (cur == next) {
                    // cur == next means there is no progress for using current +1 steps,
                    // if that is the case, we can never reach end
                    return false;
                }
                cur = next;
            }
            // update the max index jumping one more step can reach
            next = Math.max(next, i + array[i]);
        }
        return true;
    }

    @Test
    public void testArrayHopper() {
        Assert.assertEquals(true, canJump(new int[]{1, 3, 2, 0, 3}));
        Assert.assertEquals(false, canJump(new int[]{2, 1, 1, 0, 3}));
        Assert.assertEquals(true, canJump(new int[]{1}));

        Assert.assertEquals(true, canJump2(new int[]{1, 3, 2, 0, 3}));
        Assert.assertEquals(false, canJump2(new int[]{2, 1, 1, 0, 3}));
        Assert.assertEquals(true, canJump2(new int[]{1}));

        Assert.assertEquals(true, canJump3(new int[]{1, 3, 2, 0, 3}));
        Assert.assertEquals(false, canJump3(new int[]{2, 1, 1, 0, 3}));
        Assert.assertEquals(true, canJump3(new int[]{1}));
    }
}
