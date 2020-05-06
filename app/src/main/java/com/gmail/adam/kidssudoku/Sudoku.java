package com.gmail.adam.kidssudoku;

import java.util.Arrays;
import java.util.Random;

class Sudoku {

    int[][] result = new int[3][3];
    int[][] table = new int[3][3];

    void setSudoku(int[][] sudoku) {
        this.table = sudoku;
        result = Arrays.copyOf(table, table.length);
    }

    boolean check(int row, int col, int value, int[][] sudoku) {


        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[row][i] == value && i != col || sudoku[i][col] == value && i != row) {

                return false;
            }
        }
        return true;
    }

    boolean next(int row, int col, int size) {
        if (row == size && col == size) return true;
        else if (row == size) return solve(0, col + 1, table);
        else return solve(row + 1, col, table);
    }

    boolean solve(int row, int col, int[][] sukoku) {


        if (sukoku[row][col] == 0) {
            for (int i = 1; i <= sukoku.length; i++) {
                if (check(row, col, i, sukoku)) {
                    result[row][col] = i;
                    if (next(row, col, sukoku.length - 1)) {
                        return true;
                    }
                }
            }
            result[row][col] = 0;
            return false;
        }
        return next(row, col, sukoku.length - 1);
    }

    int[][] generate(int size) {

        result = new int[size][size];

        Random r = new Random();
        result[0][0] = r.ints(1, (size + 1)).findFirst().getAsInt();
        for (int i = 0; i < size; i++) {
            while (result[i][0] == 0) {
                result[i][0] = r.ints(1, (size + 1)).findFirst().getAsInt();
                if (!check(i, 0, result[i][0], result)) {
                    result[i][0] = 0;
                }
            }
            while (result[0][i] == 0) {
                result[0][i] = r.ints(1, (size + 1)).findFirst().getAsInt();
                if (!check(0, i, result[0][i], result)) {
                    result[0][i] = 0;
                }
            }
        }

        setSudoku(result);

        solve(0, 0, table);

        for (int i = 0; i < size; i++) {
            result[r.ints(0, size).findFirst().getAsInt()]
                    [r.ints(0, size).findFirst().getAsInt()] = 0;
        }


        return result;
    }
}
