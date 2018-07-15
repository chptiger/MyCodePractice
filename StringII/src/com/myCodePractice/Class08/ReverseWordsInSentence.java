package com.myCodePractice.Class08;

import org.junit.Assert;
import org.junit.Test;

//Reverse the words in a sentence.
//
//        Assumptions
//
//        Words are separated by single space
//
//        There are no heading or tailing white spaces
//
//        Examples
//
//        "I love Google" -> "Google love I"
//
//        Corner Cases
//
//        If the given string is null, we do not need to do anything.
//        Medium
//        Array
//        String
public class ReverseWordsInSentence {
    public String reverseWords(String input) {
        // Write your solution here
        // Assumption:
        // 1. the words are separated by one space char;
        // 2. There are no leading or trailing spaces
        // 3. input is not null

        // convert string to char[] to solve in place
        char[] array = input.toCharArray();
        // 1. reverse all string
        reverse(array, 0, array.length - 1);
        // 2. reverse each word
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            // 1). find start of a word
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i;
            }
            // 2). find end of a word
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
                reverse(array, start, i);
            }
        }
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
    public void test_reverseWords() {
        Assert.assertEquals("i love google", reverseWords("google love i"));
        Assert.assertEquals("abcd", reverseWords("abcd"));
        Assert.assertEquals("ab cd", reverseWords("cd ab"));
    }
}
