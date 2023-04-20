package MultidimensionalArrays;

import java.util.Scanner;

public class x02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] matrixValue = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixValue[0]);
        int cols = Integer.parseInt(matrixValue[1]);

        int[][] matrixData = new int[rows][cols];

        for (int row = 0; row < matrixData.length ; row++) {
            String[] inputLine = scanner.nextLine().split("\\s+");

            for (int col = 0; col < matrixData[row].length ; col++) {
                matrixData[row][col] = Integer.parseInt(inputLine[col]);
            }
        }
        int number = Integer.parseInt(scanner.nextLine());
        boolean isContains = false;

        for (int i = 0; i < matrixData.length ; i++) {
            for (int j = 0; j < matrixData[i].length ; j++) {
                if (number == matrixData[i][j]){
                    isContains = true;
                    System.out.println(i + " " + j);
                }
            }
        }
        if (!isContains){
            System.out.println("not found");
        }

    }
}
