package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());

        double commission = 0.0;
        boolean invalidTown = false;

        switch (town) {
            case "Sofia":
                if (sales > 10000) {
                    commission = 0.12;
                } else if (sales > 1000) {
                    commission = 0.08;
                } else if (sales > 500) {
                    commission = 0.07;
                } else if (sales >= 0) {
                    commission = 0.05;
                }
                break;
            case "Varna":
                if (sales > 10000) {
                    commission = 0.13;
                } else if (sales > 1000) {
                    commission = 0.10;
                } else if (sales > 500) {
                    commission = 0.075;
                } else if (sales >= 0) {
                    commission = 0.045;
                }
                break;
            case "Plovdiv":
                if (sales > 10000) {
                    commission = 0.145;
                } else if (sales > 1000) {
                    commission = 0.12;
                } else if (sales > 500) {
                    commission = 0.08;
                } else if (sales >= 0) {
                    commission = 0.055;
                }
                break;
            default:
                invalidTown = true;
                break;
        }
        double result = sales * commission;

        if (!invalidTown && sales >= 0) {
            System.out.printf("%.2f", result);
        }
        else {
            System.out.println("error");
        }
    }
}