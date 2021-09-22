package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Double, Integer> occurrences = new LinkedHashMap<>();
        double[] values = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        for (double value : values) {
            if (occurrences.containsKey(value)) {
                occurrences.put(value, occurrences.get(value) + 1);
            } else {
                occurrences.put(value, 1);
            }
        }

        for (Double key : occurrences.keySet()) {
            System.out.println(key + " -> " + occurrences.get(key));
        }
    }
}