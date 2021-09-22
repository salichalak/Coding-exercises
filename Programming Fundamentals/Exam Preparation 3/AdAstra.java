package P28_ExamPreparation3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int totalCalories = 0;
        int days = 0;

        List<String> itemNames = new ArrayList<>();
        List<String> expirationDates = new ArrayList<>();
        List<Integer> itemCalories = new ArrayList<>();

        Pattern pattern = Pattern.compile("(#|\\|)(?<itemName>[A-Za-z ]+)\\1(?<expirationDate>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String itemName = matcher.group("itemName");
            String expirationDate = matcher.group("expirationDate");
            int currentCalories = Integer.parseInt(matcher.group("calories"));
            totalCalories += currentCalories;
            days = totalCalories / 2000;

            itemNames.add(itemName);
            expirationDates.add(expirationDate);
            itemCalories.add(currentCalories);
        }

        System.out.printf("You have food to last you for: %d days!%n", days);

        for (int i = 0; i < itemNames.size(); i++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n", itemNames.get(i), expirationDates.get(i), itemCalories.get(i));
        }

    }
}