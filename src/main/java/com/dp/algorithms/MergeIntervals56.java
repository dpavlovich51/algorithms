package com.dp.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals56 {

    public static final Comparator<int[]> comp = (o1, o2) -> {
        if (o1[0] > o2[1]) return 1;
        if (o1[1] < o2[0]) return -1;
        return 0;
    };

    public static void main(String[] args) {
        System.out.println(Arrays.stream(merge(List.of(
                        new int[]{2, 3},
                        new int[]{4, 5},
                        new int[]{6, 7},
                        new int[]{8, 9},
                        new int[]{1, 10}
                ).toArray(new int[][]{})))
                .map(e1 -> Arrays.stream(e1).boxed().toList())
                .toList());
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1, r = 0; i < intervals.length; i++) {
            int[] last = result.getLast();

            if (intervals[i][0] <= last[1]) last[1] = Math.max(intervals[i][1], last[1]);
            else result.add(intervals[i]);
        }
        return result.toArray(new int[][]{});
    }

    public static int[][] merge1(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int right = result.size() - 1;
            int left = 0;

            // find overlapping element using binary search
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int compareRes = comp.compare(intervals[i], result.get(left));

                if (compareRes > 0) left = mid + 1;
                else if (compareRes < 0) right = mid - 1;
                else {
                    int[] el = result.get(mid);

                    el[0] = Math.min(el[0], intervals[i][0]);
                    el[1] = Math.max(el[1], intervals[i][1]);

                    right = mid;
                    left = mid;
                    while (left - 1 >= 0 || right + 1 < result.size()) {
                        if (left - 1 >= 0 && merge(result, left, --left)) right--;
                        if (right + 1 < result.size() && merge(result, right, ++right)) right--;
                    }
                    break;
                }
                mid = left;
                while (mid < result.size()) {
                    if (mid < result.size() - 1 && comp.compare(result.get(mid), result.get(mid + 1)) < 1) {
                        mid++;
                        continue;
                    }
                    mid++;
                }
                // we have no overlapping elements
                result.add(mid, intervals[i]);
                break;
            }
        }
        return result.toArray(new int[][]{});
    }

    private static boolean merge(List<int[]> result, int currIndex, int mergeIndex) {
        int[] el = result.get(currIndex);
        int[] mergeEl = result.get(mergeIndex);

        if (comp.compare(el, mergeEl) == 0) {
            result.remove(mergeIndex);

            el[0] = Math.min(el[0], mergeEl[0]);
            el[1] = Math.max(el[1], mergeEl[1]);
            return true;
        }
        return false;
    }
}
