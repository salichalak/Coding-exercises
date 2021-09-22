package P25_RegexExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        Map<String, List<Double>> demonsInfo = new TreeMap<>();

        String regexDamage = "[+-]?\\d+\\.?\\d*";
        double damage = 0;

        String regexHealth = "[^0-9*/+\\-.]";
        double health = 0;


        for (int i = 0; i < input.length; i++) {
            String demon = input[i].replaceAll(" ", "");

            Pattern patternHealth = Pattern.compile(regexHealth);
            Matcher matcherHealth = patternHealth.matcher(demon);

            int multiplyCount = 0;
            int divideCount = 0;

            for (int j = 0; j < demon.length(); j++) {
                if ((char) demon.charAt(j) == '*') {
                    multiplyCount++;
                } else if ((char) demon.charAt(j) == '/') {
                    divideCount++;
                }
            }

            while (matcherHealth.find()) {
                health += matcherHealth.group().charAt(0);
            }

            Pattern patternDamage = Pattern.compile(regexDamage);
            Matcher matcherDamage = patternDamage.matcher(demon);

            while (matcherDamage.find()) {
                damage += Double.parseDouble(matcherDamage.group());
            }

            for (int k = 0; k < divideCount; k++) {
                damage /= 2;
            }

            for (int l = 0; l < multiplyCount; l++) {
                damage *= 2;
            }

            List<Double> healthDamage = new ArrayList<>();
            healthDamage.add(health);
            healthDamage.add(damage);
            demonsInfo.put(demon, healthDamage);

            health = 0;
            damage = 0;
        }

        for (Map.Entry<String, List<Double>> entry : demonsInfo.entrySet()) {
            System.out.printf("%s - %.0f health, %.2f damage%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }

    }
}