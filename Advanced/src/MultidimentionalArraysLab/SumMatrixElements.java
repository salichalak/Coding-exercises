package MultidimentionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsCols = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);

        System.out.println(rows);
        System.out.println(cols);

        int sum = 0;
        for (int row = 0; row < rows; row++) {
            sum += Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        System.out.println(sum);
    }
}