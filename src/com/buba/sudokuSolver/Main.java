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
        arrowSudoku();
        thermometerSudoku();
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

    /**
     * @see <a href="https://www.popularmechanics.com/science/a32605317/miracle-sudoku-hardest-puzzle-ever/">This Sudoku</a>
     */
    public static void miracleSudoku() {
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


    /**
     * @see <a href="https://www.gmpuzzles.com/blog/sudoku-rules-and-info/arrow-sudoku-rules-and-info/">This Sudoku</a>
     */
    public static void arrowSudoku() {
        List<SudokuRule> sudokuRuleList = new ArrayList<>();
        sudokuRuleList.add(new BasicSudokuRule());

        List<byte[]> list = new ArrayList<>();
        list.add(new byte[]{1, 1});
        list.add(new byte[]{0, 2});
        sudokuRuleList.add(new ArrowSudokuRule(new byte[]{2, 0}, list));

        list = new ArrayList<>();
        list.add(new byte[]{2, 3});
        list.add(new byte[]{3, 3});
        list.add(new byte[]{3, 2});

        sudokuRuleList.add(new ArrowSudokuRule(new byte[]{2, 2}, list));

        list = new ArrayList<>();
        list.add(new byte[]{1, 7});
        list.add(new byte[]{2, 8});

        sudokuRuleList.add(new ArrowSudokuRule(new byte[]{0, 6}, list));

        list = new ArrayList<>();
        list.add(new byte[]{2, 5});
        list.add(new byte[]{3, 5});
        list.add(new byte[]{3, 6});

        sudokuRuleList.add(new ArrowSudokuRule(new byte[]{2, 6}, list));

        list = new ArrayList<>();
        list.add(new byte[]{4, 4});
        list.add(new byte[]{4, 3});
        list.add(new byte[]{3, 2});

        sudokuRuleList.add(new ArrowSudokuRule(new byte[]{4, 5}, list));

        list = new ArrayList<>();
        list.add(new byte[]{6, 3});
        list.add(new byte[]{5, 3});
        list.add(new byte[]{5, 2});

        sudokuRuleList.add(new ArrowSudokuRule(new byte[]{6, 2}, list));

        list = new ArrayList<>();
        list.add(new byte[]{6, 5});
        list.add(new byte[]{5, 5});
        list.add(new byte[]{5, 6});

        sudokuRuleList.add(new ArrowSudokuRule(new byte[]{6, 6}, list));

        list = new ArrayList<>();
        list.add(new byte[]{7, 1});
        list.add(new byte[]{6, 0});

        sudokuRuleList.add(new ArrowSudokuRule(new byte[]{8, 2}, list));

        list = new ArrayList<>();
        list.add(new byte[]{7, 7});
        list.add(new byte[]{8, 6});

        sudokuRuleList.add(new ArrowSudokuRule(new byte[]{6, 8}, list));

        Sudoku sudoku = new Sudoku((byte) 9, (byte) 9, (byte) 3, (byte) 3, sudokuRuleList);

        sudoku.setSudoku(new byte[][]{
                {0, 0, 0, 9, 0, 8, 0, 0, 0},
                {0, 0, 5, 0, 0, 0, 8, 0, 0},
                {0, 8, 0, 0, 0, 0, 0, 9, 0},
                {5, 0, 0, 0, 0, 0, 0, 0, 9},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 0, 4},
                {0, 4, 0, 0, 0, 0, 0, 5, 0},
                {0, 0, 8, 0, 0, 0, 4, 0, 0},
                {0, 0, 0, 8, 0, 6, 0, 0, 0},

        });

        sudoku.printSudoku();

        List<Sudoku> solutions = GenericSolver.solver(sudoku);


        System.out.println(solutions.size());

        for (Sudoku solution : solutions)
            solution.printSudoku();
    }

    /**
     * @see <a href="https://www.gmpuzzles.com/blog/sudoku-rules-and-info/thermo-sudoku-rules-and-info/">This Sudoku</a>
     */
    public static void thermometerSudoku() {
        List<SudokuRule> sudokuRuleList = new ArrayList<>();
        sudokuRuleList.add(new BasicSudokuRule());

        List<byte[]> list = new ArrayList<>();
        list.add(new byte[]{0, 0});
        list.add(new byte[]{0, 1});
        list.add(new byte[]{1, 1});
        list.add(new byte[]{2, 1});
        list.add(new byte[]{3, 1});

        sudokuRuleList.add(new ThermometerSudokuRule(list));

        list = new ArrayList<>();
        list.add(new byte[]{2, 3});
        list.add(new byte[]{2, 4});
        list.add(new byte[]{2, 5});
        list.add(new byte[]{3, 5});
        list.add(new byte[]{4, 5});
        list.add(new byte[]{4, 4});

        sudokuRuleList.add(new ThermometerSudokuRule(list));

        list = new ArrayList<>();
        list.add(new byte[]{4, 0});
        list.add(new byte[]{4, 1});
        list.add(new byte[]{4, 2});

        sudokuRuleList.add(new ThermometerSudokuRule(list));

        list = new ArrayList<>();
        list.add(new byte[]{4, 3});
        list.add(new byte[]{5, 3});
        list.add(new byte[]{6, 3});
        list.add(new byte[]{6, 4});
        list.add(new byte[]{6, 5});

        sudokuRuleList.add(new ThermometerSudokuRule(list));

        list = new ArrayList<>();
        list.add(new byte[]{4, 6});
        list.add(new byte[]{4, 7});
        list.add(new byte[]{4, 8});
        list.add(new byte[]{5, 8});

        sudokuRuleList.add(new ThermometerSudokuRule(list));

        list = new ArrayList<>();
        list.add(new byte[]{8, 6});
        list.add(new byte[]{8, 7});
        list.add(new byte[]{8, 8});
        list.add(new byte[]{7, 8});
        list.add(new byte[]{6, 8});
        list.add(new byte[]{6, 7});
        list.add(new byte[]{6, 6});

        sudokuRuleList.add(new ThermometerSudokuRule(list));


        Sudoku sudoku = new Sudoku((byte) 9, (byte) 9, (byte) 3, (byte) 3, sudokuRuleList);

        sudoku.setSudoku(new byte[][]{
                {0, 0, 0, 0, 0, 0, 5, 0, 4},
                {0, 0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 9, 0, 0, 0, 0, 0, 3, 0},
                {7, 0, 8, 0, 0, 0, 0, 0, 0}
        });

        sudoku.printSudoku();

        List<Sudoku> solutions = GenericSolver.solver(sudoku);


        System.out.println(solutions.size());

        for (Sudoku solution : solutions)
            solution.printSudoku();
    }
}