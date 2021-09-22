package FirstSteps;

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double depositSum = Double.parseDouble(scanner.nextLine());
        int depositPeriod = Integer.parseInt(scanner.nextLine());
        double annualInterestRate = Double.parseDouble(scanner.nextLine());

        double totalSum = depositSum + depositPeriod * ((depositSum * annualInterestRate / 100) / 12);
        System.out.println(totalSum);
    }
}