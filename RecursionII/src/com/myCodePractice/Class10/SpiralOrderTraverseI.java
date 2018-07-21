package com.myCodePractice.Class10;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Traverse an N N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.
        Assumptions
        The 2D array is not null and has size of N N where N >= 0
        Examples
        { {1,  2,  3},
        {4,  5,  6},
        {7,  8,  9} }
        the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
        Medium
        2 D Array*/
public class SpiralOrderTraverseI {
    // method 1, recursive
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        // assumption matrix is N * N N >=0, N not null
        List<Integer> list = new ArrayList<>();
        recursiveTraverse(matrix, 0, matrix.length, list);
        return list;
    }

    private void recursiveTraverse(int[][] matrix, int offset, int size, List<Integer> result) {
        // base case
        if (size == 0) {
            return;
        }
        if (size == 1) {
            result.add(matrix[offset][offset]);
            return;
        }
        // print 4 sides one by one
        // print top row
        for (int i = 0; i < size; i++) {
            result.add(matrix[offset][offset + i]);
        }
        // print right column
        for (int i = 1; i < size; i++) {
            result.add(matrix[offset + i][offset + size - 1]);
        }
        // print bottom row
        for (int i = size - 2; i >= 0; i--) {
            result.add(matrix[offset + size - 1][offset + i]);
        }
        // print left column
        for (int i = size - 2; i >= 1; i--) {
            result.add(matrix[offset + i][offset]);
        }
        recursiveTraverse(matrix, offset + 1, size - 2, result);
    }

    // method 2, iterative
    public List<Integer> spiral2(int[] matrix) {
        return null;
    }

    @Test
    public void test_Spiral() {
        Assert.assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)), spiral(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(1, 2, 9, 8)), spiral(new int[][]{{1, 2}, {8, 9}}));
    }

}
