package Exam28and29March;

import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int food = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int foodSum = 0;

        while (!input.equals("Adopted")) {
            int foodEaten = Integer.parseInt(input);
            foodSum += foodEaten;

            input = scanner.nextLine();
        }
        int foodGrams = food * 1000;
        if (foodSum <= foodGrams) {
            System.out.printf("Food is enough! Leftovers: %d grams.", foodGrams - foodSum);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", Math.abs(foodSum - foodGrams));
        }
    }
}
