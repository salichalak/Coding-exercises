package P08_ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int countRotations = Integer.parseInt(scanner.nextLine());

        for (int rotation = 0; rotation < countRotations; rotation++) {
            int firstNumber = numbers[0];
            for (int index = 0; index < numbers.length - 1; index++) {
                numbers[index] = numbers[index + 1];
            }
            numbers[numbers.length - 1] = firstNumber;
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}