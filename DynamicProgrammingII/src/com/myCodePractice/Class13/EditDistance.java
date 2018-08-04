package com.myCodePractice.Class13;

import org.junit.Assert;
import org.junit.Test;

/*
Description
Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.

Assumptions

Both strings are not null
Examples

string one: “sigh”, string two : “asith”

the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).
*/
public class EditDistance {
    public int editDistance(String one, String two) {
        // Write your solution here
        // assumption: one and two are not null
        int[][] distance = new int[one.length() + 1][two.length() + 1];
        for (int row = 0; row <= one.length(); row++) {
            for (int col = 0; col <= two.length(); col++) {
                if (row == 0) {
                    distance[row][col] = col;
                } else if (col == 0) {
                    distance[row][col] = row;
                } else if (one.charAt(row - 1) == two.charAt(col - 1)) {
                    distance[row][col] = distance[row - 1][col - 1];
                } else {
                    distance[row][col] = getMin(distance[row - 1][col - 1], distance[row][col - 1], distance[row - 1][col]) + 1;
                }
            }
        }
        return distance[one.length()][two.length()];
    }

    private int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    @Test
    public void test_distance() {
        Assert.assertEquals(4, editDistance("asdf", "sghj"));
        Assert.assertEquals(5, editDistance("", "asith"));
        Assert.assertEquals(2, editDistance("sigh", "asith"));
    }
}
