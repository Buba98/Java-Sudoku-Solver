# Sudoku-Solver

This sudoku solver with a recursive function will find all the solutions (if the sudoku has any solution)
for all the sudoku for whom the rules have been implemented.

For now the supported rules are:

* Normal sudoku rules
* Knight (chess) sudoku rule: every digit can't be in a knight-move distance from a digit with the same value
* King (chess) sudoku rule: every digit can't be in a king-move distance from a digit with the same value
* Arrow sudoku rule: the arrow is made by a source and the arrow itself. The value in the source is equal to the sum of
  the digits in the arrow
* Orthogonally consecutive digit: every digit can't have a consecutive digit (+1 / -1) in an orthogonal cell
* Thermometer sudoku rule: digits must be strictly increasing from the round bulb to the flat end
* Killer sudoku rule: in a cage a digit can't be repeated, and all digit in the cage have to sum up to a certain number
* Diagonal sudoku rule: in both the diagonals the numbers can't be repeated