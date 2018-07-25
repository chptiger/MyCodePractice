package com.myCodePractice.Class11;

import org.junit.Assert;
import org.junit.Test;

//Description
//        Generate the hexadecimal representation for a given non-negative integer number as a string.
//        The hex representation should start with "0x".
////        There should not be extra zeros on the left side.
////        Examples
////        0's hex representation is "0x0"
//        255's hex representation is "0xFF"
public class HexadecimalRepresentation {
    public String hex(int number) {
        // Write your solution here
        String prefix = "0x";
        if (number == 0){
            return prefix + "0";
        }
        StringBuilder sb = new StringBuilder();
        while (number > 0){
            int rem = number % 16;
            if (rem < 10){
                sb.append((char)('0' + rem));
            }else{
                sb.append((char)(rem-10+'A'));
            }
            number >>>= 4;
        }
        return prefix+sb.toString();
    }

    @Test
    public void test_hex(){
        Assert.assertEquals("0xFF", hex(255));
        Assert.assertEquals("0x0", hex(0));
        Assert.assertEquals("0xA", hex(10));
        Assert.assertEquals("0xB", hex(11));
    }
}
