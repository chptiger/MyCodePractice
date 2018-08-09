package com.myCodePractice.Class15;

import org.junit.Assert;
import org.junit.Test;

/*
Give a matrix where every element is either 0 or 1, find the largest subsquare surrounded by 1
*/
public class LargestSubsquare0or1 {
    public int largest(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int result = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        // the longest left arm length ending at each position in the matrix
        // we here apply 2 new matrix to present left->right and up->down
        // the length of them are M+1 * N+1 to resuce the corner cases
        int[][] left = new int[rows + 1][cols + 1]; // matrix[i][j] -> left/up[i+1][j+1]
        int[][] up = new int[rows + 1][cols + 1];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 1) {
                    left[row + 1][col + 1] = left[row + 1][col] + 1;
                    up[row + 1][col + 1] = up[row][col + 1] + 1;
                    // the max length of a sub-1 matrix with right-bottom positionat matrix[i][j] is determined by
                    // the min value of left[i+1][j+1] and up[i+1][j+1]
                    // and we check one by one all the possible lengths if it can provide the actual matrix
                    // we only need to check the longest left arm length of the right-top cell
                    // and the longest up arm length of left-bottom cell
                    for (int maxLength = Math.min(left[row + 1][col + 1], up[row + 1][col + 1]); maxLength >= 1; maxLength--) {
                        if (left[row + 2 - maxLength][col + 1] >= maxLength && up[row + 1][col + 2 - maxLength] >= maxLength) {
                            result = Math.max(result, maxLength);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test_subsquareOf1s() {
        Assert.assertEquals(4, largest(new int[][]{{1, 1, 1, 1, 1}, {1, 1, 0, 0, 1}, {1, 1, 0, 0, 1}, {1, 1, 1, 1, 1}}));
        Assert.assertEquals(2, largest(new int[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
    }
}
