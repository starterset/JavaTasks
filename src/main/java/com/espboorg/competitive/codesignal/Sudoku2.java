/*
    Sudoku is a number-placement puzzle.
    The objective is to fill a 9 × 9 grid with numbers in such a way that
    each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid
    all contain all the numbers from 1 to 9 one time.

    Implement an algorithm that will check whether the given grid of numbers
    represents a valid Sudoku puzzle according to the layout rules described above.
    Note that the puzzle represented by grid does not have to be solvable.
*/
package com.espboorg.competitive.codesignal;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Sudoku2 {
    public static void main(String[] args) {
        Sudoku2 sudoku = new Sudoku2();

        long time = System.currentTimeMillis();
        char[][] grid = {
                {'.', '.', '.', '1', '4', '.', '.', '2', '.'},
                {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
                {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
                {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
                {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '7', '.'}
        };
        System.out.println("solution(): " + sudoku.solution(grid));
        System.out.println("solution() took: " + (System.currentTimeMillis() - time) + " ms");
    }

    boolean solution(char[][] grid) {
        Objects.requireNonNull(grid);
        for (char[] row : grid) {
            Set<Integer> horizontal = new HashSet<>(grid.length);
            for (char cell : row) {
                if (cell != '.' && !horizontal.add((int) cell)) return false;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            Set<Integer> vertical = new HashSet<>(grid.length);
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[j][i] != '.' && !vertical.add((int) grid[j][i])) return false;
            }
        }
        for (int i = 0; i < grid.length; i += 3) {
            for (int j = 0; j < grid[i].length; j += 3) {
                Set<Integer> subGrid = new HashSet<>(grid.length);
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (grid[k][l] != '.' && !subGrid.add((int) grid[k][l])) return false;
                    }
                }
            }
        }
        return true;
    }
}
