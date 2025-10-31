package com.dp.algorithms;

public class GuessNumberHigherOrLower374 {

    public static void main(String[] args) {
        System.out.println(guessNumber(20));
    }

    public static int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);

            if (res == 0) return mid;
            else if (res < 0) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    private static int guess(int num) {
        return 11 - num;
    }
}
