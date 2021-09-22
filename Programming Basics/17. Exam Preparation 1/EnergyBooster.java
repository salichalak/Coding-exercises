package Exam28and29March;

import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String size = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (size) {
            case "small":
                if (fruit.equals("Watermelon")) {
                    price = 2 * 56;
                } else if (fruit.equals("Mango")) {
                    price = 2 * 36.66;
                } else if (fruit.equals("Pineapple")) {
                    price = 2 * 42.10;
                } else if (fruit.equals("Raspberry")) {
                    price = 2 * 20;
                }
                break;
            case "big":
                if (fruit.equals("Watermelon")) {
                    price = 5 * 28.70;
                } else if (fruit.equals("Mango")) {
                    price = 5 * 19.60;
                } else if (fruit.equals("Pineapple")) {
                    price = 5 * 24.80;
                } else if (fruit.equals("Raspberry")) {
                    price = 5 * 15.20;
                }
                break;
        }
        double totalPrice = count * price;
        double discount = 0.0;

        if (totalPrice >= 400 && totalPrice <= 1000) {
            discount = totalPrice * 0.15;
        } else if (totalPrice > 1000) {
            discount = totalPrice / 2;
        } else {
            discount = 0;
        }
        double totalSum = totalPrice - discount;
        System.out.printf("%.2f lv.", totalSum);
    }
}