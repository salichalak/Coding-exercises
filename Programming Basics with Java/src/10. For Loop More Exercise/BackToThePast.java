package ForLoopLab2;

import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heritage = Double.parseDouble(scanner.nextLine());
        int yearsToLive = Integer.parseInt(scanner.nextLine());
        int years = 18;

        for (int currentYear = 1800; currentYear <= yearsToLive; currentYear++) {
            if (currentYear % 2 == 0) {
                heritage -= 12000;
            } else {
                heritage -= (12000 + 50 * years);
            }
            years++;
        }

        if (heritage >= 0) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", heritage);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", Math.abs(heritage));
        }
    }
}
