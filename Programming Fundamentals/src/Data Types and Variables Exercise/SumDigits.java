package P05_DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int number = n;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int lastDigit = number % 10;
            sum += lastDigit;
            number = number / 10;
        }
        System.out.println(sum);
    }
}