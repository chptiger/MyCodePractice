package com.myCodePractice.Class10;

import org.junit.Assert;
import org.junit.Test;

/*Word °∞book°± can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation,
return if the string matches the abbreviation.
        Assumptions:
        The original string only contains alphabetic characters.
        Both input and pattern are not null.
        Examples:
        pattern °∞s11d°± matches input °∞sophisticated°± since °∞11°± matches eleven chars °∞ophisticate°±.
        Medium
        Recursion
        String*/
public class AbbreviationMatching {
    // method 1, recursively
    public boolean match(String input, String pattern) {
        // Write your solution here
        return match(input, pattern, 0, 0);
    }

    private boolean match(String input, String pattern, int si, int ti) {
        // only when we run out of s and t at the same time, there is a match
        if (si == input.length() && ti == pattern.length()) {
            return true;
        }
        // if we run out of one of s an t but there is still some char left for the other one,
        // we can not find the match
        if (si > input.length() || ti > pattern.length()) {
            return false;
        }
        // case 1, if the current char in t is not a digit
        if (pattern.charAt(ti) < '0' || pattern.charAt(ti) > '9') {
            if (input.charAt(si) == pattern.charAt(ti)) {
                return match(input, pattern, si + 1, ti + 1);
            }
            return false;
        }
        // case 2, if the current char in t is a digit
        // we need to find in total what is the number. e.g. "123" means number 123
        int count = 0;
        while (ti < pattern.length() && pattern.charAt(ti) >= '0' && pattern.charAt(ti) <= '9') {
            count = count * 10 + (pattern.charAt(ti) - '0');
            ti++;
        }
        return match(input, pattern, si + count, ti);
    }

    // method 2, iteratively
    public boolean match2(String input, String pattern) {
        // Write your solution here
        int si = 0;
        int ti = 0;
        while (si < input.length() && ti < pattern.length()) {
            // ti is not a digit
            if (pattern.charAt(ti) < '0' || pattern.charAt(ti) > '9') {
                if (input.charAt(si) != pattern.charAt(ti)) {
                    return false;
                }
                si++;
                ti++;
            } else {
                int count = 0;
                while (ti < pattern.length() && pattern.charAt(ti) >= '0' && pattern.charAt(ti) <= '9') {
                    count = count * 10 + (pattern.charAt(ti) - '0');
                    ti++;
                }
                si += count;
            }
        }
        return si == input.length() && ti == pattern.length();
    }

    @Test
    public void test_AbbreviationMatching() {
        Assert.assertEquals(true, match("student", "s5t"));
        Assert.assertEquals(true, match2("student", "s5t"));
        Assert.assertEquals(true, match("student", "s6"));
        Assert.assertEquals(true, match2("student", "s6"));

        //Assert.assertEquals(false, match("student","s1"));
        //Assert.assertEquals(false, match2("student","s1"));
    }
}
