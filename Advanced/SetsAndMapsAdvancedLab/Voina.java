package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = getNumbers(scanner);
        LinkedHashSet<Integer> secondDeck = getNumbers(scanner);
        int round = 1;

        while (round++ <= 50 && !firstDeck.isEmpty() && !secondDeck.isEmpty()) {
            int firstNumber = firstDeck.iterator().next();
            firstDeck.remove(firstNumber);
            int secondNumber = secondDeck.iterator().next();
            secondDeck.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstDeck.add(firstNumber);
                firstDeck.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondDeck.add(firstNumber);
                secondDeck.add(secondNumber);
            }
        }

        if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else if (secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }
    }

    private static LinkedHashSet<Integer> getNumbers(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
    }
}