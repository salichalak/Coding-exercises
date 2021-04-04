package P11_MethodsExercise;

import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        printMatrix(number);
    }

    private static void printMatrix(int number) {
        for (int rows = 1; rows <= number; rows++) {
            System.out.print(number + " ");
            for (int columns = 1; columns < number ; columns++) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}