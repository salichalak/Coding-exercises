package Exercise01;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random randomizer = new Random();
        String[] words = scanner.nextLine().split(" ");

        for (int index = 0; index < words.length; index++) {
            int randomIndex = randomizer.nextInt(words.length);

            String swap = words[randomIndex];
            words[randomIndex] = words[index];
            words[index] = swap;
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}