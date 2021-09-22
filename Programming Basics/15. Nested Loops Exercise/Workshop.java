package FirstStepsLab;

import java.util.Scanner;

public class Workshop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tables = Integer.parseInt(scanner.nextLine());
        double tableLength = Double.parseDouble(scanner.nextLine());
        double tableWidth = Double.parseDouble(scanner.nextLine());

        double coverTotalArea = tables * (tableLength + 2 * 0.30) * (tableWidth + 2 * 0.30);
        double squareTotalArea = tables * (tableLength /2 ) * (tableLength / 2);

        double totalSumDollars = coverTotalArea * 7 + squareTotalArea * 9;
        double totalSumLev = totalSumDollars * 1.85;

        System.out.printf("%.2f USD%n", totalSumDollars);
        System.out.printf("%.2f BGN", totalSumLev);
    }
}
