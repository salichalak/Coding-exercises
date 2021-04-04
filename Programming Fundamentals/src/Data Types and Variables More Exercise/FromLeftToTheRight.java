package P06_DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        long leftNum = 0;
        long rightNum = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            leftNum = scanner.nextLong();
            rightNum = scanner.nextLong();

            if (leftNum < rightNum) {
                sum = 0;
                while (rightNum != 0) {
                    sum += rightNum % 10;
                    rightNum /= 10;

                }
                System.out.println(Math.abs(sum));
            } else {
                sum = 0;
                while (leftNum != 0) {
                    sum += leftNum % 10;
                    leftNum /= 10;

                }
                System.out.println(Math.abs(sum));
            }
        }
    }
}