package FirstStepsLab;

import java.util.Scanner;

public class BirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hallRent = Integer.parseInt(scanner.nextLine());

        double cakePrice = hallRent * 0.20;
        double drinksPrice = cakePrice - cakePrice * 0.45;
        double animatorPrice = hallRent * 1.0 / 3;

        double totalSum = hallRent + cakePrice + drinksPrice + animatorPrice;

        System.out.println(totalSum);
    }
}
