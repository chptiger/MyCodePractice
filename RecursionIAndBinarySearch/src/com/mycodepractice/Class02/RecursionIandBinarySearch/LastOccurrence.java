package com.mycodepractice.Class02.RecursionIandBinarySearch;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Given a target integer T and an integer array A sorted in ascending order, find the index of the last occurrence of T in A or return -1 if there is no such index.

        Assumptions

        There can be duplicate elements in the array.

        Examples

        A = {1, 2, 3}, T = 2, return 1
        A = {1, 2, 3}, T = 4, return -1
        A = {1, 2, 2, 2, 3}, T = 2, return 3
        Corner Cases

        What if A is null or A is array of zero length? We should return -1 in this case.*/
public class LastOccurrence {
    public int lastOccur(int[] array, int target) {
        if (array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length-1;
        int mid = 0;
        while (left < right-1){
            mid = left + (right-left)/2;
            if (array[mid]<=target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if (array[right]== target){
            return right;
        }else if (array[left] == target){
            return left;
        }else{
            return -1;
        }
    }
    @Test
    public void test_lastOccurance() {
        Assert.assertEquals(-1, lastOccur(new int[]{}, 2));
        Assert.assertEquals(1, lastOccur(new int[]{1, 2, 3}, 2));
        Assert.assertEquals(-1, lastOccur(new int[]{1, 2, 3}, 4));
        Assert.assertEquals(3, lastOccur(new int[]{1, 2, 2, 2, 3}, 2));
        Assert.assertEquals(3, lastOccur(new int[]{2, 2, 2, 2, 3}, 2));
        Assert.assertEquals(4, lastOccur(new int[]{2, 2, 2, 2, 2}, 2));
    }
}
