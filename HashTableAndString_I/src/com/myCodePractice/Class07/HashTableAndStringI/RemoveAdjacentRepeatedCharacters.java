//escription
//        Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
//
//        Assumptions
//
//        Try to do it in place.
//        Examples
//
//        “aaaabbbc” is transferred to “abc”
//        Corner Cases
//
//        If the given string is null, we do not need to do anything.
package com.myCodePractice.Class07.HashTableAndStringI;

import org.junit.Assert;
import org.junit.Test;

public class RemoveAdjacentRepeatedCharacters {
    public String deDup(String input) {
        // Write your solution here
        if (input == null || input.length() <= 1){
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 1;
        for (int fast = 1; fast<array.length;fast++){
            if (array[fast] != array[fast-1]){
                array[slow++] = array[fast];
            }
        }
        return new String(array, 0, slow);
    }

    @Test
    public void test_RemoveAdjancent(){
        Assert.assertEquals("abc", deDup("aaaabbbbcccc"));
        Assert.assertEquals("a", deDup("a"));
        Assert.assertEquals("a", deDup("aaaaa"));
        Assert.assertEquals("", deDup(""));
        Assert.assertEquals("abc", deDup("abc"));
    }
}
