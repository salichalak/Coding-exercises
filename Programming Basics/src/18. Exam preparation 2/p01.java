package Test;

import java.util.Scanner;

public class p01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        double entranceTax = Double.parseDouble(scanner.nextLine());
        double sunbedPrice = Double.parseDouble(scanner.nextLine());
        double umbrellaPrice = Double.parseDouble(scanner.nextLine());

        double totalTax = people * entranceTax;
        double sunbedTotalPrice = Math.ceil(people * 0.75) * sunbedPrice;
        double umbrellaTotalPrice = Math.ceil(people * 0.50) * umbrellaPrice;
        double totalPrice = totalTax + sunbedTotalPrice + umbrellaTotalPrice;
        System.out.printf("%.2f lv.", totalPrice);
    }
}
