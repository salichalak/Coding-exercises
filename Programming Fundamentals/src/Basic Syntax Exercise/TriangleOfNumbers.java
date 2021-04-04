package P02_BasicSyntaxExercise;

import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int rows = 0; rows <= n; rows++) {
            for (int columns = 0; columns < rows; columns++) {
                System.out.print(rows + " ");
            }
            System.out.println();
        }
    }
}