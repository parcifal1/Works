package sudoku;


public class SudokuSolver extends SudokuBoard {

    public static boolean solve(int[][] board) {
        for (int row = 0; row < GRID; row++) {
            for (int column = 0; column < GRID; column++) {
                if (board[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= 9; numberToTry++) {
                        //Backtrack, he will always start from begin and validate, previously putted into array numbers.
                        if (isValidPlace(board, numberToTry, column, row)) {
                            board[row][column] = numberToTry;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] board = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };

        solve(board);
        printBoard(board);
    }


}
