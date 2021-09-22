package P03_BasicSyntaxLabMoreExercise;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = Double.parseDouble(scanner.nextLine());
        String game = scanner.nextLine();
        double moneySpent = 0;

        while (!game.equals("Game Time")) {
            double gamePrice = 0;

            switch (game) {
                case "OutFall 4":
                    gamePrice = 39.99;
                    break;
                case "CS: OG":
                    gamePrice = 15.99;
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99;
                    break;
                case "Honored 2":
                    gamePrice = 59.99;
                    break;
                case "RoverWatch":
                    gamePrice = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    gamePrice = 0;
                    break;
            }
            if (gamePrice != 0) {
                if (balance >= gamePrice) {
                    System.out.printf("Bought %s%n", game);
                    balance -= gamePrice;
                    moneySpent += gamePrice;
                } else {
                    System.out.println("Too Expensive");
                    gamePrice = 0;
                }
            }
            if (balance <= 0) {
                System.out.println("Out of money!");
            }
            game = scanner.nextLine();
        }
        if (balance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", moneySpent, balance);
        }
    }
}