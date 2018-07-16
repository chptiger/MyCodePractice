//Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.
//
//        Assumptions
//
//        s is not null or empty.
//        l is not null.
//        Examples
//
//        l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3
// are all anagrams of "ab" ("ab", "ba").
//        Medium
//        String
package com.myCodePractice.Class08;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class AllAnagrams {
    public List<Integer> allAnagrams(String s, String l) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (l == null || s == null || l.length() == 0 || l.length() < s.length()) {
            return result;
        }
        // this map records for each of the distinct chars in s
        // how many chars are needed
        // e.g. s=abbc, map = a1,b2,c1
        // when we get an instance of a in l, we let count of a decremented by 1
        // and only when the count is from 1 to 0, we have a totally matched
        Map<Character, Integer> map = countMap(s);
        // record how many distinct chars have been matched
        // only when all the distinct characters are matched, A.K.A.
        // match == map.size(), we find an anagram
        int match = 0;
        // we have a sliding window of size s.length, and since the size is fixed
        // we only need to record the end index of the sliding window
        // also, when move the sliding window by one step from left to right
        // what we only need to change is
        // 1. remove the leftmost character at the previous sliding window
        // 2. add the rightmost character at the current sliding window
        for (int i = 0; i<l.length();i++){
            // handle the new added character(rightmost) at the current sliding window
            char temp = l.charAt(i);
            Integer count = map.get(temp);
            if (count != null){
                // the number of needed count should be --
                // and only when the count is from 1 to 0, we find an additional
                // match of distinct char
                map.put(temp, count-1);
                if (count == 1){
                    match++;
                }
            }
            // handle the leftmost char at the previous sliding window
            if (i >= s.length()){
                temp = l.charAt(i-s.length());
                count = map.get(temp);
                if (count != null){
                    // the number of needed count should be ++
                    // and only when the count is from 0 to 1, we are short for one
                    // match of distinct char
                    map.put(temp,count+1);
                    if (count == 0){
                        match--;
                    }
                }
            }
            // for the current sliding window, if all the distinct cars are matched
            // the count are all zero
            if (match == map.size()){
                result.add(i-s.length() + 1);
            }
        }
        return result;
    }

    private Map<Character,Integer> countMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            Integer count = map.get(ch);
            if (count == null){
                map.put(ch,1);
            }else{
                map.put(ch, count +1);
            }
        }
        return map;
    }


    @Test
    public void test_anagrams() {
        Assert.assertEquals(new ArrayList<>(Arrays.asList(0, 3)), allAnagrams("ab", "abcbac"));
    }
}
