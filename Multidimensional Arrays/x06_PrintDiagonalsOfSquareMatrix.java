package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class x06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrix.length; row++) {
            String matrixData = scanner.nextLine();

            //matrix[row] = Arrays.stream(matrixData.split("//s+")).mapToInt(elem -> Integer.parseInt(elem)).toArray();

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(matrixData.split("\\s+")[col]);
            }
        }

        for (int i = 0; i < matrixSize; i++) {
            System.out.print(matrix[i][i]+ " ");
        }
        System.out.println();

        for (int row = matrixSize -1 , col = 0; col < matrixSize ; row-- , col ++) {
            System.out.print(matrix[row][col] + " ");
        }
    }
}
