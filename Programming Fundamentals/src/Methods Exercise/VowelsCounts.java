package P11_MethodsExercise;

import java.util.Locale;
import java.util.Scanner;

public class VowelsCounts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toLowerCase();
        printVowelsCount(text);
    }

    private static void printVowelsCount(String text) {
        int count = 0;
        for (int index = 0; index < text.length(); index++) {
            char currentSymbol = text.charAt(index);

            switch (currentSymbol) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
            }

        }
        System.out.println(count);
    }
}