package MultidimensionalArrays;

import java.util.Scanner;

public class x05_MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(",\\s+");
        int rowCount = Integer.parseInt(matrixSize[0]);
        int colCount = Integer.parseInt(matrixSize[1]);
        int[][] matrix = new int[rowCount][colCount];

        for (int row = 0; row < matrix.length; row++) {
            String matrixData = scanner.nextLine();

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(matrixData.split(",\\s+")[col]);
            }
        }
        int sum2x2square = Integer.MIN_VALUE;
        int startRowIndexForBiggestSum = -1;
        int startColIndexForBiggestSum = -1;

        for (int row = 0; row < matrix.length -1 ; row++) {
            for (int col = 0; col < matrix[row].length -1 ; col++) {
                int currentSum = matrix[row][col] + matrix[row][col+1] + matrix[row+1][col] + matrix[row+1][col+1];

                if (currentSum > sum2x2square){
                    sum2x2square = currentSum;
                    startRowIndexForBiggestSum = row;
                    startColIndexForBiggestSum = col;
                }
            }
        }
        System.out.println(matrix[startRowIndexForBiggestSum][startColIndexForBiggestSum] + " " + matrix[startRowIndexForBiggestSum][startColIndexForBiggestSum +1]);
        System.out.println(matrix[startRowIndexForBiggestSum+1][startColIndexForBiggestSum] + " " + matrix[startRowIndexForBiggestSum+1][startColIndexForBiggestSum +1]);
        System.out.println(sum2x2square);
    }
}
