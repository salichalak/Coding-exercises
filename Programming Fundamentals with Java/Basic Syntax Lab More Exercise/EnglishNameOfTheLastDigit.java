package P03_BasicSyntaxLabMoreExercise;

import java.util.Scanner;

public class EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String digitName = "";

        if (number % 10 == 0) {
            digitName = "zero";
        } else if (number % 10 == 1) {
            digitName = "one";
        } else if (number % 10 == 2) {
            digitName = "two";
        } else if (number % 10 == 3) {
            digitName = "three";
        } else if (number % 10 == 4) {
            digitName = "four";
        } else if (number % 10 == 5) {
            digitName = "five";
        } else if (number % 10 == 6) {
            digitName = "six";
        } else if (number % 10 == 7) {
            digitName = "seven";
        } else if (number % 10 == 8) {
            digitName = "eight";
        } else if (number % 10 == 9) {
            digitName = "nine";
        }
        System.out.println(digitName);
    }
}