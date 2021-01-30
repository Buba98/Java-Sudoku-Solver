package com.buba.sudokuSolver.controller.rules;

import com.buba.sudokuSolver.model.Sudoku;

public class KingSudokuRule extends SudokuRule {

    @Override
    public boolean isDigitPlaceable(byte x, byte y, byte digit) {
        if (!sudoku.checkBoundary(x, y, digit))
            return false;

        return checkEquality((byte) (x + 1), (byte) (y + 1), digit) &&
                checkEquality((byte) (x + 1), y, digit) &&
                checkEquality((byte) (x + 1), (byte) (y - 1), digit) &&
                checkEquality(x, (byte) (y + 1), digit) &&
                checkEquality(x, (byte) (y - 1), digit) &&
                checkEquality((byte) (x - 1), (byte) (y + 1), digit) &&
                checkEquality((byte) (x - 1), y, digit) &&
                checkEquality((byte) (x - 1), (byte) (y + 1), digit);
    }

    public boolean checkEquality(byte x, byte y, byte digit) {
        if (sudoku.checkSizeBoundary(x, y))
            return digit != sudoku.getNumber(x, y);

        return true;
    }
}
