package Test;

import java.util.Scanner;

public class p04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double wantedProfit = Double.parseDouble(scanner.nextLine());
        double sum = 0.0;

        String cocktail = scanner.nextLine();
        while (!"Party!".equals(cocktail)) {
            int count = Integer.parseInt(scanner.nextLine());
            double totalPrice = cocktail.length() * count;
            if (totalPrice % 2 != 0) {
                totalPrice -= totalPrice * 0.25;
            }
            sum += totalPrice;
            if (sum >= wantedProfit) {
                System.out.printf("Target acquired.%n");
                System.out.printf("Club income - %.2f leva.", sum);
                break;
            }
            cocktail = scanner.nextLine();
        }
        if ("Party!".equals(cocktail)) {
            System.out.printf("We need %.2f leva more.%n", wantedProfit - sum);
            System.out.printf("Club income - %.2f leva.", sum);
        }
    }
}
