package MultidimensionalArrays;

import java.util.Scanner;

public class x04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String matrix = scanner.nextLine();
        int rows = Integer.parseInt(matrix.split(", ")[0]);
        int cols = Integer.parseInt(matrix.split(", ")[1]);

        int[][] matrixData = new int[rows][cols];
        int sum = 0;

        for (int i = 0; i < matrixData.length ; i++) {
            String[] inputNums = scanner.nextLine().split(", ");
            for (int j = 0; j < matrixData[i].length ; j++) {
                matrixData[i][j] = Integer.parseInt(inputNums[j]);
                sum += Integer.parseInt(inputNums[j]);
            }
        }
        System.out.println(matrixData.length);
        System.out.println(matrixData[0].length);
        System.out.println(sum);
    }
}

