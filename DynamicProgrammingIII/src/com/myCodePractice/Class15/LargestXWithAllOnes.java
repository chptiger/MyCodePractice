package com.myCodePractice.Class15;

import org.junit.Assert;
import org.junit.Test;

/*
Description
Given a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s,
with the same arm lengths and the four arms joining at the central point.

Return the arm length of the largest X shape.

Assumptions

The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1} }

the largest X of 1s has arm length 2.
*/
public class LargestXWithAllOnes {
    public int largest(int[][] matrix) {
        // Write your solution here
        // assumption: input matrix is not null, has size n * m
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return 0;
        }
        int[][] leftUp = leftUp(matrix, n, m);
        int[][] rightDown = rightDown(matrix, n, m);
        return merge(leftUp, rightDown, n, m);
    }

    private int merge(int[][] leftUp, int[][] rightDown, int n, int m) {
        int globalMax = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                leftUp[row][col] = Math.min(leftUp[row][col], rightDown[row][col]);
                globalMax = Math.max(globalMax, leftUp[row][col]);
            }
        }
        return globalMax;
    }

    private int[][] leftUp(int[][] matrix, int n, int m) {
        int[][] left = new int[n][m];
        int[][] up = new int[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                left[row][col] = getNumber(left, row - 1, col - 1, n, m) + 1;
                up[row][col] = getNumber(up, row - 1, col + 1, n, m) + 1;
            }
        }
        merge(left, up, n, m);
        return left;
    }

    private int[][] rightDown(int[][] matrix, int n, int m) {
        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        for (int row = n - 1; row >= 0; row--) {
            for (int col = m - 1; col >= 0; col--) {
                right[row][col] = getNumber(right, row + 1, col + 1, n, m) + 1;
                down[row][col] = getNumber(down, row + 1, col - 1, n, m) + 1;
            }
        }
        merge(right, down, n, m);
        return right;
    }

    private int getNumber(int[][] matrix, int row, int col, int n, int m) {
        if (row < 0 || row >= n || col < 0 || col >= m) {
            return 0;
        } else {
            return matrix[row][col];
        }
    }

    @Test
    public void testLargestXwith1s() {
        Assert.assertEquals(2, largest(new int[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
    }
}
