package com.buba.sudokuSolver.model;

import com.buba.sudokuSolver.controller.rules.SudokuRule;
import com.buba.sudokuSolver.controller.rules.SudokuRuleAggregator;
import com.buba.sudokuSolver.exception.NotAllowedValueException;

import java.util.Arrays;
import java.util.List;

public class Sudoku {
    private byte[][] sudoku;
    private final byte xSize, ySize;
    private final byte xBoxSize, yBoxSize;
    private final SudokuRuleAggregator sudokuRuleAggregator;

    public Sudoku(byte xSize, byte ySize, byte xBoxSize, byte yBoxSize, List<SudokuRule> sudokuRuleList) throws IndexOutOfBoundsException {

        if (xSize <= 0 || ySize <= 0) throw new IndexOutOfBoundsException();

        if (xSize % xBoxSize != 0 || ySize % yBoxSize != 0) throw new IndexOutOfBoundsException();

        this.xSize = xSize;
        this.ySize = ySize;
        this.xBoxSize = xBoxSize;
        this.yBoxSize = yBoxSize;
        sudoku = new byte[xSize][ySize];

        this.sudokuRuleAggregator = new SudokuRuleAggregator(sudokuRuleList, this);
    }

    public Sudoku(Sudoku sudoku){
        this.xSize = sudoku.xSize;
        this.ySize = sudoku.ySize;
        this.xBoxSize = sudoku.xBoxSize;
        this.yBoxSize = sudoku.yBoxSize;

        this.sudoku = new byte[xSize][];

        for (int i = 0; i < xSize; i++)
            this.sudoku[i] = sudoku.sudoku[i].clone();

        this.sudokuRuleAggregator = new SudokuRuleAggregator(sudoku.getSudokuRuleAggregator().sudokuRuleList, this);
    }

    public void setNumber(int x, int y, byte digit) throws NotAllowedValueException, IndexOutOfBoundsException {
        if (digit > xSize * ySize || digit < 1)
            throw new NotAllowedValueException();

        sudoku[x][y] = digit;
    }

    public byte getNumber(byte x, byte y) {
        if (x > xSize || y > ySize || x < 0 || y < 0)
            throw new IndexOutOfBoundsException();

        return sudoku[x][y];
    }


    public void setSudoku(byte[][] board) throws NotAllowedValueException, IndexOutOfBoundsException {
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                if (board[i][j] < 0 || board[i][j] > xBoxSize * yBoxSize)
                    throw new NotAllowedValueException();
            }
        }
        sudoku = board;
    }

    public byte[][] getSudoku() {
        return sudoku;
    }

    public byte getXSize() {
        return xSize;
    }

    public byte getYSize() {
        return ySize;
    }

    public byte getXBoxSize() {
        return xBoxSize;
    }

    public byte getYBoxSize() {
        return yBoxSize;
    }

    @Override
    public String toString() {
        return "Sudoku{" +
                "sudoku=" + Arrays.toString(sudoku) +
                ", xSize=" + xSize +
                ", ySize=" + ySize +
                ", xBoxSize=" + xBoxSize +
                ", yBoxSize=" + yBoxSize +
                '}';
    }

    public void printSudoku() {
        for (byte[] row : sudoku) {
            for (byte digit : row)
                System.out.print(" " + digit);
            System.out.print("\n");
        }
    }

    public byte[][] getBox(byte x, byte y) {
        int xPosition = x / xBoxSize;
        int yPosition = y / yBoxSize;

        byte[][] toReturn = new byte[xBoxSize][yBoxSize];

        for (int i = 0; i < xBoxSize; i++) {
            for (int j = 0; j < yBoxSize; j++) {
                toReturn[i][j] = sudoku[xPosition * xBoxSize + i][yPosition * yBoxSize + j];
            }
        }
        return toReturn;
    }


    public byte[] getColumn(byte y) {
        byte[] toReturn = new byte[xSize];
        for (int i = 0; i < toReturn.length; i++) {
            toReturn[i] = sudoku[i][y];
        }
        return toReturn;
    }

    public byte[] getRow(byte x) {
        return sudoku[x];
    }


    public boolean checkBoundary(byte x, byte y, byte digit) {
        if (digit > xBoxSize * yBoxSize || digit < 1)
            return false;

        return checkSizeBoundary(x, y);
    }

    public boolean checkSizeBoundary(byte x, byte y) throws IndexOutOfBoundsException {

        return x < xSize && y < ySize && x >= 0 && y >= 0;
    }

    public SudokuRuleAggregator getSudokuRuleAggregator() {
        return sudokuRuleAggregator;
    }
}