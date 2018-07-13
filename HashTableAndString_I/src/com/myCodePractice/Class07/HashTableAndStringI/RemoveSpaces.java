//Description
//        Given a string, remove all leading/trailing/duplicated empty spaces.
//
//        Assumptions:
//
//        The given string is not null.
//        Examples:
//
//        “  a” --> “a”
//        “   I     love MTV ” --> “I love MTV”
package com.myCodePractice.Class07.HashTableAndStringI;

import org.junit.Assert;
import org.junit.Test;

public class RemoveSpaces {
    public String removeSpaces(String input) {
        // Write your solution here
        if (input == null || input.isEmpty()) {
            return "";
        }
        int end = 0;
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length; i++) {
            // case 1 move the first non-space char to index 0
            // case 2 for consecutive spaces
            //          if the previous one is not-null, remain the space
            //          else ignore and go to next char
            if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) {
                continue;
            }
            array[end++] = array[i];
        }
        // Process the last char since it might be a space left
        if (end > 0 && array[end - 1] == ' ') {
            return new String(array, 0, end - 1);
        }
        return new String(array, 0, end);
    }

    @Test
    public void test_RemoveSpaces() {
        Assert.assertEquals("a", removeSpaces(" a"));
        Assert.assertEquals("a", removeSpaces(" a  "));
        Assert.assertEquals("a b c", removeSpaces(" a b c "));
        Assert.assertEquals("a b", removeSpaces(" a  b "));
        Assert.assertEquals("", removeSpaces(" ")); // one space
        Assert.assertEquals("", removeSpaces("     "));
    }
}
