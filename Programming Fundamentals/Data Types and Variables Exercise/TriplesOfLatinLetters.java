package P05_DataTypesAndVariablesExercise;

import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (char firstSymbol = 'a'; firstSymbol < 'a' + n; firstSymbol++) {
            for (char secondSymbol = 'a'; secondSymbol < 'a' + n; secondSymbol++) {
                for (char thirdSymbol = 'a'; thirdSymbol < 'a' + n; thirdSymbol++) {
                    System.out.printf("%c%c%c%n", firstSymbol, secondSymbol, thirdSymbol);
                }
            }
        }
    }
}