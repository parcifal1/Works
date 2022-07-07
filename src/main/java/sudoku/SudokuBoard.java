package sudoku;

abstract class SudokuBoard {
    public static final int GRID = 9;

    private static boolean isNumberInRow(int[][] board, int number, int row) {
        for (int i = 0; i < GRID; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(int[][] board, int number, int column) {
        for (int i = 0; i < GRID; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int number, int column, int row) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;
        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValidPlace(int[][] board, int number, int column, int row) {
        return !isNumberInColumn(board, number, column) &&
                !isNumberInRow(board, number, row) &&
                !isNumberInBox(board, number, column, row);
    }

    public static void printBoard(int[][] board) {
        for (int row = 0; row < GRID; row++) {
            System.out.println();
            if (row % 3 == 0 && row != 0 ){
                System.out.println("-----------------------");
            }
            for (int column = 0; column < GRID; column++) {
                System.out.print(board[row][column]);
                if (column == 5 || column == 2){
                    System.out.print("|");
                }
            }
        }
    }

}
