package ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishers = Integer.parseInt(scanner.nextLine());
        double boatRent = 0.0;

        switch (season) {
            case "Spring":
                boatRent = 3000;
                break;
            case "Summer":
            case "Autumn":
                boatRent = 4200;
                break;
            case "Winter":
                boatRent = 2600;
        }

        if (fishers <= 6) {
            boatRent -= boatRent * 0.10;
        } else if (fishers <= 11) {
            boatRent -= boatRent * 0.15;
        } else {
            boatRent -= boatRent * 0.25;
        }

        if (fishers % 2 == 0 && !"Autumn".equals(season)) {
            boatRent -= boatRent * 0.05;
        }
        if (budget >= boatRent) {
            System.out.printf("Yes! You have %.2f leva left.", budget - boatRent);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", boatRent - budget);
        }
    }
}
