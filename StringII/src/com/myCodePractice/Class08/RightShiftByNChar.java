package com.myCodePractice.Class08;

import org.junit.Assert;
import org.junit.Test;

//Right shift a given string by n characters.
//
//        Assumptions
//
//        The given string is not null.
//        n >= 0.
//        Easy
//        Array
//        String
public class RightShiftByNChar {
    public String rightShift(String input, int n) {
        // Write your solution here
        // assumption : input != null, n >= 0
        if (input.length() <= 1) {
            return input;
        }

        char[] array = input.toCharArray();
        n %= array.length;
        reverse(array, array.length - n, array.length - 1);
        reverse(array, 0, array.length - n - 1);
        reverse(array, 0, array.length - 1);
        return new String(array);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    @Test
    public void test_rightShift() {
        Assert.assertEquals("efgabcd", rightShift("abcdefg", 3));
        Assert.assertEquals("a", rightShift("a", 3));

    }
}
