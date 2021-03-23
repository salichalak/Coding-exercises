package Pb_Exam_Online;

import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int catsNumber = Integer.parseInt(scanner.nextLine());

        int group1 = 0;
        int group2 = 0;
        int group3 = 0;

        int catsCounter = 1;
        double totalFoodInGrams = 0;

        while (catsCounter <= catsNumber) {
            double foodWeightInGrams = Double.parseDouble(scanner.nextLine());
            totalFoodInGrams += foodWeightInGrams;
            if (foodWeightInGrams >= 100 && foodWeightInGrams < 200) {
                group1++;
            } else if (foodWeightInGrams >= 200 && foodWeightInGrams < 300) {
                group2++;
            } else if (foodWeightInGrams >= 300 && foodWeightInGrams <= 400) {
                group3++;
            }

            catsCounter++;
        }
        double foodPrice = (totalFoodInGrams / 1000) * 12.45;
        System.out.printf("Group 1: %d cats.%n", group1);
        System.out.printf("Group 2: %d cats.%n", group2);
        System.out.printf("Group 3: %d cats.%n", group3);
        System.out.printf("Price for food per day: %.2f lv.%n", foodPrice);
    }
}
