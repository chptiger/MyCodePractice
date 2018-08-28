package com.mycodepractice.Class02.RecursionIandBinarySearch;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Given a target integer T and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to T.

        Assumptions

        There can be duplicate elements in the array, and we can return any of the indices with same value.
        Examples

        A = {1, 2, 3}, T = 2, return 1
        A = {1, 4, 6}, T = 3, return 1
        A = {1, 4, 6}, T = 5, return 1 or 2
        A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
        Corner Cases

        What if A is null or A is of zero length? We should return -1 in this case.*/
public class ClosestNumberInSortedArray {
    public int closest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int mid = 0;
        int right = array.length - 1;
        while (left < right - 1) { // we want a range: only 2 continues index
            mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.abs(target - array[left]) <= Math.abs(array[right] - target) ? left : right;
    }

    @Test
    public void test_closest() {
        Assert.assertEquals(-1, closest(null, 2));
        Assert.assertEquals(1, closest(new int[]{1, 2, 3}, 2));
        Assert.assertEquals(1, closest(new int[]{1, 4, 6}, 5)); // 1 or 2
        Assert.assertEquals(0, closest(new int[]{1, 3, 3, 4}, 2)); // 0 or 1 or 2
    }
}
