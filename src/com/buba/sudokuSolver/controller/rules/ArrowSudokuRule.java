package com.buba.sudokuSolver.controller.rules;

import java.util.Arrays;
import java.util.List;


public class ArrowSudokuRule extends SudokuRule {

    private final byte[] source;
    private final List<byte[]> arrow;

    public ArrowSudokuRule(byte[] source, List<byte[]> arrow) {
        this.arrow = arrow;
        this.source = source;
    }

    @Override
    public boolean isDigitPlaceable(byte x, byte y, byte digit) {
        byte[] position = new byte[]{x, y};

        if (Arrays.equals(position, source)) {
            byte sum = 0;
            boolean complete = true;

            for (byte[] arrowPosition : arrow) {
                if (sudoku.getNumber(arrowPosition[0], arrowPosition[1]) == 0)
                    complete = false;
                else
                    sum += sudoku.getNumber(arrowPosition[0], arrowPosition[1]);
            }

            if (complete)
                return sum == digit;
            else
                return sum < digit;
        } else if (containsArray(position)) {
            byte sum = 0;
            boolean complete = true;

            for (byte[] arrowPosition : arrow) {
                if (Arrays.equals(arrowPosition, position)) {
                    sum += digit;
                } else if (sudoku.getNumber(arrowPosition[0], arrowPosition[1]) == 0)
                    complete = false;
                else
                    sum += sudoku.getNumber(arrowPosition[0], arrowPosition[1]);
            }

            if (sudoku.getNumber(source[0], source[1]) == 0) {
                return sum <= sudoku.getXBoxSize() * sudoku.getYBoxSize();
            } else {
                if (complete)
                    return sum == sudoku.getNumber(source[0], source[1]);
                else
                    return sum < sudoku.getNumber(source[0], source[1]);
            }
        } else return true;
    }

    private boolean containsArray(byte[] o) {
        for (byte[] array : arrow) {
            if (Arrays.equals(o, array))
                return true;
        }
        return false;
    }
}
