package ConditionalStatementsLab2;

import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int squareMetersX = Integer.parseInt(scanner.nextLine());
        double grapesForOneSquareMeterY = Double.parseDouble(scanner.nextLine());
        int neededWineLitresZ = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double grapesTotal = squareMetersX * grapesForOneSquareMeterY;
        double wineLitres = (0.40 * grapesTotal) / 2.5;

        if (wineLitres >= neededWineLitresZ) {
            double litresLeft = wineLitres - neededWineLitresZ;
            double litresPerWorker = litresLeft / workers;
            System.out.printf("Good harvest this year! Total wine: %.0f liters. %n", Math.floor(wineLitres));
            System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(litresLeft), Math.ceil(litresPerWorker));
        } else {
            double litresNeeded = Math.floor(neededWineLitresZ - wineLitres);
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", litresNeeded);
        }
    }
}
