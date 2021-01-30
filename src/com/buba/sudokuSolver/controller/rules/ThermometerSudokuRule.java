package com.buba.sudokuSolver.controller.rules;

import java.util.Arrays;
import java.util.List;

public class ThermometerSudokuRule extends SudokuRule{

    private final List<byte[]> thermometer;

    public ThermometerSudokuRule(List<byte[]>thermometer){
        this.thermometer = thermometer;
    }

    @Override
    public boolean isDigitPlaceable(byte x, byte y, byte digit) {
        byte[] position = new byte[]{x, y};
        if (containsArray(position)){
            return digit <= getAllowedForNextDigit(position) && digit >= getAllowedForPreviousDigit(position);
        } else return true;
    }

    private boolean containsArray(byte[] o) {
        for (byte[] array : thermometer) {
            if (Arrays.equals(o, array))
                return true;
        }
        return false;
    }

    private byte inArrayPosition(byte[] o){
        for (byte i = 0; i < thermometer.size(); i++){
            if (Arrays.equals(o, thermometer.get(i)))
                return i;
        }
        return -1;
    }

    private byte getAllowedForNextDigit(byte[] position){
        byte i = inArrayPosition(position);
        byte toReturn;

        for (byte j = (byte) (i+1); j < thermometer.size(); j++){
            toReturn = sudoku.getNumber(thermometer.get(j)[0], thermometer.get(j)[1]);

            if (toReturn != 0)
                return (byte) (toReturn - (j - i));

        }
        return (byte) ((sudoku.getXBoxSize() * sudoku.getYBoxSize() + 1) - (thermometer.size() - i));
    }

    private byte getAllowedForPreviousDigit(byte[] position){
        byte i = inArrayPosition(position);
        byte toReturn;

        for (byte j = (byte) (i - 1); j >= 0 ; j--){
            toReturn = sudoku.getNumber(thermometer.get(j)[0], thermometer.get(j)[1]);

            if (toReturn != 0)
                return (byte) (toReturn + (i - j));
        }

        return (byte) (i + 1);
    }
}
