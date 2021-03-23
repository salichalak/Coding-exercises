package ConditionalStatementsLab2;

import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuel = (scanner.nextLine());
        double currentLitres = Double.parseDouble(scanner.nextLine());

        boolean isValid = (fuel.equals("Diesel") || fuel.equals("Gasoline") || fuel.equals("Gas"));
        if (!isValid) {
            System.out.println("Invalid fuel!");
        } else {
            if (currentLitres >= 25) {
                System.out.printf("You have enough %s.", fuel.toLowerCase());
            } else {
                System.out.printf("Fill your tank with %s!", fuel.toLowerCase());
            }
        }
    }
}
