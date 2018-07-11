//Description
//        Given an integer array of size N - 1, containing all the numbers from 1 to N except one,
//        find the missing number.
//
//        Assumptions
//
//        The given array is not null, and N >= 1
//        Examples
//
//        A = {2, 1, 4}, the missing number is 3
//        A = {1, 2, 3}, the missing number is 4
//        A = {}, the missing number is 1
package com.myCodePractice.Class07.HashTableAndStringI;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class MissingNumberI {
    // Method 1 Set
    public int missing_bySet(int[] array) {
        // Write your solution here
        // Corner case
        if (array == null){
            return -1;
        }
        if (array.length == 0){
            return 0;
        }

        int n = array.length + 1;
        HashSet<Integer> set = new HashSet<>();
        for(int num : array){
            set.add(num);
        }
        for (int i = 1;i<n;i++){
            if (!set.contains(i)){
                return i;
            }
        }
        return n;
    }
    // Method 2: use sum
    public int missing_bySum(int[] array){
        if (array == null){
            return -1;
        }
        if (array.length == 0){
            return 0;
        }
        int n = array.length+1;
        long targetSum = n*(n+1)/2;
        long actualSum = 0;
        for (int num: array){
            actualSum += num;
        }
        return (int)(targetSum - actualSum);
    }

    // method 3: bit opeartion
    public int missing_byBit(int[] array){
        if (array == null){
            return -1;
        }
        if (array.length == 0){
            return 0;
        }
        int n = array.length +1;
        int xor = 0;
        for (int i = 1;i<=n;i++){
            xor ^= i;
        }
        for (int num:array){
            xor ^= num;
        }
        return xor;
    }

    // method 4: swap the num to its corresponding position
    public int missing_bySwap(int[] array){
        if (array == null){
            return -1;
        }
        if (array.length == 0){
            return 0;
        }
        for (int i = 0; i<array.length;i++){
            while (array[i] != i+1 && array[i] != array.length +1){
                swap(array, i , array[i] -1);
            }
        }

        for (int i = 0;i < array.length;i++){
            if (array[i] != i+1){
                return i+1;
            }
        }
        return array.length +1;
    }
    private void swap(int[] array, int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Test
    public void testMissing(){
        int[] array = {1,2,4,5};
        Assert.assertEquals(3, missing_bySet(array));
        Assert.assertEquals(3, missing_bySum(array));
        Assert.assertEquals(3, missing_byBit(array));
        Assert.assertEquals(3, missing_bySwap(array));
        int[] array2 = {1,2,3,4,5};
        Assert.assertEquals(6, missing_bySet(array2));
        Assert.assertEquals(6, missing_bySum(array2));
        Assert.assertEquals(6, missing_byBit(array2));
        Assert.assertEquals(6, missing_bySwap(array2));
    }
}
