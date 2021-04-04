package P23_TextProcessingExercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        char[] firstWord = input[0].toCharArray();
        char[] secondWord = input[1].toCharArray();
        int longestWord = Math.max(firstWord.length, secondWord.length);

        int totalSum = 0;

        for (int i = 0; i < longestWord; i++) {
            if (i < firstWord.length && i < secondWord.length) {
                totalSum += firstWord[i] * secondWord[i];
            } else if (i < firstWord.length && i >= secondWord.length) {
                totalSum += firstWord[i];
            } else if (i >= firstWord.length) {
                totalSum += secondWord[i];
            }
        }

        System.out.println(totalSum);
    }
}