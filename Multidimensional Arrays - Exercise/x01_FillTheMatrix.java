package MultidimensionalArrays_Exercise;

import java.util.Scanner;

public class x01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        int matrixSize = Integer.parseInt(inputLine.split(", ")[0]);
        String pattern = inputLine.split(", ")[1];

        int[][] matrix = new int[matrixSize][matrixSize];

        if (pattern.equals("A")){
            fillMatrixPatternA(matrix);

        } else if (pattern.equals("B")) {
            fillMatrixPatternB(matrix);
        }
        printMatrix(matrix);
    }
    public static void fillMatrixPatternA (int[][] matrix){
        int counter = 1;
        for (int col = 0; col < matrix.length  ; col++) {
            for (int row = 0; row < matrix.length ; row++) {
                matrix[row][col] = counter;
                counter ++;
            }
        }
    }
    public static void fillMatrixPatternB (int[][] matrix){
        int counter = 1;
        for (int col = 0; col < matrix.length ; col++) {
            if (col % 2 == 0){
                for (int row = 0; row < matrix.length ; row++) {
                    matrix[row][col] = counter;
                    counter ++;
                }
            }else {
                for (int row = matrix.length-1 ; row >= 0 ; row--) {
                    matrix[row][col] = counter;
                    counter ++;
                }
            }
        }
    }
    public static void printMatrix (int[][] matrix){
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
