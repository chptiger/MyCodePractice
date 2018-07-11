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

import org.hamcrest.CoreMatchers;
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
        while (i<A.size() && j < B.size()){
            if (A.get(i).equals(B.get(j))){
                common.add(A.get(i));
                i++;
                j++;
            }else if (A.get(i)<B.get(j)){
                i++;
            }else{
                j++;
            }
        }
        return common;
    }

    // method 2: use HashMap
    public List<Integer> common_Map(List<Integer> A, List<Integer> B){
        List<Integer> common = new ArrayList<>();
        HashMap<Integer, Integer> countA = new HashMap<>();
        for (Integer num : A){
            Integer ct = A.get(num);
            if (ct != null){
                countA.put(num, ct+1);
            }else{
                countA.put(num, 1);
            }
        }
        HashMap<Integer, Integer> countB = new HashMap<>();
        for (Integer num : B){
            System.out.println("B : "+num);
            Integer ct = B.get(num);
            if (ct != null){
                countB.put(num, ct+1);
            }else{
                countB.put(num, 1);
            }
        }
        System.out.println();
        for(Map.Entry<Integer, Integer> entry : countA.entrySet()){
            Integer ctInB = countB.get(entry.getKey());
            if (ctInB!=null){
                int appear = Math.min(entry.getValue(), ctInB);
                for (int i = 0;i<appear;i++){
                    common.add(ctInB);
                }
            }
        }
        return common;
    }

    @Test
    public void testCommon(){
        List<Integer> a = Arrays.asList(1,2,3,1,4);
        List<Integer> b = Arrays.asList(2,3,1,1,0);
        //System.out.println(common(a,b));
        System.out.println(common_Map(a,b));
//        Assert.assertEquals(Arrays.asList(1,1,2,3), common(a,b));
//        Assert.assertEquals(Arrays.asList(1,1,2,3), common_Map(a,b));
    }
}
