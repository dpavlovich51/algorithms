package com.dp.algorithms;

public class SingleNumber136 {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 3, 4, 5, 1}));
    }

    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
