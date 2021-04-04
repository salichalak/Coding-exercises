package P02_BasicSyntaxExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        double price = 0;

        switch (typeOfGroup) {
            case "Students":
                if (dayOfWeek.equals("Friday")) {
                    price = 8.45;
                } else if (dayOfWeek.equals("Saturday")) {
                    price = 9.80;
                } else if (dayOfWeek.equals("Sunday")) {
                    price = 10.46;
                }
                break;
            case "Business":
                if (dayOfWeek.equals("Friday")) {
                    price = 10.90;
                } else if (dayOfWeek.equals("Saturday")) {
                    price = 15.60;
                } else if (dayOfWeek.equals("Sunday")) {
                    price = 16;
                }
                break;
            case "Regular":
                if (dayOfWeek.equals("Friday")) {
                    price = 15;
                } else if (dayOfWeek.equals("Saturday")) {
                    price = 20;
                } else if (dayOfWeek.equals("Sunday")) {
                    price = 22.50;
                }
                break;
            default:
                price = 0;
        }
        double totalPrice = price * people;

        if (typeOfGroup.equals("Students") && people >= 30) {
            totalPrice *= 0.85;
        }
        if (typeOfGroup.equals("Business") && people >= 100) {
            totalPrice -= price * 10;
        }
        if (typeOfGroup.equals("Regular") && people >= 10 && people <= 20) {
            totalPrice *= 0.95;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}