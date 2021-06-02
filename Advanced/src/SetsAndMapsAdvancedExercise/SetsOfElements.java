package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>(n);
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>(m);

        fillSets(scanner, n, m, firstSet, secondSet);

        firstSet.retainAll(secondSet);

        for (Integer number : firstSet) {
            System.out.print(number + " ");
        }
    }

    private static void fillSets(Scanner scanner, int n, int m,
                                 LinkedHashSet<Integer> firstSet, LinkedHashSet<Integer> secondSet) {
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        for (int j = 0; j < m; j++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }
    }
}