package P27_ExamPreparation2;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> heroesHP = new TreeMap<>();
        Map<String, Integer> heroesMP = new TreeMap<>();
        int heroesCount = Integer.parseInt(scanner.nextLine());

        for (int hero = 1; hero <= heroesCount; hero++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String heroName = tokens[0];
            int hp = Integer.parseInt(tokens[1]);
            int mp = Integer.parseInt(tokens[2]);

            if (hp <= 100) {
                heroesHP.put(heroName, hp);
            }

            if (mp <= 200) {
                heroesMP.put(heroName, mp);
            }
        }


        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split(" - ");
            String commandName = tokens[0];
            String heroName = tokens[1];

            switch (commandName) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    int mpCurrent = heroesMP.get(heroName);
                    if (mpCurrent >= mpNeeded) {
                        int mpLeft = mpCurrent - mpNeeded;
                        heroesMP.put(heroName, mpLeft);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, mpLeft);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    int currentHP = heroesHP.get(heroName) - damage;
                    if (currentHP > 0) {
                        heroesHP.put(heroName, currentHP);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHP);
                    } else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroesHP.remove(heroName);
                        heroesMP.remove(heroName);
                    }
                    break;
                case "Recharge":
                    int amountIncrease = Integer.parseInt(tokens[2]);
                    int currentMp = heroesMP.get(heroName);
                    int increasedMp = currentMp + amountIncrease;
                    if (increasedMp > 200) {
                        increasedMp = 200;
                    }
                    heroesMP.put(heroName, increasedMp);
                    System.out.printf("%s recharged for %d MP!%n", heroName, increasedMp - currentMp);
                    break;
                case "Heal":
                    int amountHeal = Integer.parseInt(tokens[2]);
                    int currentHp = heroesHP.get(heroName);
                    int increasedHp = currentHp + amountHeal;
                    if (increasedHp > 100) {
                        increasedHp = 100;
                    }
                    heroesHP.put(heroName, increasedHp);
                    System.out.printf("%s healed for %d HP!%n", heroName, increasedHp - currentHp);
                    break;
            }

            command = scanner.nextLine();
        }

        heroesHP.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(e -> {
                    String heroName = e.getKey();
                    System.out.println(heroName);
                    System.out.println("  HP: " + e.getValue());
                    System.out.println("  MP: " + heroesMP.get(heroName));
                });
    }
}