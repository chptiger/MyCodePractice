package com.myCodePractice.Class08;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

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
    public String replace2(String input, String s, String t) {
        char[] array = input.toCharArray();
        if (s.length() >= t.length()) {
            return replaceShorter(array, s, t);
        } else {
            return replaceLonger(array, s, t);
        }
    }

    private String replaceShorter(char[] input, String s, String t) {
        // we reuse the array since the number of char needed is less
        // 2 pointers, slow and fast
        int slow = 0, fast = 0;
        while (fast < input.length) {
            if (fast <= input.length - s.length() && equalSubstring(input, fast, s)) {
                copySubstring(input, slow, t);
                slow += t.length();
                fast += s.length();
            } else {
                input[slow++] = input[fast++];
            }
        }
        return new String(input, 0, slow);
    }

    private String replaceLonger(char[] input, String s, String t) {
        // Notice: we will need a longer array in the case
        // and if the requirement is "in place",
        // usually you can assume you are given a long enough char array already
        // and the original input string resides on part of the char array starting form index 0
        // In this solution, we actually allocate a larger array on demand
        // and the purpose of the solution is to demonstrate how to do it "in place"

        // get all the matches end positions in the input char array of string s
        ArrayList<Integer> matches = getAllMatches(input, s);
        // calculate the new length needed
        char[] result = new char[input.length + matches.size() * (t.length() - s.length())];
        // fast and slow pointers both from right to left direction
        // low: the position when traversing the new length
        // fast: the position when traversing the old length
        // lastIndex: the rightmost matching end position's index
        int lastIndex = matches.size() - 1;
        int fast = input.length - 1;
        int slow = result.length - 1;
        while (fast >= 0) {
            // only if we still have some match and slow is in the position of rightmost matching end position
            // we should copy it
            if (lastIndex >= 0 && fast == matches.get(lastIndex)) {
                copySubstring(result, slow - t.length() + 1, t);
                slow -= t.length();
                fast -= s.length();
                lastIndex--;
            } else {
                result[slow--] = input[fast--];
            }
        }
        return new String(result);
    }

    // get all the matches of s end positions in input
    private ArrayList<Integer> getAllMatches(char[] input, String s) {
        ArrayList<Integer> matches = new ArrayList<>();
        int i = 0;
        while (i <= input.length - s.length()) {
            if (equalSubstring(input, i, s)) {
                // record the match substring's end index instead of start index
                matches.add(i + s.length() - 1);
                i += s.length();
            } else {
                i++;
            }
        }
        return matches;
    }

    // check if the substring from fromIndex is the same as s
    private boolean equalSubstring(char[] input, int fromIndex, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (input[fromIndex + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // coy the string t to result at fromIndex
    private void copySubstring(char[] result, int fromIndex, String t) {
        for (int i = 0; i < t.length(); i++) {
            result[fromIndex + i] = t.charAt(i);
        }
    }

    @Test
    public void test_stringReplace() {
        Assert.assertEquals("catdogcat", replace("appledogapple", "apple", "cat"));
        Assert.assertEquals("catdogcat", replace2("appledogapple", "apple", "cat"));
        Assert.assertEquals("aoao", replace("dodododo", "dod", "a"));
        Assert.assertEquals("aoao", replace2("dodododo", "dod", "a"));
    }
}
