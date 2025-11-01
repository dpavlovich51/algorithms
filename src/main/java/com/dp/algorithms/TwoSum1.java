package com.dp.algorithms;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        numToIndex.put(target - nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            if (numToIndex.containsKey(nums[i])) {
                return new int[]{numToIndex.get(nums[i]), i};
            }
            numToIndex.put(target - nums[i], i);
        }
        return new int[]{};
    }
}
