//Description
//        Repeatedly remove all adjacent, repeated characters in a given string from left to right.
//
//        No adjacent characters should be identified in the final string.
//
//        Examples
//
//        "abbbaaccz" → "aaaccz" → "ccz" → "z"
//        "aabccdc" → "bccdc" → "bdc"
package com.myCodePractice.Class07.HashTableAndStringI;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class RemoveAdjacentRepeatedCharactersIV {
    // method 1
    public String deDup(String input) {
        // Write your solution here

        if (input == null || input.length() <= 1) {
            return input;
        }


        return null;
    }

    // method 2 by stack
    public String deDup2(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int end = 0;
        // we use processed array as a stack
        // end represent the head of stack
        // end = 0 means we put array[0] in stack
        for (int i = 1; i < array.length; i++) {
            // Case 1: push stack when
            //          1. if char on cur index not equals the head of stack
            //          2. if current stack is null
            if (end == -1 || array[i] != array[end]) {
                array[++end] = array[i];
            } else {
                // Case 2: pop stack when
                //           head of stack equals char on cur index and next index ...
                end--;
                while (i + 1 < array.length && array[i] == array[i + 1]) {
                    i++;
                }
            }
        }

        return new String(array, 0, end + 1);
    }

    @Test
    public void test_deDup() {
        Assert.assertEquals("z", deDup2("abbbaaccz"));
        Assert.assertEquals("bdc", deDup2("aabccdc"));
        Assert.assertEquals("", deDup2("aaaaaa"));
        Assert.assertEquals("ca", deDup2("abbaca"));
    }
}
