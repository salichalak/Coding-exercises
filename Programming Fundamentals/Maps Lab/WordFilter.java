package P20_MapsLab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = Arrays.stream(scanner.nextLine().split(" "))
                .filter(w -> w.length() % 2 == 0)
                .toArray(e -> new String[e]);

        for (String word : words) {
            System.out.println(word);
        }

    }
}