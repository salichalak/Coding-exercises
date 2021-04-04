package WhileLoop;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int max = Integer.MIN_VALUE;

        while (!"Stop".equals(input)) {
            int sum = Integer.parseInt(input);
            if (sum > max) {
                max = sum;
            }
            input = scanner.nextLine();
        }
        System.out.println(max);
    }
}
