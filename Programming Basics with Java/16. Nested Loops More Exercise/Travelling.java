package NestedLoops;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();

        while (!destination.equals("End")) {
            double budget = Double.parseDouble(scanner.nextLine());
            double savedAmount = 0;

            while (savedAmount < budget) {
                savedAmount += Double.parseDouble(scanner.nextLine());
            }
            System.out.println("Going to " + destination + "!");
            destination = scanner.nextLine();
        }
    }
}
