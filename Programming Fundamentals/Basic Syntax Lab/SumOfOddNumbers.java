package P01_BasicSyntaxLab;

import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int oddNumbersCount = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int currentNum = 1;

        for (int i = 0; i < oddNumbersCount; i++) {
            System.out.println(currentNum);
            sum += currentNum;
            currentNum += 2;
        }
        System.out.println("Sum: " + sum);
    }
}
