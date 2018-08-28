package com.mycodepractice.Class02.RecursionIandBinarySearch;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Given a target integer T and an integer array A sorted in ascending order,
        find the index of the first occurrence of T in A or return -1 if there is no such index.

        Assumptions

        There can be duplicate elements in the array.
        Examples

        A = {1, 2, 3}, T = 2, return 1
        A = {1, 2, 3}, T = 4, return -1
        A = {1, 2, 2, 2, 3}, T = 2, return 1
        Corner Cases

        What if A is null or A of zero length? We should return -1 in this case.*/
public class FirstOccurrence {
    public int firstOccur(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int mid = 0;
        int right = array.length - 1; //
        while (left < right - 1) { // left 2 elements, right is target, left is target or not
            mid = left + (right - left) / 2;
            if (array[mid] >= target) { // right might be the answer
                right = mid;
            } else { // left might be 1 before first target
                left = mid;
            }
        }
        // now if the 0-th element is target, left = target
        // or left will never be target
        // right might be target or not
        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
            return right;
        } else {
            return -1;
        }
    }

    @Test
    public void test_firstOccurance() {
        Assert.assertEquals(-1, firstOccur(new int[]{}, 2));
        Assert.assertEquals(1, firstOccur(new int[]{1, 2, 3}, 2));
        Assert.assertEquals(-1, firstOccur(new int[]{1, 2, 3}, 4));
        Assert.assertEquals(1, firstOccur(new int[]{1, 2, 2, 2, 3}, 2));
        Assert.assertEquals(0, firstOccur(new int[]{2, 2, 2, 2, 3}, 2));
    }
}
