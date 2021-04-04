package P01_BasicSyntaxLab;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int times = 1; times <= 10; times++) {
            int product = number * times;
            System.out.printf("%d X %d = %d%n", number, times, product);
        }
    }
}