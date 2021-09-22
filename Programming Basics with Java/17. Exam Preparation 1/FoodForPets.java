package Exam28and29March;

import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double food = Double.parseDouble(scanner.nextLine());
        int dogTotal = 0;
        int catTotal = 0;
        double cookies = 0;
        double cookiesSum = 0;

        for (int i = 1; i <= days; i++) {
            int dogFood = Integer.parseInt(scanner.nextLine());
            int catFood = Integer.parseInt(scanner.nextLine());

            if (i % 3 == 0) {
                cookies = (dogFood + catFood) * 0.10;
                cookiesSum += cookies;

            }
            dogTotal += dogFood;
            catTotal += catFood;
        }
        double totalFoodEaten = dogTotal + catTotal;
        double totalPercent = (totalFoodEaten / food) * 100;
        double dogPercent = (dogTotal / totalFoodEaten) * 100;
        double catPercent = (catTotal / totalFoodEaten) * 100;

        System.out.printf("Total eaten biscuits: %.0fgr.%n", cookiesSum);
        System.out.printf("%.2f%% of the food has been eaten.%n", totalPercent);
        System.out.printf("%.2f%% eaten from the dog.%n", dogPercent);
        System.out.printf("%.2f%% eaten from the cat.%n", catPercent);
    }
}