package MultidimentionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstMatrixRows = dimensions[0];
        int firstMatrixCols = dimensions[1];

        int[][] firstMatrix = new int[firstMatrixRows][];

        for (int i = 0; i < firstMatrixRows; i++) {
            int[] inputData = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            firstMatrix[i] = inputData;
        }

        dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        firstMatrixRows = dimensions[0];
        firstMatrixCols = dimensions[1];

        int[][] secondMatrix = new int[firstMatrixRows][];

        for (int i = 0; i < firstMatrixRows; i++) {
            int[] inputData = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            secondMatrix[i] = inputData;
        }

        if (areEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean areEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}