package com.myCodePractice.Class08;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//Description
//        Given a string, find the longest substring without any repeating characters and return the length of it.
// The input string is guaranteed to be not null.
//
//        For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
public class LongestSubstringWithoutRepeatingCharacters {
    public int longest(String input) {
        // Write your solution here
        // assumption: input string is not null
        // the distinct set contains all distinct characters
        // in the sliding window of (slow, fast)
        Set<Character> distinct = new HashSet<>();
        int slow = 0, fast = 0;
        int longest = 0;
        while (fast < input.length()) {
            if (distinct.contains(input.charAt(fast))) {
                // if there is duplicate char, we need to move the slow pointer
                distinct.remove(input.charAt(slow++));
            } else {
                // if there is no duplicate char, we can slide fast pointer
                // and we have a new sliding window of (slow, fast) containing all distinct characters
                distinct.add(input.charAt(fast++));
                longest = Math.max(longest, fast - slow);
            }
        }
        return longest;
    }

    @Test
    public void test_Longest(){
        Assert.assertEquals(4, longest("bcdfbd"));
    }
}
