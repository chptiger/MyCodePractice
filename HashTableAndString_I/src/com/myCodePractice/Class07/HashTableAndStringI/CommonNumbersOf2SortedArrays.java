//Description
//        Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).
//
//        Assumptions
//
//        In each of the two sorted arrays, there could be duplicate numbers.
//        Both two arrays are not null.
//        Examples
//
//        A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
package com.myCodePractice.Class07.HashTableAndStringI;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CommonNumbersOf2SortedArrays {
    // Method 1: 2 pointers
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        // Write your solution here
        // Assumption: A and B are both not null
        int i = 0, j = 0;
        List<Integer> common = new ArrayList<>();
        while (i < A.size() && j < B.size()) {
            if (A.get(i).equals(B.get(j))) {
                common.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return common;
    }

    // method 2: use HashMap
    public List<Integer> common_Map(List<Integer> A, List<Integer> B) {
        List<Integer> common = new ArrayList<>();
        HashMap<Integer, Integer> countA = addMap(A);
        HashMap<Integer, Integer> countB = addMap(B);
        for (Map.Entry<Integer, Integer> entry : countA.entrySet()) {
            Integer ctInB = countB.get(entry.getKey());
            if (ctInB != null) {
                int appear = Math.min(entry.getValue(), ctInB);
                for (int i = 0; i < appear; i++) {
                    common.add(entry.getKey());
                }
            }
        }
        return common;
    }

    private HashMap<Integer, Integer> addMap(List<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : list) {
            Integer ct = map.get(num);
            if (ct == null) map.put(num, 1);
            else map.put(num, ct + 1);
        }
        return map;
    }

    @Test
    public void testCommon() {
        List<Integer> a = Arrays.asList(1, 1, 2, 2, 3);
        List<Integer> b = Arrays.asList(1, 1, 2, 5, 6);
        Assert.assertEquals(Arrays.asList(1, 1, 2), common(a, b));
        Assert.assertEquals(Arrays.asList(1, 1, 2), common_Map(a, b));
    }
}
