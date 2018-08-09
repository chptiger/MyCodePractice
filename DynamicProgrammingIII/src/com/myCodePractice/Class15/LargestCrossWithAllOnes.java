package com.myCodePractice.Class15;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Description
Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths and the four arms joining at the central point.

Return the arm length of the largest cross.

Assumptions

The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1} }

the largest cross of 1s has arm length 2.
*/
public class LargestCrossWithAllOnes {
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

    // leftUp records the longest possible length for left and up arms ending at each cells in the matrix
    private int[][] leftUp(int[][] matrix, int n, int m) {
        int[][] left = new int[n][m];
        int[][] up = new int[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (matrix[row][col] == 1) {
                    if (row == 0 && col == 0) {
                        up[row][col] = 1;
                        left[row][col] = 1;
                    } else if (row == 0) {
                        up[row][col] = 1;
                        left[row][col] = left[row][col - 1] + 1;
                    } else if (col == 0) {
                        up[row][col] = up[row - 1][col] + 1;
                        left[row][col] = 1;
                    } else {
                        up[row][col] = up[row - 1][col] + 1;
                        left[row][col] = left[row][col - 1] + 1;
                    }
                }
            }
        }
        merge(left, up, n, m);
        return left;
    }

    // rightDown records the longest possible length for right and down arms ending at each cells in the matrix
    private int[][] rightDown(int[][] matrix, int n, int m) {
        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        for (int row = n - 1; row >= 0; row--) {
            for (int col = m - 1; col >= 0; col--) {
                if (matrix[row][col] == 1) {
                    if (row == n - 1 && col == m - 1) {
                        right[row][col] = 1;
                        down[row][col] = 1;
                    } else if (row == n - 1) {
                        right[row][col] = right[row][col + 1] + 1;
                        down[row][col] = 1;
                    } else if (col == m - 1) {
                        right[row][col] = 1;
                        down[row][col] = down[row + 1][col] + 1;
                    } else {
                        right[row][col] = right[row][col + 1] + 1;
                        down[row][col] = down[row + 1][col] + 1;
                    }
                }
            }
        }
        merge(right, down, n, m);
        return right;
    }

    // merge leftup and rightdown matrix into leftup, the value of each cell is the min value of the corresponding cells
    // in the 2 matrixes, also it returns the max value among all the cells in the merged matrix
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

    @Test
    public void test_largestCrossAll1s() {
        Assert.assertEquals(2, largest(new int[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
        Assert.assertEquals(2, largest(new int[][]{{0, 0, 1, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
    }
}
