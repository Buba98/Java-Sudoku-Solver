package com.buba.sudokuSolver.controller.rules;

import com.buba.sudokuSolver.model.Sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRuleAggregator extends SudokuRule{

    public final List<SudokuRule> sudokuRuleList;

    public SudokuRuleAggregator(List<SudokuRule> sudokuRuleList, Sudoku sudoku){
        this.sudokuRuleList = sudokuRuleList;
        this.sudoku = sudoku;

        for (SudokuRule sudokuRule : sudokuRuleList)
            sudokuRule.setSudoku(sudoku);
    }

    @Override
    public boolean isDigitPlaceable(byte x, byte y, byte digit) {
        boolean toReturn = true;
        for (SudokuRule sudokuRule : sudokuRuleList){
            toReturn = toReturn && sudokuRule.isDigitPlaceable(x, y, digit);
        }
        return toReturn;
    }

    public byte[] digitsPlaceable(byte x, byte y){
        if(!sudoku.checkSizeBoundary(x, y))
            return new byte[0];

        byte boundary = (byte) (sudoku.getXBoxSize() * sudoku.getYBoxSize());
        List<Byte> toReturnList = new ArrayList<>();

        for (byte digit = 1; digit <= boundary; digit++)
            if (isDigitPlaceable(x, y, digit))
                toReturnList.add(digit);

        byte[] toReturn = new byte[toReturnList.size()];
        for (int i = 0; i < toReturn.length; i++)
            toReturn[i] = toReturnList.get(i);

        return toReturn;
    }

    @Override
    public void setSudoku(Sudoku sudoku) {
        this.sudoku = sudoku;
        for (SudokuRule sudokuRule : sudokuRuleList)
            sudokuRule.setSudoku(sudoku);
    }
}
