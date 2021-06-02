package SetsAndMapsAdvancedExercise;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        TreeSet<String> chemicalElements = new TreeSet<>();

        for (int i = 1; i <= count; i++) {
            String compound = scanner.nextLine();
            String[] elements = compound.split("\\s+");

            Collections.addAll(chemicalElements, elements);
        }

        chemicalElements.forEach(element -> System.out.print(element + " "));
    }
}