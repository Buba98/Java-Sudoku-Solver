package com.buba.sudokuSolver.controller.rules;

import com.buba.sudokuSolver.model.Sudoku;

public class OrthogonallyConsecutiveDigitSudokuRule extends SudokuRule {

    @Override
    public boolean isDigitPlaceable(byte x, byte y, byte digit) {
        return checkConsecutive((byte) (x + 1), y, digit) &&
                checkConsecutive(x, (byte) (y + 1), digit) &&
                checkConsecutive(x, (byte) (y - 1), digit) &&
                checkConsecutive((byte) (x - 1), y, digit);
    }

    public boolean checkConsecutive(byte x, byte y, byte digit) {
        if (sudoku.checkSizeBoundary(x, y))
            return (digit + 1 != sudoku.getNumber(x, y) && digit - 1 != sudoku.getNumber(x, y)) || sudoku.getNumber(x, y) == 0;

        return true;
    }
}
