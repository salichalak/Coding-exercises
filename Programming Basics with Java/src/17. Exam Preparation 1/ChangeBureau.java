package Exam28and29March;

import java.util.Scanner;

public class ChangeBureau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bitcoin = Integer.parseInt(scanner.nextLine());
        double yuan = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        double allEuro = (yuan * 0.15 * 1.76 + bitcoin * 1168) / 1.95;
        double charge = allEuro * (commission * 0.01);
        double profit = allEuro - charge;
        System.out.printf("%.2f", profit);
    }
}