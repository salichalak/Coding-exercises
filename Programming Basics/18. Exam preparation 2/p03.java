package Test;

import java.util.Scanner;

public class p03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drink = scanner.nextLine();
        String sugarOption = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        double price = 0;

        switch (drink) {
            case "Espresso":
                if ("Without".equals(sugarOption)) {
                    price = 0.90;
                } else if ("Normal".equals(sugarOption)) {
                    price = 1;
                } else if ("Extra".equals(sugarOption)) {
                    price = 1.20;
                }
                break;
            case "Cappuccino":
                if ("Without".equals(sugarOption)) {
                    price = 1;
                } else if ("Normal".equals(sugarOption)) {
                    price = 1.20;
                } else if ("Extra".equals(sugarOption)) {
                    price = 1.60;
                }
                break;
            case "Tea":
                if ("Without".equals(sugarOption)) {
                    price = 0.50;
                } else if ("Normal".equals(sugarOption)) {
                    price = 0.60;
                } else if ("Extra".equals(sugarOption)) {
                    price = 0.70;
                }
                break;
        }

        if ("Without".equals(sugarOption)) {
            price -= price * 0.35;
        }
        if (count >= 5) {
            price -= price * 0.25;
        }
        double totalSum = price * count;

        if (totalSum > 15) {
            totalSum = totalSum * 0.80;
        }
        System.out.printf("You bought %d cups of %s for %.2f lv.", count, drink, totalSum);
    }
}
