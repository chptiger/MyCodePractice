package com.myCodePractice.Class11;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Determine if a given integer is power of 2.

        Examples

        16 is power of 2 (2 ^ 4)
        3 is not
        0 is not
        -1 is not*/
public class DetermineIfANumIsPowerOf2 {
    // method 1, bit operation
    public boolean isPowerOfTwo(int number) {
        // Write your solution here
        if (number <= 0) {
            return false;
        }
        // ignore all trailing 0's
        while ((number & 1) == 0) {
            number >>>= 1;
        }
        // check if number is 1 at the end
        return number == 1;
    }

    // method 2
    public boolean isPowerOfTwo2(int number) {
        if (number <= 0) {
            return false;
        }
        // count the num of 1's
        int count = 0;
        while (number > 0) {
            count += number & 1;
            number >>>= 1;
        }
        // for a number of power of 2, there should be only one 1
        return count == 1;
    }

    // method 3
    public boolean isPowerOfTwo3(int number) {
        // use the trick of num & (num-1) will remove the rightmost 1
        return number > 0 && (number & (number - 1)) == 0;
    }

    @Test
    public void test_PowerOfTwo(){
        Assert.assertEquals(true, isPowerOfTwo(2));
        Assert.assertEquals(true, isPowerOfTwo(4));
        Assert.assertEquals(true, isPowerOfTwo(16));
        Assert.assertEquals(false, isPowerOfTwo(3));

        Assert.assertEquals(true, isPowerOfTwo2(2));
        Assert.assertEquals(true, isPowerOfTwo2(4));
        Assert.assertEquals(true, isPowerOfTwo2(16));
        Assert.assertEquals(false, isPowerOfTwo2(3));

        Assert.assertEquals(true, isPowerOfTwo3(2));
        Assert.assertEquals(true, isPowerOfTwo3(4));
        Assert.assertEquals(true, isPowerOfTwo3(16));
        Assert.assertEquals(false, isPowerOfTwo3(3));
    }

}
