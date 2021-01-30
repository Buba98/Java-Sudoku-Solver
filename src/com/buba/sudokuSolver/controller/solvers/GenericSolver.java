package com.buba.sudokuSolver.controller.solvers;

import com.buba.sudokuSolver.model.Sudoku;
import com.buba.sudokuSolver.utilities.ArrayListInorderAdd;
import com.buba.sudokuSolver.utilities.PlaceableDigits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericSolver {
    public GenericSolver(){

    }

    public static List<Sudoku> solver(Sudoku sudoku){
        List<Sudoku> toReturn = new ArrayList<>();

        optimizedSolver(sudoku, toReturn);

        return toReturn;
    }

    private static void solver(Sudoku sudoku, List<Sudoku> toReturn) {
        for (byte x = 0; x < sudoku.getXSize(); x++) {
            for (byte y = 0; y < sudoku.getYSize(); y++) {
                if (sudoku.getNumber(x, y) == 0) {
                    byte[] placeable = sudoku.getSudokuRuleAggregator().digitsPlaceable(x, y);
                    System.out.println(Arrays.toString(placeable) + " " + x + " " + y);
                    for (byte number : placeable) {
                        sudoku.setNumber(x, y, number);
                        solver(new Sudoku(sudoku), toReturn);
                    }
                    return;
                }
            }
        }
        toReturn.add(sudoku);
    }

    private static void optimizedSolver(Sudoku sudoku, List<Sudoku> toReturn){
        ArrayListInorderAdd placeableList = new ArrayListInorderAdd();

        for (byte x = 0; x < sudoku.getXSize(); x++) {
            for (byte y = 0; y < sudoku.getYSize(); y++) {
                if (sudoku.getNumber(x, y) == 0)
                    placeableList.inorderAdd(new PlaceableDigits(x, y, sudoku.getSudokuRuleAggregator().digitsPlaceable(x, y)));
            }
        }

        if (placeableList.size() == 0) {
            toReturn.add(sudoku);
            return;
        }

        PlaceableDigits placeable = placeableList.get(0);

        System.out.println(Arrays.toString(placeable.getBytes()) + " " + placeable.getX() + " " + placeable.getY());
        for (byte number : placeable.getBytes()) {
            sudoku.setNumber(placeable.getX(), placeable.getY(), number);
            optimizedSolver(new Sudoku(sudoku), toReturn);
        }
    }
}
