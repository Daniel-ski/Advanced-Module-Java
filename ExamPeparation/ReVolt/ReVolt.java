package Exercise.ReVolt;

import java.util.Scanner;

public class ReVolt {
    public static int playerPositionRow = -1;
    public static int playerPositionCol = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[matrixSize][matrixSize];

        fillMatrix(scanner, matrix);

        //int  playerPositionRow = -1;
        // int playerPositionCol = -1;
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                if (matrix[row][col].equals("f" )) {
                    playerPositionRow = row;
                    playerPositionCol = col;
                }
            }
        }

        boolean isReachesFinis = false;
        String command = scanner.nextLine();
        while (countOfCommands > 0 && !isReachesFinis) {

            int currentPlayerPositionRow = playerPositionRow;
            int currentPlayerPositionCol = playerPositionCol;

            matrix[currentPlayerPositionRow][currentPlayerPositionCol] = "-";
            switch (command) {

                case "up":
                    playerPositionRow--;
                    outOfMatrix(playerPositionRow, playerPositionCol, matrixSize);

                    if (matrix[playerPositionRow][playerPositionCol].equals("B" )) {
                        playerPositionRow--;
                    } else if (matrix[playerPositionRow][playerPositionCol].equals("T" )) {
                        playerPositionRow++;
                    }
                    break;
                case "down":
                    playerPositionRow++;
                    outOfMatrix(playerPositionRow, playerPositionCol, matrixSize);
                    if (matrix[playerPositionRow][playerPositionCol].equals("B" )) {
                        playerPositionRow++;
                    } else if (matrix[playerPositionRow][playerPositionRow].equals("T" )) {
                        playerPositionRow--;
                    }
                    break;
                case "left":
                    playerPositionCol--;
                    outOfMatrix(playerPositionRow, playerPositionCol, matrixSize);
                    if (matrix[playerPositionRow][playerPositionCol].equals("B" )) {
                        playerPositionCol--;
                    } else if (matrix[playerPositionRow][playerPositionCol].equals("T" )) {
                        playerPositionCol++;
                    }
                    break;
                case "right":
                    playerPositionCol++;
                    outOfMatrix(playerPositionRow, playerPositionCol, matrixSize);
                    if (matrix[playerPositionRow][playerPositionCol].equals("B" )) {
                        playerPositionCol++;
                    } else if (matrix[playerPositionRow][playerPositionCol].equals("T" )) {
                        playerPositionCol--;
                    }
                    break;
            }
            countOfCommands--;

            if (matrix[playerPositionRow][playerPositionCol].equals("F" )) {
                isReachesFinis = true;
            }

            matrix[playerPositionRow][playerPositionCol] = "f";
            if (countOfCommands == 0){
                break;
            }
            command = scanner.nextLine();
        }
        if (isReachesFinis) {
            System.out.println("Player won!" );
        } else {
            System.out.println("Player lost!" );
        }
        printMatrix(matrix);
    }

    public static void fillMatrix(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("" );
        }
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void outOfMatrix(int playerPositionRow, int playerPositionCol, int matrixSize) {
        if (playerPositionRow >= matrixSize) {
            ReVolt.playerPositionRow = 0;
        } else if (playerPositionRow < 0) {
            ReVolt.playerPositionRow = matrixSize - 1;
        }

        if (playerPositionCol >= matrixSize) {
            ReVolt.playerPositionCol = 0;
        } else if (playerPositionCol < 0) {
            ReVolt.playerPositionCol = matrixSize - 1;
        }
    }
}
