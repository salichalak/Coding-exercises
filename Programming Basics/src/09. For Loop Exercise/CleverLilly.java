package ForLoop;

import java.util.Scanner;

public class CleverLilly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double wash = Double.parseDouble(scanner.nextLine());
        int price = Integer.parseInt(scanner.nextLine());

        int toys = 0;
        int cash = 0;
        int even = 0;

        for (int i = 1; i <= age; i++) {

            if (i % 2 == 0) {
                cash += 5 * i;
                even++;
            } else {
                toys++;
            }
        }

        int c = cash + (toys * price) - even;

        if (c >= wash) {
            System.out.printf("Yes! %.2f", (double) (c - wash));
        } else {
            System.out.printf("No! %.2f", (double) (wash - c));
        }
    }
}

