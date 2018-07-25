package com.myCodePractice.Class11;

import org.junit.Assert;
import org.junit.Test;

//Description
//        Determine the number of bits that are different for two given integers.
//
//        Examples
//
//        5(“0101”) and 8(“1000”) has 3 different bits
public class NumberOfDifferentBits {
    public int diffBits(int a, int b) {
        // Write your solution here
        // after exclusive or , only the bits where a and b are different will be 1
        a ^= b;
        int count = 0;
        while (a != 0) {
            count += a & 1;
            a >>>= 1;
        }
        return count;
    }

    @Test
    public void test_diffBits() {
        Assert.assertEquals(3, diffBits(5, 8));
        Assert.assertEquals(2, diffBits(1, 8));
    }
}

