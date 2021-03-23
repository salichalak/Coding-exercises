package FirstStepsLab;

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double deposit = Double.parseDouble(scanner.nextLine());
        int period = Integer.parseInt(scanner.nextLine());
        double annualRate = Double.parseDouble(scanner.nextLine());

        double interest = deposit * annualRate / 100;
        double interestOneMonth = interest / 12;
        double totalSum = deposit + (period * interestOneMonth);

        System.out.println(totalSum);
    }
}
