package com.myCodePractice.Class13;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Description
Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.

Assumptions

The given word is not null and is not empty
The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty
Examples

Dictionary: {“bob”, “cat”, “rob”}

Word: “robob” return false

Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
*/
public class DictionaryWord {
    public boolean canBreak(String input, String[] dict) {
        // Write your solution here
        // assumption: input not null and dict is not empty
        Set<String> dictionary = toSet(dict);
        boolean[] canBreak = new boolean[input.length() + 1];
        canBreak[0] = true;
        if (dictionary.contains(input)) return true;
        for (int i = 1; i <= input.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (canBreak[j] // 左大段
                        && dictionary.contains(input.substring(j,i))){ // 右小段
                    canBreak[i]  =true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(canBreak));
        return canBreak[input.length()];
    }

    private Set<String> toSet(String[] words) {
        Set<String> dict = new HashSet<>();
        for (String word : words) {
            dict.add(word);
        }
        return dict;
    }

    @Test
    public void test_dictWord() {
        String[] dict = {"bob", "cat", "rob"};
        Assert.assertEquals(false, canBreak("robob", dict));
        Assert.assertEquals(true, canBreak("robcatbob", dict));
    }
}
