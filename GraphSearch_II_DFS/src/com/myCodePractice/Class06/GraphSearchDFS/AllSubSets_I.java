//Description
//        Given a set of characters represented by a String, return a list containing all subsets of the characters.
//
//        Assumptions
//
//        There are no duplicate characters in the original set.
//        ​Examples
//
//        Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
//        Set = "", all the subsets are [""]
//        Set = null, all the subsets are []

package com.myCodePractice.Class06.GraphSearchDFS;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AllSubSets_I {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> list = new ArrayList<>();
        if (set == null) {
            return list;
        }

        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, list);
        return list;
    }

    // solution 1
    private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        // terminate condition:
        // when we finishes determining for all the characters pick or not,
        // we have a complete subset
        if (index == set.length) {
            result.add(sb.toString());
            return;
        }
        // not pick the character at index
        helper(set, sb, index + 1, result);
        // pick the character at index
        helper(set, sb.append(set[index]), index + 1, result);
        // remember to remove the added character when back tracking to the previous level
        sb.deleteCharAt(sb.length() - 1);
    }

    // solution 2
    private void helper2(char[] set, StringBuilder sb, int index, List<String> result) {
        result.add(sb.toString());
        // maintains ascending order of the indices of picked characters
        // choose the next picked index -> the smallest one can be picked is index
        for (int i = index; i < set.length; i++) {
            sb.append(set[i]);
            helper2(set, sb, i + 1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    @Test
    public void testDFS1() {
        System.out.println(subSets("abcd"));
    }
}
