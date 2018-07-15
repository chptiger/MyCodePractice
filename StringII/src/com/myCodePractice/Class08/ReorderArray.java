package com.myCodePractice.Class08;

import org.junit.Assert;
import org.junit.Test;

//Description
//        Given an array of elements, reorder it as follow:
//
//        { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
//
//        { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
//
//        Try to do it in place.
//
//        Assumptions
//
//        The given array is not null
//        Examples
//
//        { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
//
//        { 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }
//
//        { 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }
public class ReorderArray {
    public int[] reorder(int[] array) {
        // Write your solution here
        if (array.length % 2 == 0) {
            reorder(array, 0, array.length - 1);
        } else { // if Array has odd elements, ignore the last one
            reorder(array, 0, array.length - 2);
        }
        return array;
    }

    private void reorder(int[] array, int left, int right) {
        int length = right - left + 1;
        if (length <= 2) { // if array has only 1 or 2 elements, no need to calculate, just return
            return;
        }
        // calculate important mid points
        // 0 1 2 3 4 5 6 7
        // lm 2, m 4, rm 6
        // 0 1 2 3 4 5 6 7 8 9
        // lm 2, m 5, rm 7
        int mid = left + length / 2;
        int lmid = left + length / 4;
        int rmid = left + ((length * 3) / 4);
        reverse(array, lmid, mid - 1);
        reverse(array, mid, rmid - 1);
        reverse(array, lmid, rmid - 1);
        // half of the left partition's size = lmid-left
        reorder(array, left, left + (lmid - left) * 2 - 1);
        reorder(array, left + (lmid - left) * 2, right);
    }

    private void reverse(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    @Test
    public void test_StringShuffling() {
        Assert.assertArrayEquals(new int[]{1, 4, 2, 5, 3, 6}, reorder(new int[]{1, 2, 3, 4, 5, 6}));
        Assert.assertArrayEquals(new int[]{1, 4, 2, 5, 3, 6, 7}, reorder(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }
}
