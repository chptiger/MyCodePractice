package com.myCodePractice.Class10;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Description
        Traverse an M  N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

        Assumptions

        The 2D array is not null and has size of M  N where M, N >= 0
        Examples
        { {1,  2,  3,  4},
        {5,  6,  7,  8},
        {9, 10, 11, 12} }
        the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
        Medium
        2 D Array*/
public class SpiralOrderTraverseII {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        // assumption: matrix is not null, has size of M * N, M,N > 0
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) { // handle matrix[0].length to avoid ArrayIndexOutofBoundException
            return result;
        }
        int n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        // base case
        // 1. nothing left
        // 2. left 1 row
        // 3. left 1 column
        while (left < right && top < bottom) {
            // print top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            // print right column
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            // print bottom row
            for (int i = right - 1; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            // print right column
            for (int i = bottom - 1; i > top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        // 1. there is nothing left
        if (left > right || top > bottom) {
            return result;
        }
        // if M = N, supposed to have 1 element left
        if (left == right && top == bottom){
            result.add(matrix[top][left]);
            return result;
        }
        // 2. there is 1 column left
        if (left == right ) {
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][left]);
            }
        }
        // 3. there is 1 row left
        if (top == bottom )  {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
        }
        return result;
    }

    @Test
    public void test_spiralII() {
        Assert.assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)), spiral(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8)), spiral(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}}));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)), spiral(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(1, 2, 9, 8)), spiral(new int[][]{{1, 2}, {8, 9}}));
    }
}
