package com.myCodePractice.Class12;

import org.junit.Assert;
import org.junit.Test;

/*
Description
Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
A[i] means the maximum jump distance from that position (you can only jump towards the end of the array).
Determine if you are able to reach the last index.

Assumptions

The given array is not null and has length of at least 1.
Examples

{1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)

{2, 1, 1, 0, 2}, we are not able to reach the end of array
*/
public class ArrayHopperI {
  public boolean canJump(int[] array) {
    // Write your solution here
    return true;
  }

  @Test
  public void testArrayHopper(){
    Assert.assertEquals(true, canJump(new int[]{1,3,2,0,3}));
    Assert.assertEquals(false, canJump(new int[]{2,1,1,0,3}));
    Assert.assertEquals(false, canJump(new int[]{0}));
  }
}
