package com.mycodepractice.Class01.ArrayAndSorting;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Given an array of integers, sort the elements in the array in ascending order. The quick sort algorithm should be used to solve this problem.

        Examples

        {1} is sorted to {1}
        {1, 2, 3} is sorted to {1, 2, 3}
        {3, 2, 1} is sorted to {1, 2, 3}
        {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
        Corner Cases

        What if the given array is null? In this case, we do not need to do anything.
        What if the given array is of length zero? In this case, we do not need to do anything.*/
public class QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        // 1. find the pivot
        // 2. move elements < pivot to left, >= pivot to right
        // recursively repeat 1 and 2
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) { // base case
            return;
        }
        int pivotIndex = partiton(array, left, right); // return new pivotIndex since randomPivot might be changed in partition
        quickSort(array, left, pivotIndex - 1); // pivotIndex should not be included in the next evaluation
        quickSort(array, pivotIndex + 1, right);
    }

    private int partiton(int[] array, int left, int right) {
        // find pivot
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));// +1 to make pivotIndex not 0 when right == left
        // swap pivot to right-most
        swap(array, pivotIndex, right);
        // move numbers < pivot to left, >= pivot to right
        int leftBound = left;
        int rightBound = right - 1; // the right-most is pivot, so end with 2nd last element
        while (leftBound <= rightBound) {
            if (array[leftBound] < array[right]) { // compare with pivot value
                leftBound++;
            } else if (array[rightBound] >= array[right]) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }
        swap(array, leftBound, right);//move pivot back to mid, not use rightBound since rightBound might < 0
        return leftBound; // the newest pivot
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


    @Test
    public void test_quickSort() {
        Assert.assertArrayEquals(new int[]{1}, quickSort(new int[]{1}));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, quickSort(new int[]{1, 2, 3}));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, quickSort(new int[]{3, 2, 1}));
        Assert.assertArrayEquals(new int[]{-3, 1, 2, 4, 6}, quickSort(new int[]{4, 2, -3, 6, 1}));
    }
}
