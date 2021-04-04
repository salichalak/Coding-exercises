package P10_MethodsLab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int multiplyOfEvensAndOdds = getMultipleOfEvenAndOdds(Math.abs(number));
        System.out.println(multiplyOfEvensAndOdds);
    }

    private static int getSumOfEvenNumbers(int number) {
        int evenSum = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                evenSum += digit;
            }
            number = number / 10;
        }
        return evenSum;
    }

    private static int getSumOfOddNumbers(int number) {
        int oddSum = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 != 0) {
                oddSum += digit;
            }
            number = number / 10;
        }
        return oddSum;
    }

    private static int getMultipleOfEvenAndOdds(int number) {
        int evenSum = getSumOfEvenNumbers(number);
        int oddSum = getSumOfOddNumbers(number);
        return evenSum * oddSum;
    }
}