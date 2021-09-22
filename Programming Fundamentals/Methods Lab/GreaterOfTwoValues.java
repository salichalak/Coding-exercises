package P10_MethodsLab;

import java.awt.*;
import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();

        switch (type) {
            case "int":
                int firstNum = Integer.parseInt(scanner.nextLine());
                int secondNum = Integer.parseInt(scanner.nextLine());
                int maxInt = getMax(firstNum, secondNum);
                System.out.println(maxInt);
                break;
            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);
                char biggerChar = getMax(firstChar, secondChar);
                System.out.println(biggerChar);
                break;
            case "string":
                String firstString = scanner.nextLine();
                String secondString = scanner.nextLine();
                String longerString = getMax(firstString, secondString);
                System.out.println(longerString);
                break;
        }
    }


    private static int getMax(int firstNum, int secondNum) {
        if (firstNum > secondNum) {
            return firstNum;
        }
        return secondNum;
    }

    private static char getMax(char firstChar, char secondChar) {
        if (firstChar > secondChar) {
            return firstChar;
        }
        return secondChar;
    }

    private static String getMax(String firstString, String secondString) {
        int first1 = firstString.compareTo(secondString);
        if (first1 >= 0) {
            return firstString;
        }
        return secondString;
    }
}