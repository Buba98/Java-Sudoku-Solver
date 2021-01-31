package com.buba.sudokuSolver.controller.rules;

import java.util.Arrays;
import java.util.List;

public class KillerSudokuRule extends SudokuRule {
    private final byte total;
    private final List<byte[]> cage;

    public KillerSudokuRule(byte total, List<byte[]> cage) {
        this.total = total;
        this.cage = cage;
    }

    @Override
    public boolean isDigitPlaceable(byte x, byte y, byte digit) {
        byte[] position = new byte[]{x, y};

        if (containsArray(position)) {
            byte sum = 0;
            boolean complete = true;
            byte cellValue;

            for (byte[] cagePosition : cage) {
                if (Arrays.equals(cagePosition, position)) {
                    sum += digit;
                    continue;
                }

                cellValue = sudoku.getNumber(cagePosition[0], cagePosition[1]);

                if (cellValue == 0)
                    complete = false;
                else if (cellValue == digit)
                    return false;
                else
                    sum += sudoku.getNumber(cagePosition[0], cagePosition[1]);
            }
            if (complete)
                return sum == total;
            else
                return sum < total;
        } else return true;
    }

    private boolean containsArray(byte[] o) {
        for (byte[] array : cage) {
            if (Arrays.equals(o, array))
                return true;
        }
        return false;
    }
}
