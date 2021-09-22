package P29_ExamPreparation4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "(=|\\/)(?<destination>[A-Z][A-z]{2,})(\\1)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        StringBuilder output = new StringBuilder();
        output.append("Destinations: ");
        String delimeter = "";
        int sum = 0;

        while (matcher.find()) {
            String destination = matcher.group("destination");
            output.append(delimeter);
            output.append(destination);
            delimeter = ", ";
            sum += destination.length();
        }

        System.out.println(output);
        System.out.println("Travel Points: " + sum);
    }
}