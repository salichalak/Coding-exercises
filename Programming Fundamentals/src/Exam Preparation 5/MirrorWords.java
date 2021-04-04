package P30_ExamPreparation5;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> mirrorPairs = new LinkedHashMap<>();

        String regex = "([@|#])(?<one>[A-Za-z]{3,})\\1\\1(?<two>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int count = 0;

        while (matcher.find()) {
            count++;
            String firstWord = matcher.group("one");
            String secondWord = matcher.group("two");
            String reverseSecond = new StringBuilder(secondWord).reverse().toString();

            if (reverseSecond.equals(firstWord)) {
                mirrorPairs.put(firstWord, secondWord);
            }
        }

        if (count > 0) {
            System.out.println(count + " word pairs found!");
        } else {
            System.out.println("No word pairs found!");
        }

        if (mirrorPairs.size() > 0) {
            System.out.println("The mirror words are:");
            int[] counter = {1};
            mirrorPairs
                    .forEach((key, value) -> {
                        System.out.printf("%s <=> %s", key, value);
                        if (counter[0] < mirrorPairs.size()) {
                            System.out.print(", ");
                        }
                        counter[0]++;
                    });
        } else {
            System.out.println("No mirror words!");
        }

    }
}