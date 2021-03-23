package WhileLoop;

import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int min = Integer.MAX_VALUE;

        while (!"Stop".equals(input)) {
            int sum = Integer.parseInt(input);
            if (sum < min) {
                min = sum;
            }
            input = scanner.nextLine();
        }
        System.out.println(min);
    }
}
