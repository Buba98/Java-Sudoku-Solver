package com.buba.sudokuSolver.controller.rules;

public class DiagonalsSudokuRule extends SudokuRule{
    @Override
    public boolean isDigitPlaceable(byte x, byte y, byte digit) {
        if(x == y){
            for (byte i = 0; i < Math.min(sudoku.getXSize(), sudoku.getYSize()); i++){
                if (i != x && sudoku.getNumber(i, i) == digit)
                    return false;
            }
        }

        byte yLength = (byte) (sudoku.getYSize() - 1);

        if (x + y == yLength){
            for (byte i = 0; i < Math.min(sudoku.getXSize(), sudoku.getYSize()); i++){
                if (i != x && sudoku.getNumber(i, (byte) (yLength - i)) == digit)
                    return false;
            }
        }

        return true;
    }
}
