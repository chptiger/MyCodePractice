package com.myCodePractice.Class12;

import org.junit.Assert;
import org.junit.Test;

/*
Description
Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]p[1] ... p[m-1]? m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.

Assumptions

n >= 2
Examples

n = 12, the max product is 3 3 3 3 = 81(cut the rope into 4 pieces with length of each is 3).
*/
public class MaxProductOfCuttingRope {
    // method 1: 左大段， 右大段
    // Time O(n^2)
    public int maxProduct(int length) {
        // Write your solution here
        int[] M = new int[length + 1];
        M[0] = 0;
        M[1] = 0;
        for (int i = 2; i <= length; i++) {
            int curMax = 0;
            for (int j = 0; j <= i / 2; j++) {
                curMax = Math.max(curMax,
                        Math.max(j, M[j])  // 左大段
                                * Math.max(i - j, M[i - j])); // 右大段
            }
            M[i] = curMax;
        }
        return M[length];
    }

    // method 2: 左大段， 右小段
    public int maxProduct2(int length) {
        int[] M = new int[length + 1];
        M[0] = 0;
        M[1] = 0;
        for (int i = 2; i <= length; i++) {
            int curMax = 0;
            for (int j = 0; j < i; j++) {
                curMax = Math.max(curMax,
                        Math.max(j, M[j]) // 左大段
                                * (i - j)); // 右小段 - 不可再分
            }
            M[i] = curMax;
        }
        return M[length];
    }

    @Test
    public void test_MaxProduct() {
        Assert.assertEquals(0, maxProduct(1));
        Assert.assertEquals(1, maxProduct(2));
        Assert.assertEquals(2, maxProduct(3));
        Assert.assertEquals(4, maxProduct(4));
        Assert.assertEquals(81, maxProduct(12));

        Assert.assertEquals(0, maxProduct2(1));
        Assert.assertEquals(1, maxProduct2(2));
        Assert.assertEquals(2, maxProduct2(3));
        Assert.assertEquals(4, maxProduct2(4));
        Assert.assertEquals(81, maxProduct2(12));
    }
}
