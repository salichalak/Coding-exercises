package P19_MidExam;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ordersCount = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        for (int order = 0; order < ordersCount; order++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsules = Integer.parseInt(scanner.nextLine());

            double orderPrice = ((days * capsules) * pricePerCapsule);
            System.out.printf("The price for the coffee is: $%.2f%n", orderPrice);
            totalPrice += orderPrice;
        }

        System.out.printf("Total: $%.2f", totalPrice);
    }
}