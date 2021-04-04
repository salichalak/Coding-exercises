package P11_MethodsExercise;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());
        int sum = sumFirstTwoIntegers(number1, number2);
        subtractThirdFromResult(sum, number3);
    }

    private static int sumFirstTwoIntegers(int number1, int number2) {
        return number1 + number2;
    }

    private static void subtractThirdFromResult(int sum, int number3) {
        System.out.println(sum - number3);
    }
}