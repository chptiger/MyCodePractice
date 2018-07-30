package com.myCodePractice.Class12;

import org.junit.Assert;
import org.junit.Test;

public class CuttingRope {
    public int maxProductOfCuttingRope(int length) {
        // assumption: length >= 2
        if (length == 2) {
            return 1;
        }
        int[] array = new int[length + 1];
        array[1] = 0;
        array[2] = 1;
        for (int i = 3; i < array.length; i++) {
            // at least one of the partitions after cutting is <= i/2
            // so we can just pick the partition, and find the max product
            for (int j = 1; j <= i / 2; j++) {
                // for the other partion, we can choose not cutting it of
                // cutting it, so the max num we can get is either i-j or array[i-j]
                array[i] = Math.max(array[i], j * Math.max(i - j, array[i - j]));
            }
        }
        return array[length];
    }

    @Test
    public void testCuttingRope(){
        Assert.assertEquals(2, maxProductOfCuttingRope(3));
        Assert.assertEquals(4, maxProductOfCuttingRope(4));
        Assert.assertEquals(18, maxProductOfCuttingRope(8));
    }
}
