package com.mycodepractice.Class03;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/*
The numbers are in s1 originally, after sorting, the numbers should be in s1 as well
and from top to bottom the numbers are sorted in ascending order
 */
public class SortNumbersInThreeStacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        LinkedList<Integer> s3 = new LinkedList<>();
        sort(s1, s2, s3, s1.size());
    }

    private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int size) {
        if (size <= 1) {
            return;
        }
        int mid1 = size / 2;
        int mid2 = size - mid1;
        // move first half of s1 to s2
        for (int index = 0; index < mid1; index++) {
            s2.offerFirst(s1.pollFirst());
        }
        // sort first half of s1 and s2, use s3 as buffer
        sort(s1, s3, s2, mid1);
        sort(s2, s3, s1, mid2);
        int i=0,j=0;
        while (i < mid1 && j<mid2){
            if (s2.peekFirst()< s1.peekFirst()){
                s3.offerFirst(s2.pollFirst());
                i++;
            }else{
                s3.offerFirst(s1.pollFirst());
                j++;
            }
        }
        while (i < mid1){
            s3.offerFirst(s2.pollFirst());
            i++;
        }
        while (j < mid2){
            s3.offerFirst(s1.pollFirst());
            j++;
        }
        // order by ascending
        for (int index = 0; index < size; index++){
            s1.offerFirst(s3.pollFirst());
        }
    }

    @Test
    public void test_sortIn3Stacks() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(6);
        sort(list);
        Assert.assertEquals((Integer) 1, list.pollFirst());
        Assert.assertEquals((Integer) 2, list.pollFirst());
        Assert.assertEquals((Integer) 3, list.pollFirst());
        Assert.assertEquals((Integer) 6, list.pollFirst());
        Assert.assertNull(list.pollFirst());
    }
}
