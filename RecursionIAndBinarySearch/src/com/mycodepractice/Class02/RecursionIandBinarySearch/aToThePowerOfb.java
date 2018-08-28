package com.mycodepractice.Class02.RecursionIandBinarySearch;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Evaluate a to the power of b, assuming both a and b are integers and b is non-negative.

        Examples

        power(2, 0) = 1
        power(2, 3) = 8
        power(0, 10) = 0
        power(-2, 5) = -32
        Corner Cases

        What if the result is overflowed? We can assume the result will not be overflowed when we solve this problem on this online judge.*/
public class aToThePowerOfb {
    public long power(int a, int b) {
        if (a == 0 || a == 1) {
            return a;
        }
        if (b==0){
            return 1;
        }else if (b==1){
            return a;
        }else{
            return a*power(a,b-1);
        }
    }

    @Test
    public void test_power() {
        Assert.assertEquals(1, power(2, 0));
        Assert.assertEquals(8, power(2, 3));
        Assert.assertEquals(0, power(0, 10));
        Assert.assertEquals(-32, power(-2, 5));
    }
}
