package MultidimensionalArrays;

import java.util.Scanner;

public class x01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputDimensions = scanner.nextLine().split("\\s+");
        int rowCount = Integer.parseInt(inputDimensions[0]);
        int colCount = Integer.parseInt(inputDimensions[1]);

        int[][] firsMatrix = new int[rowCount][colCount];


        for (int row = 0; row < rowCount; row++) {
            String[] parts = scanner.nextLine().split("\\s+");
            for (int col = 0; col < colCount; col++) {
                firsMatrix[row][col] = Integer.parseInt(parts[col]);
            }
        }

        String[] inputDimensions2 = scanner.nextLine().split("\\s+");
        int rowCount2 = Integer.parseInt(inputDimensions2[0]);
        int colCount2 = Integer.parseInt(inputDimensions2[1]);
        int[][] secondMatrix = new int[rowCount2][colCount2];

        for (int row = 0; row < rowCount2; row++) {
            String[] parts = scanner.nextLine().split("\\s+");
            for (int col = 0; col < colCount2; col++) {
                secondMatrix[row][col] = Integer.parseInt(parts[col]);
            }
        }
        if (rowCount != rowCount2 || colCount != colCount2){
            System.out.println("not equal");

        }else {
            if (isEqual(firsMatrix, secondMatrix)) {
                System.out.println("equal");
            } else {
                System.out.println("not equal");
            }
        }
    }
    public static boolean isEqual (int[][] firstMatrix , int[][] secondMatrix){
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]){
                    return false;
                }
            }
        }
        return true;
    }
}
