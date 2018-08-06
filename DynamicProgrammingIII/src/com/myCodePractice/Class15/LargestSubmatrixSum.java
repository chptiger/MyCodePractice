package com.myCodePractice.Class15;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/*
Description
Given a matrix that contains integers, find the submatrix with the largest sum.

Return the sum of the submatrix.

Assumptions

The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
Examples

{ {1, -2, -1, 4},
  {1, -1,  1, 1},
  {0, -1, -1, 1},
  {0,  0,  1, 1} }

the largest submatrix sum = 5
*/
public class LargestSubmatrixSum {
    public int largest(int[][] matrix) {
        // Write your solution here
        int rows = matrix.length;
        int cols = matrix[0].length;
        int globalMax = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            int[] cur = new int[cols];
            for (int j = i; j < rows; j++) {
                add(cur, matrix[j]);
                globalMax = Math.max(globalMax, max(cur));
            }
            System.out.println(Arrays.toString(cur));
        }
        return globalMax;
    }

    private void add(int[] cur, int[] add) {
        for (int i = 0; i < cur.length; i++) {
            cur[i] += add[i];
        }
    }

    private int max(int[] cur) {
        int result = cur[0];
        int temp = cur[0];
        for (int i = 1; i < cur.length; i++) {
            temp = Math.max(temp + cur[i], cur[i]);
            result = Math.max(result, temp);
        }
        return result;
    }

    @Test
    public void testLargestSubmatrixSum() {
        Assert.assertEquals(7, largest(new int[][]{{1, -2, -1, 4}, {1, -1, 1, 1}, {0, -1, -1, 1}, {0, 0, 1, 1}}));
        Assert.assertEquals(4, largest(new int[][]{{-1, -2, -1, 4}, {-1, -1, -1, -1}, {0, -1, -1, -1}, {0, 0, -1, -1}}));
    }
}
