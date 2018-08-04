package com.myCodePractice.Class13;

import org.junit.Assert;
import org.junit.Test;

/*
Description
Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.

Assumptions

The given matrix is not null and guaranteed to be of size N * N, N >= 0
Examples

{ {0, 0, 0, 0},
  {1, 1, 1, 1},
  {0, 1, 1, 1},
  {1, 0, 1, 1}}

the largest square of 1s has length of 2
*/
public class LargestSquareOfOnes {
    public int largest(int[][] matrix) {
        // Write your solution here
        // assumption: matrix.length > 0
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int globalMax = 0;
        int[][] max = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 || col == 0) {
                    max[row][col] = matrix[row][col] == 1 ? 1 : 0;
                } else if (matrix[row][col] == 1) {
                    max[row][col] = getMin(max[row - 1][col - 1], max[row][col - 1], max[row - 1][col]) + 1;
                }
                globalMax = Math.max(globalMax, max[row][col]);
            }
        }
        return globalMax;
    }

    private int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    @Test
    public void test_largestSquare() {
        Assert.assertEquals(2, largest(new int[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {0, 0, 1, 1}}));
        Assert.assertEquals(2, largest(new int[][]{{0, 0, 0, 0}, {0, 0, 0, 1}, {0, 1, 1, 1}, {0, 0, 1, 1}}));
        Assert.assertEquals(4, largest(new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}));
        Assert.assertEquals(0, largest(new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}));
    }
}
