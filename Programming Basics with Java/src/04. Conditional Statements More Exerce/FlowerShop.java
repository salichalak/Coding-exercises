package ConditionalStatementsLab2;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int magnolias = Integer.parseInt(scanner.nextLine());
        int hyacinths = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int cactus = Integer.parseInt(scanner.nextLine());
        double giftPrice = Double.parseDouble(scanner.nextLine());

        double totalSum = magnolias * 3.25 + hyacinths * 4.0 + roses * 3.50 + cactus * 8;
        double taxes = totalSum * 0.05;
        double profit = totalSum - taxes;

        if (giftPrice > profit) {
            double moneyNeeded = giftPrice - profit;
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(moneyNeeded));
        } else if (giftPrice <= profit) {
            double moneyLeft = profit - giftPrice;
            System.out.printf("She is left with %.0f leva.", Math.floor(moneyLeft));
        }
    }
}
