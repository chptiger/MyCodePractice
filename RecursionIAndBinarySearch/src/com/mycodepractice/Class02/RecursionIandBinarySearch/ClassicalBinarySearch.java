package com.mycodepractice.Class02.RecursionIandBinarySearch;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.

        Assumptions

        There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.
        Examples

        A = {1, 2, 3, 4, 5}, T = 3, return 2
        A = {1, 2, 3, 4, 5}, T = 6, return -1
        A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3
        Corner Cases

        What if A is null or A is of zero length? We should return -1 in this case.*/
public class ClassicalBinarySearch {
    public int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int mid = 0;
        int left = 0;
        int right = array.length - 1;
        // has to be <= but <, since mid might = right when only last and 2nd last element were left
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void test_CBS() {
        Assert.assertEquals(2, binarySearch(new int[]{1, 2, 3, 4, 5}, 3));
        Assert.assertEquals(4, binarySearch(new int[]{1, 2, 3, 4, 5}, 5));
        Assert.assertEquals(2, binarySearch(new int[]{1, 2, 3, 4}, 3));
        Assert.assertEquals(3, binarySearch(new int[]{1, 2, 3, 4}, 4));
        Assert.assertEquals(-1, binarySearch(new int[]{1, 2, 3, 4, 5}, 6));
        Assert.assertEquals(-1, binarySearch(null, 2));
    }
}
