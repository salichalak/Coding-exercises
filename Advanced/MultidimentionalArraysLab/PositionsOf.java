package MultidimentionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndColumns = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndColumns[0]);
        int columns = Integer.parseInt(rowsAndColumns[1]);
        int[][] matrix = new int[rows][columns];
        boolean isFound = false;

        for (int i = 0; i < rows; i++) {
            int[] rowData = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = rowData;
        }

        int needle = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (matrix[row][col] == needle) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }
}