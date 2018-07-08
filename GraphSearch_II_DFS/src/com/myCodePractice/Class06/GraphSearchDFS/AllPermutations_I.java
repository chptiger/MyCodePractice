//Description
//        Given a string with no duplicate characters, return a list with all permutations of the characters.
//
//        Examples
//
//        Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
//        Set = "", all permutations are [""]
//        Set = null, all permutations are []

package com.myCodePractice.Class06.GraphSearchDFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutations_I {
    public List<String> permutations(String set) {
        // Write your solution here.
        List<String> result = new ArrayList<String>();
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }

    // solution 1: DFS with swapping
    // choose the character to be at the position of "index"
    // all the already chosen positions are (0, index-1)
    // all the candidate characters can be at position "index"
    // are in the subarray of (index, array.length-1)
    private void helper(char[] array, int index, List<String> result) {
        // terminate conditions:
        // only when we have already chosen the characters for all position,
        // we can have a complete permutation
        System.out.println("index->" + index + " " + new String(array));

        if (index == array.length - 1) {
            result.add(new String(array));
            return;
        }

        // all the possible characters could be placed at index are
        // the characters in the subarray (index, array.length-1)
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index + 1, result);
            swap(array, index, i);
        }
    }

    private void swap(char[] array, int left, int right) {
        if (left == right) {
            return;
        } else if (array[left] == array[right]) {
            return;
        }
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


    @Test
    public void testAllPermutations() {
        System.out.println(permutations("abc"));
    }
}
