//Given a string with possible duplicate characters, return a list with all permutations of the characters.
//
//        Examples
//
//        Set = °∞abc°±, all permutations are [°∞abc°±, °∞acb°±, °∞bac°±, °∞bca°±, °∞cab°±, °∞cba°±]
//        Set = "aba", all permutations are ["aab", "aba", "baa"]
//        Set = "", all permutations are [""]
//        Set = null, all permutations are []
//        Hard
//        Depth First Search
package com.myCodePractice.Class08;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

// all permutations with duplicate characters
public class AllPermutationsII {
    public List<String> permutations(String set) {
        // Write your solution here.
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }

    // index: at the level of index, we are to determined for the current permutation,
    // which element is positioned at the index
    private void helper(char[] array, int index, List<String> result) {
        // Base case: if we have already determined for the current permutation,
        // which element is positioned at the index
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        // Notice: the rule is just for the current level,
        // if a certain element is picked,
        // we cannot pick any of its duplicates.
        // so that we use a set to record all the distinct elements
        Set<Character> used = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            // user.add(array[i]) will return false if the value of array[i] is already in set
            if (used.add(array[i])) {
                swap(array, i, index);
                // go to next level, index + 1
                helper(array, index + 1, result);
                // don't forget to do the clear operation when backtracking
                swap(array, i, index);
            }
        }
    }

    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    @Test
    public void test_allPermutations() {
        Assert.assertEquals(new ArrayList<>(Arrays.asList("aba", "aab", "baa")), permutations("aba"));
        Assert.assertEquals(new ArrayList<>(Arrays.asList("abc", "acb", "bac","bca","cba","cab")), permutations("abc"));
    }
}
