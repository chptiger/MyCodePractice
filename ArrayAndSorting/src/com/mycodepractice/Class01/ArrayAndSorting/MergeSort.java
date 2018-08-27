package com.mycodepractice.Class01.ArrayAndSorting;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Given an array of integers, sort the elements in the array in ascending order. The merge sort algorithm should be used to solve this problem.

        Examples

        {1} is sorted to {1}
        {1, 2, 3} is sorted to {1, 2, 3}
        {3, 2, 1} is sorted to {1, 2, 3}
        {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
        Corner Cases

        What if the given array is null? In this case, we do not need to do anything.
        What if the given array is of length zero? In this case, we do not need to do anything.*/
public class MergeSort {
    public int[] mergeSort(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 1) {
            return array;
        }
        // separate array into 2 arrays, sort, then merge back into one
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        System.arraycopy(array, left, helper, left, right - left + 1);
        int leftCursor = left;
        int rightCursor = mid + 1;
        while (leftCursor <= mid && rightCursor <= right) {
            if (helper[leftCursor] < helper[rightCursor]) {
                array[left++] = helper[leftCursor++];
            } else {
                array[left++] = helper[rightCursor++];
            }
        }
        while (leftCursor <= mid) { // if still have some elements at left, move them to array
            array[left++] = helper[leftCursor++];
        } // if still have some elements at right, no need to move since they are in array already
    }

    @Test
    public void test_mergeSort() {
        Assert.assertArrayEquals(new int[]{1}, mergeSort(new int[]{1}));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, mergeSort(new int[]{1, 2, 3}));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, mergeSort(new int[]{3, 2, 1}));
        Assert.assertArrayEquals(new int[]{-3, 1, 2, 4, 6}, mergeSort(new int[]{4, 2, -3, 6, 1}));
    }
}
