package WhileLoopLab2;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bottles = Integer.parseInt(scanner.nextLine());

        int detergent = bottles * 750;
        String command = scanner.nextLine();
        int dishes = 0;
        int pots = 0;
        int utensilsCounter = 0;
        int dishesCounter = 0;
        int potsCounter = 0;
        int neededDetergent = 0;
        boolean ifDishes = false;
        boolean ifPots = false;

        while (!command.equals("End")) {
            int utensils = Integer.parseInt(command);
            utensilsCounter++;

            if (utensilsCounter % 3 == 0) {
                pots = utensils;
                ifPots = true;
                ifDishes = false;
                detergent = detergent - (pots * 15);
                potsCounter += pots;

            } else {
                dishes = utensils;
                ifDishes = true;
                ifPots = false;
                detergent = detergent - (dishes * 5);
                dishesCounter += dishes;
            }
            if (detergent < 0) {
                neededDetergent = Math.abs(detergent);
                System.out.printf("Not enough detergent, %d ml. more necessary!", neededDetergent);
                break;
            }

            command = scanner.nextLine();
        }

        if (command.equals("End")) {
            int leftOverDetergent = detergent;
            System.out.printf("Detergent was enough!%n%d dishes and %d pots were washed.%nLeftover detergent %d ml.",
                    dishesCounter, potsCounter, leftOverDetergent);
        }
    }
}
