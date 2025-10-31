package com.dp.algorithms;

import java.util.HashSet;
import java.util.Set;

public class BinarySearch704 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{5}, -5));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }
}
