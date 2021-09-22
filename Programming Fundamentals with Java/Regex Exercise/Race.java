package P25_RegexExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regexName = "[A-Za-z]+";
        String regexDistance = "[0-9]";
        Pattern patternName = Pattern.compile(regexName);
        Pattern patternDistance = Pattern.compile(regexDistance);

        List<String> racers = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> racersDistances = new LinkedHashMap<>();

        racers.forEach(racer -> racersDistances.put(racer, 0));
        String input = scanner.nextLine();

        while (!input.equals("end of race")) {

            Matcher matcherName = patternName.matcher(input);
            StringBuilder nameBuilder = new StringBuilder();
            while (matcherName.find()) {
                nameBuilder.append(matcherName.group());
            }
            String name = nameBuilder.toString();

            int distance = 0;

            Matcher matcherDistance = patternDistance.matcher(input);
            while (matcherDistance.find()) {
                distance += Integer.parseInt(matcherDistance.group());
            }

            if (racersDistances.containsKey(name)) {
                racersDistances.put(name, racersDistances.get(name) + distance);
            }

            input = scanner.nextLine();
        }

        List<String> firstThree = racersDistances.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(e -> e.getKey())
                .collect(Collectors.toList());

        System.out.println("1st place: " + firstThree.get(0));
        System.out.println("2nd place: " + firstThree.get(1));
        System.out.println("3rd place: " + firstThree.get(2));
    }
}