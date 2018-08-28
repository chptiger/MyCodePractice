package com.mycodepractice.Class02.RecursionIandBinarySearch;
/*
Description
        Given a integer dictionary A of unknown size,
        where the numbers in the dictionary are sorted in ascending order,
        determine if a given target integer T is in the dictionary.
        Return the index of T in A, return -1 if T is not in A.

        Assumptions

        dictionary A is not null
        dictionary.get(i) will return null(Java)/INT_MIN(C++)/None(Python) if index i is out of bounds
        Examples

        A = {1, 2, 5, 9, ......}, T = 5, return 2
        A = {1, 2, 5, 9, 12, ......}, T = 7, return -1
*/

import org.junit.Assert;
import org.junit.Test;

public class SearchInUnknownSizedArray {
    public int search(Dictionary dict, int target) {
        if (dict == null) {
            return -1;
        }
        // find right bound first
        int left = 0;
        int right = 1;
        while (dict.get(right) != null && dict.get(right) < target) {
            left = right;
            right *= 2;
        }
        return binarySearch(dict, left, right, target);
    }

    private int binarySearch(Dictionary dict, int left, int right, int target) {
        int mid = left;
        while (left <= right) {
            mid = left + (right - left) / 2;
             if (dict.get(mid) == null || dict.get(mid) > target) {
                right = mid - 1;
            } else if (dict.get(mid) == target) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void test_unknownSizedArray() {
        Assert.assertEquals(0, search(new DictImpl(new int[]{0,1,2,3}), 0));
        Assert.assertEquals(1, search(new DictImpl(new int[]{0,1,2,3}), 1));
        Assert.assertEquals(-1, search(new DictImpl(new int[]{0,1,2,3}), 4));
        Assert.assertEquals(3, search(new DictImpl(new int[]{0,1,2,3}), 3));
    }
}
