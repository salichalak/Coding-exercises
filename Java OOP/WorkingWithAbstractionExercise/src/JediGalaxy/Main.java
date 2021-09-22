package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int n = dimensions[0];
        int m = dimensions[1];

        int[][] matrix = fillMatrix(n, m);

        long sum = 0;

        String command = scanner.nextLine();

        while (!command.equals("Let the Force be with you")) {
            int[] dataIvo = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] dataEvil = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int xEvil = dataEvil[0];
            int yEvil = dataEvil[1];

            while (xEvil >= 0 && yEvil >= 0) {
                if (xEvil < matrix.length && yEvil < matrix[0].length) {
                    matrix[xEvil][yEvil] = 0;
                }

                xEvil--;
                yEvil--;
            }

            int xIvo = dataIvo[0];
            int yIvo = dataIvo[1];

            while (xIvo >= 0 && yIvo < matrix[1].length) {
                if (xIvo < matrix.length && yIvo >= 0 && yIvo < matrix[0].length) {
                    sum += matrix[xIvo][yIvo];
                }

                yIvo++;
                xIvo--;
            }

            command = scanner.nextLine();
        }

        System.out.println(sum);
    }

    private static int[][] fillMatrix(int n, int m) {
        int[][] matrix = new int[n][m];

        int number = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                matrix[row][col] = number++;
            }
        }
        return matrix;
    }
}