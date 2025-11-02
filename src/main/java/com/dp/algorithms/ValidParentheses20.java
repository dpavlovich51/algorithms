package com.dp.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses20 {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        if (s.length() < 2) return false;

        char ch = s.charAt(0);
        if (isClosed(ch)) return false;

        Deque<Character> cache = new ArrayDeque<>();
        cache.add(ch);
        for (int i = 1; i < s.length(); i++) {
            ch = s.charAt(i);
            if (!isClosed(ch)) {
                cache.addLast(ch);
                continue;
            }
            if (cache.isEmpty()) return false;
            Character openCh = cache.pollLast();
            if (getCloseCharacter(openCh) != ch) return false;
        }
        return cache.isEmpty();
    }

    public static boolean isClosed(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    public static char getCloseCharacter(char ch) {
        return switch (ch) {
            case '(' -> ')';
            case '[' -> ']';
            case '{' -> '}';
            default -> throw new IllegalArgumentException("char: " + ch);
        };
    }
}
