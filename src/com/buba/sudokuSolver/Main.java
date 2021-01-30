package com.buba.sudokuSolver;

import com.buba.sudokuSolver.controller.rules.*;
import com.buba.sudokuSolver.controller.solvers.GenericSolver;
import com.buba.sudokuSolver.model.Sudoku;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        sudoku4x4();
        sudoku9x9();
        miracleSudoku();
    }

    public static void sudoku4x4() {

        List<SudokuRule> sudokuRuleList = new ArrayList<>();
        sudokuRuleList.add(new BasicSudokuRule());

        Sudoku sudoku = new Sudoku((byte) 4, (byte) 4, (byte) 2, (byte) 2, sudokuRuleList);

        sudoku.setNumber(0, 0, (byte) 4);
        sudoku.setNumber(0, 3, (byte) 1);
        sudoku.setNumber(1, 0, (byte) 2);
        sudoku.setNumber(1, 2, (byte) 4);
        sudoku.setNumber(2, 0, (byte) 1);
        sudoku.setNumber(3, 1, (byte) 2);

        sudoku.printSudoku();

        List<Sudoku> solutions = GenericSolver.solver(sudoku);

        for (Sudoku solution : solutions)
            solution.printSudoku();
    }

    public static void sudoku9x9() {
        List<SudokuRule> sudokuRuleList = new ArrayList<>();
        sudokuRuleList.add(new BasicSudokuRule());

        Sudoku sudoku = new Sudoku((byte) 9, (byte) 9, (byte) 3, (byte) 3, sudokuRuleList);

        sudoku.setSudoku(
                new byte[][]{
                        {0, 7, 0, 0, 9, 0, 0, 5, 2},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 9, 0, 8, 0, 0, 0, 0},
                        {0, 0, 0, 7, 0, 9, 4, 0, 0},
                        {0, 5, 0, 0, 3, 0, 9, 0, 0},
                        {0, 0, 8, 6, 5, 0, 0, 3, 7},
                        {0, 8, 2, 0, 0, 0, 5, 7, 0},
                        {0, 4, 0, 0, 2, 0, 6, 0, 8},
                        {6, 0, 0, 1, 0, 0, 3, 0, 4}
                }
        );

        sudoku.printSudoku();

        List<Sudoku> solutions = GenericSolver.solver(sudoku);


        System.out.println(solutions.size());

        for (Sudoku solution : solutions)
            solution.printSudoku();
    }

    public static void miracleSudoku(){
        List<SudokuRule> sudokuRuleList = new ArrayList<>();
        sudokuRuleList.add(new BasicSudokuRule());
        sudokuRuleList.add(new KnightSudokuRule());
        sudokuRuleList.add(new KingSudokuRule());
        sudokuRuleList.add(new OrthogonallyConsecutiveDigitSudokuRule());

        Sudoku sudoku = new Sudoku((byte) 9, (byte) 9, (byte) 3, (byte) 3, sudokuRuleList);

        sudoku.setNumber(4, 2, (byte) 1);
        sudoku.setNumber(5, 6, (byte) 2);

        sudoku.printSudoku();

        List<Sudoku> solutions = GenericSolver.solver(sudoku);


        System.out.println(solutions.size());

        for (Sudoku solution : solutions)
            solution.printSudoku();

    }
}