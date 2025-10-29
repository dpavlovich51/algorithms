package com.dp.algorithms;


public class FactorialApp {
    public static void main(String[] args){
        System.out.println(factorial(4));
    }

    private static Integer factorial(int number) {
        if (number == 0) {
            return 1;
        }
        int prevValue = 1;
        int position = 1;

        return aFactorial(number, position, prevValue);
    }

    private static Integer aFactorial(int number, int position, int prevValue) {
        if (position == number) {
            return prevValue * position;
        }
        return aFactorial(number, position + 1, prevValue * position);
    }
}