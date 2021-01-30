package com.buba.sudokuSolver.controller.rules;
import com.buba.sudokuSolver.model.Sudoku;

public abstract class SudokuRule {

    protected Sudoku sudoku;

    public abstract boolean isDigitPlaceable(byte x, byte y, byte digit);

    protected void setSudoku(Sudoku sudoku){
        this.sudoku = sudoku;
    }
}