package P01_BasicSyntaxLab;

import java.util.Scanner;

public class RefactorOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int oddNum = 2 * i - 1;
            System.out.println(oddNum);
            sum += oddNum;
        }
        System.out.printf("Sum: %d%n", sum);
    }
}