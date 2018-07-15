// Given a string in compressed form, decompress it to the original string.
// The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.
//
//        Assumptions
//
//        The string is not null
//
//        The characters used in the original string are guaranteed to be °Æa°Ø - °Æz°Ø
//
//        There are no adjacent repeated characters with length > 9
//
//        Examples
//
//        "a1c0b2c4""abbcccc"
package com.myCodePractice.Class08;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DecompressStringII {
    // method 1, use StringBuilder
    public String decompress(String input) {
        // Write your solution here
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i++];
            int count = array[i] - '0';
            for (int c = 0; c < count; c++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    // method 2, in place
    // when we say in place, it usually means the input is a long enough char array
    // and the original string only occupies part of the array starting from index 0
    // and usually the length to represent the original string is given
    public String decompress2(String input) {
        if (input.isEmpty()) {
            return input;
        }
        char[] array = input.toCharArray();
        // we need to handle the a0, a1, a2 case (the decoded string is shorter)
        // and a3, a4 ... case (the decoded string is longer)
        // in 2 pass to avoid conflict, since the encoding of the 2 cases require different directions
        return decodeLong(array, decodeShort(array));
    }

    // return the length of he decoded string,
    // only cares about a0, a1, a2,
    // the decoded string is shorter
    private int decodeShort(char[] input) {
        // since the decoded string is shorter, we should do the decoding work from left to right
        int end = 0;
        for (int i = 0; i < input.length; i += 2) {
            int digit = getDigit(input[i + 1]);
            if (digit >= 0 && digit <= 2) {
                for (int j = 0; j < digit; j++) {
                    input[end++] = input[i]; // orig array a1-> a, a2-> aa
                }
            } else {
                // we don't handle the longer decoded string here
                input[end++] = input[i]; // a3-> a3
                input[end++] = input[i + 1]; // a3-> a3
            }
        }
        return end; // end -> input.length
    }

    private int getDigit(char digit) {
        return digit - '0';
    }

    // take care of a3, a4, a5...
    // the decoded string is longer
    // length: the length of the valid partition starting from index 0
    private String decodeLong(char[] input, int length) {
        // we need to calculate the new required length
        int newLength = length;
        for (int i = 0; i < length; i++) {
            int digit = getDigit((input[i]));
            if (digit > 2 && digit <= 9) {
                newLength += digit - 2;
            }
        }
        // Notice: if it is required to do this in place,
        // usually the input array is a sufficient large one
        // you will not need to allocate a new array
        char[] result = new char[newLength];
        int end = newLength - 1;
        for (int i = length - 1; i >= 0; i--) { // calculate from old end to 0
            int digit = getDigit(input[i]);
            if (digit > 2 && digit <= 9) {
                i--;
                for (int j = 0; j < digit; j++) {
                    result[end--] = input[i];
                }
            } else {
                // we already take care the shorter cases, a1 in previous pass
                // we can leave as it is e.g. the input could be abc2
                result[end--] = input[i];
            }
        }
        return new String(result);
    }

    @Test
    public void test_decompressString() {
        //Assert.assertEquals("abbcccc", decompress("a1c0b2c4"));
        //Assert.assertEquals("abbcccc", decompress2("a1c0b2c4"));
        Assert.assertEquals("aaabbcccc", decompress2("a3b2c4"));
    }
}
