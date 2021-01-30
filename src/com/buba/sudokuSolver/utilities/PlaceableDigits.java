package com.buba.sudokuSolver.utilities;

public class PlaceableDigits {
    byte x, y;
    byte[] bytes;

    public PlaceableDigits(byte x, byte y, byte[] bytes) {
        this.x = x;
        this.y = y;
        this.bytes = bytes;
    }

    public byte getX() {
        return x;
    }


    public byte getY() {
        return y;
    }

    public byte[] getBytes() {
        return bytes;
    }
}
