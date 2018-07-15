package com.myCodePractice.Class08;

import org.junit.Assert;
import org.junit.Test;

//Given an original string input, and two strings S and T, replace all occurrences of S in input with T.
//
//        Assumptions
//
//        input, S and T are not null, S is not empty string
//        Examples
//
//        input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
//        input = "dodododo", S = "dod", T = "a", input becomes "aoao"
public class StringReplace {
    // method 1, use StringBuilder
    public String replace(String input, String s, String t) {
        // Write your solution here
        StringBuilder sb = new StringBuilder();
        // 1. check if there is a s in input
        int fromIndex = 0;
        int matchIndex = input.indexOf(s, fromIndex);
        while (matchIndex != -1) {
            sb.append(input, fromIndex, matchIndex).append(t);
            // 2. next time we need to start from matchIndex + s.length to find if we have later matches
            fromIndex = matchIndex + s.length();
            matchIndex = input.indexOf(s, fromIndex);
        }
        return sb.append(input, fromIndex, input.length()).toString();
    }

    // method 2, use char[]
    // to notice that if s.length < t.length, the result char[] has to increase its size

    @Test
    public void test_stringReplace() {
        Assert.assertEquals("catdogcat", replace("appledogapple", "apple", "cat"));
        Assert.assertEquals("aoao", replace("dodododo", "dod", "a"));
    }
}
