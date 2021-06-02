package MultidimentionalArraysLab;

import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsCols = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(rowsCols[0]);
        int columns = Integer.parseInt(rowsCols[1]);
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] input = scanner.nextLine().split(", ");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int maxRow = -1, maxCol = -1;
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < columns - 1; col++) {
                int currentSum = sumFromTopLeft(matrix, row, col);

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }

        System.out.printf("%d %d%n%d %d%n%d",
                matrix[maxRow][maxCol],
                matrix[maxRow][maxCol + 1],
                matrix[maxRow + 1][maxCol],
                matrix[maxRow + 1][maxCol + 1], maxSum);
    }

    private static int sumFromTopLeft(int[][] matrix, int row, int col) {
        return matrix[row][col] +
                matrix[row + 1][col] +
                matrix[row][col + 1] +
                matrix[row + 1][col + 1];
    }
}