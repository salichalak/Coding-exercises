package Pb_Exam_Online;

import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = 0;
        int toyPrice = 5;
        double moneyForToys = 0.0;
        int sweaterPrice = 15;
        double moneyForSweaters = 0.0;

        int counter16 = 0;
        int counterOlderThan16 = 0;

        String input = scanner.nextLine();
        while (!input.equals("Christmas")) {
            age = Integer.parseInt(input);

            if (age <= 16) {
                counter16++;
                moneyForToys += toyPrice;
            } else {
                counterOlderThan16++;
                moneyForSweaters += sweaterPrice;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Number of adults: %d%n", counterOlderThan16);
        System.out.printf("Number of kids: %d%n", counter16);
        System.out.printf("Money for toys: %.0f%n", moneyForToys);
        System.out.printf("Money for sweaters: %.0f%n", moneyForSweaters);
    }
}