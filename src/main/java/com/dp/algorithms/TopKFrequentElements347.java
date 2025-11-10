package com.dp.algorithms;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements347 {

    public static void main(String[] args) {
        topKFrequent(new int[]{3, 2, 1, 2, 3, 3, 3}, 3);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> result = new PriorityQueue<>(k + 1, Comparator.comparing(freq::get)) {
            @Override
            public boolean add(Integer integer) {
                if (size() == k) poll();
                return super.add(integer);
            }
        };
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = result.poll();
        }
        return res;
    }

}
