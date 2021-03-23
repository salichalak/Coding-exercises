package WhileLoopLab2;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int expectedSUm = Integer.parseInt(scanner.nextLine());

        String command = "";
        int transactionsCounter = 0;
        int cash = 0;
        int transactionCash = 0;
        int card = 0;
        int transactionCard = 0;

        while ((!"End".equals(command = scanner.nextLine())) && cash + card < expectedSUm) {
            int itemsPrice = Integer.parseInt(command);

            if (transactionsCounter++ % 2 == 0) {
                if (itemsPrice > 100) {
                    System.out.println("Error in transaction!");
                } else {
                    transactionCash++;
                    cash += itemsPrice;
                    System.out.println("Product sold!");
                }

            } else {
                if (itemsPrice < 10) {
                    System.out.println("Error in transaction!");
                } else {
                    transactionCard++;
                    card += itemsPrice;
                    System.out.println("Product sold!");
                }
            }
        }

        if (command.equals("End")) {
            System.out.println("Failed to collect required money for charity.");
        } else {
            double totalSumCash = cash * 1.0 / transactionCash;
            double totalSumCard = card * 1.0 / transactionCard;
            System.out.printf("Average CS: %.2f%n", totalSumCash);
            System.out.printf("Average CC: %.2f", totalSumCard);
        }
    }
}
