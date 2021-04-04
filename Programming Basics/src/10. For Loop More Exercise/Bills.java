package ForLoopLab2;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double waterBill = 20;
        double internetBill = 15;
        double otherBill = 0;
        double electricityBill = 0;
        double electricityTotal = 0;

        int months = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= months; i++) {
            electricityBill = Double.parseDouble(scanner.nextLine());
            electricityTotal += electricityBill;

            otherBill += (waterBill + internetBill + electricityBill) * 1.2;
        }
        double waterTotal = waterBill * months;
        double internetTotal = internetBill * months;
        double average = (electricityTotal + waterTotal + internetTotal + otherBill) / months;

        System.out.printf("Electricity: %.2f lv%n", electricityTotal);
        System.out.printf("Water: %.2f lv%n", waterTotal);
        System.out.printf("Internet: %.2f lv%n", internetTotal);
        System.out.printf("Other: %.2f lv%n", otherBill);
        System.out.printf("Average: %.2f lv%n", average);
    }
}