package myCodePractice.Class16.Probability;

import org.junit.Test;

import java.util.Arrays;

/*Description
        Given an array of integers (without any duplicates), shuffle the array such that all permutations are equally likely to be generated.

        Assumptions

        The given array is not null*/
public class Shuffle {
    public void shuffle(int[] array) {
        // Write your solution here.
        // assumption: array is not null
        if (array.length <= 1) {
            return;
        }
        // from right to left, for index i-1, randomly pick one of the first i elements
        for (int i = array.length; i >= 1; i--) {
            int index = (int) (Math.random() * i);
            swap(array, i - 1, index);
        }
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    @Test
    public void test_shuffle() {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffle(array);
        System.out.println(Arrays.toString(array));
    }

}
