package P11_MethodsExercise;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        getTheSmallestNumber(firstNum, secondNum, thirdNum);
    }

    private static void getTheSmallestNumber(int firstNumber, int secondNumber, int thirdNumber) {
        if (firstNumber <= secondNumber && firstNumber <= thirdNumber) {
            System.out.println(firstNumber);
        } else if (secondNumber <= firstNumber && secondNumber <= thirdNumber) {
            System.out.println(secondNumber);
        } else {
            System.out.println(thirdNumber);
        }
    }
}