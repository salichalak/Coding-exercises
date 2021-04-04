package P10_MethodsLab;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNum = Integer.parseInt(scanner.nextLine());
        double result = 0;

        switch (operator) {
            case "/":
                result = divideNumbers(firstNum, secondNum);
                break;
            case "*":
                result = multiplyNumbers(firstNum, secondNum);
                break;
            case "+":
                result = addNumbers(firstNum, secondNum);
                break;
            case "-":
                result = subtractNumbers(firstNum, secondNum);
                break;
        }
        System.out.printf("%.0f", result);
    }

    private static int subtractNumbers(int firstNum, int secondNum) {
        int result = firstNum - secondNum;
        return result;
    }

    private static int addNumbers(int firstNum, int secondNum) {
        int result = firstNum + secondNum;
        return result;
    }

    private static int multiplyNumbers(int firstNum, int secondNum) {
        int result = firstNum * secondNum;
        return result;
    }

    private static double divideNumbers(int firstNum, int secondNum) {
        double result = 1.0 * firstNum / secondNum;
        return result;
    }
}