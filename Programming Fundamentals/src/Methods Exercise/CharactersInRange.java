package P11_MethodsExercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char start = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);
        printCharactersInRange(start, end);
    }

    private static void printCharactersInRange(char start, char end) {
        if (start < end) {
            for (char symbol = (char) (start + 1); symbol < end; symbol++) {
                System.out.print(symbol + " ");
            }
        } else {
            for (char symbol = (char) (end + 1); symbol < start; symbol++) {
                System.out.print(symbol + " ");
            }
        }
    }
}