package com.myCodePractice.Class10;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Description
        Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.

        Assumptions

        N > 0
        Return

        A list of ways of putting the N Queens
        Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)
        Example

        N = 4, there are two ways of putting 4 queens:

        [1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3, the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.

        [2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0, the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.

        Medium
        Backtracking
        Depth First Search*/
public class NQueens {
    // method 1, validate the queen position in O(n) each time
    public List<List<Integer>> nqueens(int n) {
        // Write your solution here.
        // Assumption: n > 0
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // cur will be a list of size n, and cur[i] is the column number
        // where the queen on row i positioned.
        List<Integer> cur = new ArrayList<>();
        helper(n, cur, result);
        return result;
    }

    private void helper(int n, List<Integer> cur, List<List<Integer>> result) {
        // base case: when for all the rows we know where the queen is positioned
        if (cur.size() == n) {
            result.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < n; i++) {
            // check if putting a queen at column i at current row is valid
            if (valid(cur, i)) {
                cur.add(i);
                helper(n, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean valid(List<Integer> cur, int column) {
        int row = cur.size();
        for (int i = 0; i < row; i++) {
            if (cur.get(i) == column || Math.abs(cur.get(i) - column) == row -i){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test_NQueens() {
        for (List<Integer> list : nqueens(4)){
            for (Integer i:list){
                System.out.print("->"+i);
            }
            System.out.println();
        }
        //Assert.assertEquals(new ArrayList(Arrays.asList()));
    }
}
