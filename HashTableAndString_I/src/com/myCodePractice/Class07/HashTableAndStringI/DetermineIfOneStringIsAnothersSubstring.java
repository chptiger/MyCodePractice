//Description
//        Determine if a small string is a substring of another large string.
//
//        Return the index of the first occurrence of the small string in the large string.
//
//        Return -1 if the small string is not a substring of the large string.
//
//        Assumptions
//
//        Both large and small are not null
//        If small is empty string, return 0
//        Examples
//
//        “ab” is a substring of “bcabc”, return 2
//        “bcd” is not a substring of “bcabc”, return -1
//        "" is substring of "abc", return 0
package com.myCodePractice.Class07.HashTableAndStringI;

import org.junit.Assert;
import org.junit.Test;

public class DetermineIfOneStringIsAnothersSubstring {
    public int strstr(String large, String small) {
        // Write your solution here
        // assumption: both large and small are not null
        // Corner case:
        if (large.length()<small.length()){
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= large.length() - small.length(); i++) {
            if (equals(large, small, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean equals(String large, String small, int index) {
        for (int i = 0; i < small.length(); i++) {
            if (small.charAt(i) != large.charAt(i+index)){
                return false;
            }
        }
        return true;
    }

    @Test
    public void testSubstring(){
        Assert.assertEquals(3, strstr("abcde","de"));
        Assert.assertEquals(0, strstr("abcde",""));
        Assert.assertEquals(-1, strstr("abcde","aaaaade"));
        Assert.assertEquals(-1, strstr("abcde","def"));
    }
}
