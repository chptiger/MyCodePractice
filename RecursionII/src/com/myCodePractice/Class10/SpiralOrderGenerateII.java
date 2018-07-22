package com.myCodePractice.Class10;

import org.junit.Assert;
import org.junit.Test;

/*Generate an M  N 2D array in spiral order clock-wise starting from the top left corner, using the numbers of 1, 2, 3, °≠, M  N in increasing order.

        Assumptions

        M >= 0, N >= 0
        Examples

        M = 3, N = 4, the generated matrix is

        { {1,  2,  3,  4}

        {10, 11, 12, 5},

        {9,  8,  7,  6} }

        Medium
        2 D Array
        Recursion*/
public class SpiralOrderGenerateII {
    public int[][] spiralGenerate(int m, int n) {
        // assumption m,n> 0
        int[][] matrix = new int[m][n];
        if (m == 0 || n == 0) {
            return matrix;
        }
        int num = 1, top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (left < right && top < bottom) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            for (int i = right - 1; i >= left; i--){
                matrix[bottom][i] = num++;
            }
            for (int i = bottom-1; i > top; i--){
                matrix[i][left] = num++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }

        if (left > right || top > bottom){
            return matrix;
        }
        if (left == right){
            for (int i = top; i <= bottom; i++){
                matrix[i][left] = num++;
            }
        }else{
            for (int i = left; i <= right; i ++){
                matrix[top][i] = num++;
            }
        }
        return matrix;
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

    @Test
    public void test_spiralGenerate() {
        Assert.assertEquals("1 2 3 ->8 9 4 ->7 6 5 ->", printMatrix(spiralGenerate(3, 3)));
        Assert.assertEquals("1 2 3 ->10 11 4 ->9 12 5 ->8 7 6 ->", printMatrix(spiralGenerate(4, 3)));
        Assert.assertEquals("1 2 3 4 ->10 11 12 5 ->9 8 7 6 ->", printMatrix(spiralGenerate(3, 4)));
    }
}
