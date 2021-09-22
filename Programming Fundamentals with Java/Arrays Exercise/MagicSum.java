package P08_ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int sum = Integer.parseInt(scanner.nextLine());

        for (int index = 0; index < numbers.length; index++) {
            int number1 = numbers[index];
            for (int i = index + 1; i < numbers.length; i++) {
                int number2 = numbers[i];
                if (number1 + number2 == sum) {
                    System.out.printf("%d %d %n", number1, number2);
                }
            }
        }
    }
}