package Pb_Exam_Online;

import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int catsNumber = Integer.parseInt(scanner.nextLine());

        int firstGroup = 0;
        int secondGroup = 0;
        int thirdGroup = 0;

        int cats = 1;
        double totalFoodInGrams = 0;

        while (cats <= catsNumber) {
            double foodWeightInGrams = Double.parseDouble(scanner.nextLine());
            totalFoodInGrams += foodWeightInGrams;
			
            if (foodWeightInGrams >= 100 && foodWeightInGrams < 200) {
                group1++;
            } else if (foodWeightInGrams >= 200 && foodWeightInGrams < 300) {
                group2++;
            } else if (foodWeightInGrams >= 300 && foodWeightInGrams <= 400) {
                group3++;
            }

            cats++;
        }
		
        double foodPrice = (totalFoodInGrams / 1000) * 12.45;
        System.out.printf("Group 1: %d cats.%n", firstGroup);
        System.out.printf("Group 2: %d cats.%n", secondGroup);
        System.out.printf("Group 3: %d cats.%n", thirdGroup);
        System.out.printf("Price for food per day: %.2f lv.%n", foodPrice);
    }
}