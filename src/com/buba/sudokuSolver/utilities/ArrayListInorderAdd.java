package com.buba.sudokuSolver.utilities;

import java.util.ArrayList;

public class ArrayListInorderAdd extends ArrayList<PlaceableDigits> {
    public void inorderAdd(PlaceableDigits toAdd){

        for (int i = 0; i < this.size(); i++){
            if (toAdd.getBytes().length < get(i).getBytes().length) {
                add(i, toAdd);
                return;
            }
        }
        add(toAdd);
    }
}
