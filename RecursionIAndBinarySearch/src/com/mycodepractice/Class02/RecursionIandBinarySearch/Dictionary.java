package com.mycodepractice.Class02.RecursionIandBinarySearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

interface Dictionary {
    public Integer get(int index);
}

class DictImpl implements Dictionary {
    private int[] array;

    public DictImpl(int[] array) {
        this.array = array;
    }

    @Override
    public Integer get(int index) {
        if (array == null || index >= array.length) {
            return null;
        }
        return array[index];
    }
}