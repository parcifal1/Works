package sudoku;

import java.util.Scanner;

public class SudokuConsoleGame extends SudokuBoard {

    private static int randomNumberOrPosition(boolean isPosition) {
        if (isPosition) {
            return (int) (Math.random() * 8);
        }
        return 1 + (int) (Math.random() * 9);
    }

    private static int scanAnswer(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int[][] generateSudoku(int numbersInBoard) {
        int[][] tempBoard = new int[9][9];

        for (int row = 0; row < GRID; row++) {
            for (int column = 0; column < GRID; column++) {
                tempBoard[row][column] = 0;
            }
        }

        for (int i = 0; i < numbersInBoard; i++) {
            int row = randomNumberOrPosition(true);
            int column = randomNumberOrPosition(true);
            int number = randomNumberOrPosition(false);

            if (tempBoard[row][column] == 0 && isValidPlace(tempBoard, number, column, row)) {
                    tempBoard[row][column] = number;
            }
        }
        return tempBoard;
    }

    public static void startGame() {
        System.out.println("Hello, choose hom many numbers will be in board from the begin");
        printBoard(generateSudoku(scanAnswer()));


    }

    public static void main(String[] args) {
    }
}
