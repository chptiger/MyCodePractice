//Description
//        Given N pairs of parentheses “()”, return a list with all the valid permutations.
//
//        Assumptions
//
//        N >= 0
//        Examples
//
//        N = 1, all valid permutations are ["()"]
//        N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
//        N = 0, all valid permutations are [""]

package com.myCodePractice.Class06.GraphSearchDFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllValidPermutationsOfParentheses_I {
    public List<String> validParentheses(int k) {
        // Write your solution here.
        List<String> result = new ArrayList<>();
        char[] cur = new char[k * 2];
        helper(cur, k, k, 0, result);
        return result;
    }

    // left: how many '(' we still have
    // right: how many ')' we still have
    // index: the current position in cur we want to fill in with '(' or ')'
    private void helper(char[] cur, int left, int right, int index, List<String> result) {
        System.out.println("left->"+left+" right->"+ right+" index->"+index +" Curr->"+ Arrays.toString(cur));

        // terminate conditions:
        // when we have no parentheses left
        if (left == 0 && right == 0) {
            result.add(new String(cur));
            return;
        }

        // Case 1: when we can add a '('?
        // -> whenever there is some '(' we still have
        if (left > 0) {
            cur[index] = '(';
            helper(cur, left - 1, right, index + 1, result);
        }

        // Case 2: when we can add a ')'
        // -> only if right > left
        if (right > left) {
            cur[index] = ')';
            helper(cur, left, right - 1, index + 1, result);
        }
    }

    @Test
    public void testAllPermutationsOfParentheses() {
        System.out.println(validParentheses(3));
    }
}
