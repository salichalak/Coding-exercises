package ConditionalStatementsLab2;

import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int foodKg = Integer.parseInt(scanner.nextLine());
        double dogFoodDailyKg = Double.parseDouble(scanner.nextLine());
        double catFoodDailyKg = Double.parseDouble(scanner.nextLine());
        double turtleFoodDailyG = Double.parseDouble(scanner.nextLine());

        double dogNeededFood = days * dogFoodDailyKg;
        double catNeededFood = days * catFoodDailyKg;
        double turtleNeededFood = days * turtleFoodDailyG * 0.001;
        double totalFoodNeeded = dogNeededFood + catNeededFood + turtleNeededFood;

        if (totalFoodNeeded <= foodKg) {
            double foodLeft = foodKg - totalFoodNeeded;
            System.out.printf("%.0f kilos of food left.", Math.floor(foodLeft));
        } else {
            double foodNeeded = totalFoodNeeded - foodKg;
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(foodNeeded));
        }
    }
}
