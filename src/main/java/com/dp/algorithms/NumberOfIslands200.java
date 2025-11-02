package com.dp.algorithms;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands200 {

    public static final char ONE = '1';
    public static final char ZERO = '0';

    public int numIslands(char[][] grid) {
        Set<Integer> checked = new HashSet<>();
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ONE && !isContains(checked, i, j)) {
                    count++;
                    saveIsland(checked, grid, i, j);
                }
            }
        }
        return count;
    }

    private static boolean isContains(Set<Integer> checked, int i, int j) {
        return checked.contains(getHash(i, j));
    }

    private static int getHash(int i, int j) {
        int sum = i + j;
        return (sum * (sum + 1)) / 2 + j;
    }

    private void saveIsland(Set<Integer> checked,
                            char[][] grid,
                            int i,
                            int j) {
        addToChecked(checked, i, j);

        up(checked, grid, i, j);
        right(checked, grid, i, j);
        down(checked, grid, i, j);
        left(checked, grid, i, j);
    }

    private static boolean addToChecked(Set<Integer> checked, int i, int j) {
        return checked.add(getHash(i, j));
    }

    private void up(Set<Integer> checked, char[][] grid, int i, int j) {
        i -= 1;

        if (i < 0 || grid[i][j] == ZERO || isContains(checked, i, j)) return;
        addToChecked(checked, i, j);

        up(checked, grid, i, j);
        left(checked, grid, i, j);
        right(checked, grid, i, j);
    }

    private void left(Set<Integer> checked, char[][] grid, int i, int j) {
        j -= 1;

        if (j < 0 || grid[i][j] == ZERO || isContains(checked, i, j)) return;
        addToChecked(checked, i, j);

        left(checked, grid, i, j);
        up(checked, grid, i, j);
        down(checked, grid, i, j);
    }

    private void down(Set<Integer> checked, char[][] grid, int i, int j) {
        i += 1;

        if (i >= grid.length || grid[i][j] == ZERO || isContains(checked, i, j)) return;
        addToChecked(checked, i, j);

        down(checked, grid, i, j);
        left(checked, grid, i, j);
        right(checked, grid, i, j);
    }

    private void right(Set<Integer> checked, char[][] grid, int i, int j) {
        j += 1;

        if (j >= grid[i].length || grid[i][j] == ZERO || isContains(checked, i, j)) return;
        addToChecked(checked, i, j);

        right(checked, grid, i, j);
        up(checked, grid, i, j);
        down(checked, grid, i, j);
    }
}
