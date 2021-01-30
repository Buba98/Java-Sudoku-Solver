package com.buba.sudokuSolver.controller.rules;
import com.buba.sudokuSolver.model.Sudoku;

public abstract class SudokuRule {

    Sudoku sudoku;

    public abstract boolean isDigitPlaceable(byte x, byte y, byte digit);

    protected abstract void setSudoku(Sudoku sudoku);
}