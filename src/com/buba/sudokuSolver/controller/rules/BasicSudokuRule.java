package com.buba.sudokuSolver.controller.rules;

import com.buba.sudokuSolver.model.Sudoku;

public class BasicSudokuRule extends SudokuRule {

    private Sudoku sudoku;

    public boolean isDigitPlaceable(byte x, byte y, byte digit) {
        if (!sudoku.checkBoundary(x, y, digit))
            return false;

        for (byte[] digits : sudoku.getBox(x, y))
            for (byte digitToCheck : digits)
                if (digitToCheck == digit)
                    return false;

        for (byte digitToCheck : sudoku.getColumn(y))
            if (digitToCheck == digit)
                return false;

        for (byte digitToCheck : sudoku.getRow(x))
            if (digitToCheck == digit)
                return false;

        return true;
    }

    @Override
    protected void setSudoku(Sudoku sudoku) {
        this.sudoku = sudoku;
    }
}