//Description
//        Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.
//
//        Assumptions
//
//        the composition is not null and is not guaranteed to be sorted
//        K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words
//        Return
//
//        a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)
//        Examples
//
//        Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
//        Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
//        Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]

package com.myCodePractice.Class07.HashTableAndStringI;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here
        // Corner case
        if (combo == null || combo.length == 0){
            return new String[0];
        }
        // Iterate every char in combo, put it in HashMap<String, int>
        HashMap<String, Integer> freqMap = new HashMap<>();
        for(String word : combo){
            Integer count = freqMap.get(word);
            if (count == null){
                freqMap.put(word, 1);
            }else{
                freqMap.put(word, count+1);
            }
        }
        // Find k-th freq word by minHeap
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> kvPair: freqMap.entrySet()){
            if (minHeap.size()<k){
                minHeap.offer(kvPair);
            }else if (kvPair.getValue()>minHeap.peek().getValue()){
                    minHeap.poll();
                    minHeap.offer(kvPair);
            }
        }

        // print out String[] from minHeap
        String[] result = new String[k];
        for (int i = k-1; i>=0;i--){
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }

    @Test
    public void testKthFreqWord(){
        String[] combo = {"A","B","A","C","D","B","A"};
        Assert.assertArrayEquals(new String[]{"A","B"}, topKFrequent(combo, 2));
    }
}
