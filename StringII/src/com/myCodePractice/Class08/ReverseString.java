package com.myCodePractice.Class08;

import org.junit.Assert;
import org.junit.Test;

//Reverse a given string.
//
//        Assumptions
//
//        The given string is not null.
//        Easy
//        String
public class ReverseString {
    // method 1: iteratively reverse
    public String reverse(String input) {
        // Write your solution here
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        for (int left = 0, right = array.length - 1; left < right; left++, right--) {
            swap(array, left, right);
        }
        return new String(array);
    }

    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    // method 2: recursively reverse
    public String reverse2(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        reverseHelper(array, 0, array.length-1);
        return new String(array);

    }

    private void reverseHelper(char[] array, int left, int right) {
        if (left>= right){
            return;
        }
        swap(array,left, right);
        reverseHelper(array, left+1, right-1);
    }

    @Test
    public void test_reverseString() {
        Assert.assertEquals("dcba", reverse("abcd"));
        Assert.assertEquals("dcba", reverse2("abcd"));
        Assert.assertEquals("", reverse(""));
        Assert.assertEquals("", reverse2(""));
    }
}
