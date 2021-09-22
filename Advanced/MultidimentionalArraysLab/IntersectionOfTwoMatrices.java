package MultidimentionalArraysLab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][columns];
        char[][] secondMatrix = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < columns; col++) {
                firstMatrix[row][col] = input[col].charAt(0);
            }
        }

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < columns; col++) {
                secondMatrix[row][col] = input[col].charAt(0);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    System.out.print(firstMatrix[row][col] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}