//Description
//        Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.
//
//        Assumptions
//
//        The given input string is not null.
//        The characters to be removed is given by another string, it is guranteed to be not null.
//        Examples
//
//        input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".

package com.myCodePractice.Class07.HashTableAndStringI;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        // Write your solution here
        // Corner case
        if (input == null || t == null) {
            return "";
        }
        if (input.length() == 0 || t.length() == 0 || input.length() < t.length()) {
            return "";
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }

        char[] array = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            // Case 1: if index fast is in target, fast++, slow stay
            // Case 2: if index fast is not in target, fast++ = slow++
            if (!set.contains(array[fast])) {
                array[slow++] = array[fast];
            }
        }

        return new String(array, 0, slow);

    }

    @Test
    public void test_RemovCertainChar() {
        Assert.assertEquals("cd", remove("abcd", "ab"));
        Assert.assertEquals("", remove("abcd","aaaab"));
        Assert.assertEquals("cd",remove("abcd","aab"));
    }
}
