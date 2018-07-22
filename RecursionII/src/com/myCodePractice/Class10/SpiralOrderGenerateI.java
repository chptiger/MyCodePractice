package com.myCodePractice.Class10;

import org.junit.Assert;
import org.junit.Test;

public class SpiralOrderGenerateI {
    // method 1, recursively
    public int[][] spiralGenerate(int n) {
        // Write your solution here.
        // assumption n > 0
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        recursiveGenerate(matrix, 0, n, 1);
        return matrix;
    }

    private void recursiveGenerate(int[][] matrix, int offset, int size, int num) {
        // base case: only 0 or 1 element left
        if (size == 0) {
            return;
        }
        if (size == 1) {
            matrix[offset][offset] = num;
            return;
        }
        // add top row
        for (int i = 0; i < size; i++) {
            matrix[offset][offset + i] = num++;
        }
        // add right column
        for (int i = 1; i < size; i++) {
            matrix[offset + i][offset + size - 1] = num++;
        }
        // add bottom row
        for (int i = size - 2; i >= 0; i--) {
            matrix[offset + size - 1][offset + i] = num++;
        }
        // add left column
        for (int i = size - 2; i > 0; i--) {
            matrix[offset + i][offset] = num++;
        }

        recursiveGenerate(matrix, offset + 1, size - 2, num);
    }

    private String printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                sb.append(matrix[row][column]).append(" ");
            }
            sb.append("->");
        }
        return sb.toString();
    }

    // method 2, iteratively
    public int[][] spiralGenerateII(int n) {
        // assumption n > 0
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        int start = 0, end = n - 1, num = 1;
        while (start < end) {
            // add top row
            for (int i = start; i <= end; i++) {
                matrix[start][i] = num++;
            }
            // add right column
            for (int i = start + 1; i <= end - 1; i++) {
                matrix[i][end] = num++;
            }
            // add bottom row
            for (int i = end; i >= start; i--) {
                matrix[end][i] = num++;
            }
            // add left column
            for (int i = end - 1; i >= start + 1; i--) {
                matrix[i][start] = num++;
            }
            start++;
            end--;
        }
        if (start == end){
            matrix[start][end] = num;
        }
        return matrix;
    }

    @Test
    public void test_spiralGenerate() {
        Assert.assertEquals("1 2 3 ->8 9 4 ->7 6 5 ->", printMatrix(spiralGenerate(3)));
        Assert.assertEquals("1 2 3 ->8 9 4 ->7 6 5 ->", printMatrix(spiralGenerateII(3)));
    }
}
