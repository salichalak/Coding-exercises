package FinalExam;

import java.util.*;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;

public class Exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> heroesHealth = new TreeMap<>();
        Map<String, Integer> heroesEnergy = new HashMap<>();

        while (!input.equals("Results")) {
            String[] tokens = input.split(":");
            String commandName = tokens[0];

            switch (commandName) {
                case "Add":
                    String person = tokens[1];
                    int health = Integer.parseInt(tokens[2]);
                    int energy = Integer.parseInt(tokens[3]);

                    if (!heroesHealth.containsKey(person)) {
                        heroesHealth.put(person, health);
                        heroesEnergy.put(person, energy);
                    } else {
                        int currentHealth = heroesHealth.get(person);
                        heroesHealth.put(person, currentHealth + health);
                        int currentEnergy = heroesEnergy.get(person);
                        heroesEnergy.put(person, currentEnergy + energy);
                    }
                    break;

                case "Attack":
                    String attackerName = tokens[1];
                    String defenderName = tokens[2];
                    int damage = Integer.parseInt(tokens[3]);

                    if (heroesEnergy.containsKey(attackerName) && heroesHealth.containsKey(defenderName)) {
                        int newHealth = heroesHealth.get(defenderName) - damage;
                        int newEnergy = heroesEnergy.get(attackerName) - 1;
                        heroesHealth.replace(defenderName, newHealth);
                        heroesEnergy.replace(attackerName, newEnergy);

                        if (newHealth <= 0) {
                            System.out.println(defenderName + " was disqualified!");
                            heroesHealth.remove(defenderName);
                            heroesEnergy.remove(defenderName);
                        }

                        if (newEnergy <= 0) {
                            System.out.println(attackerName + " was disqualified!");
                            heroesHealth.remove(attackerName);
                            heroesEnergy.remove(attackerName);
                        }
                    }
                    break;

                case "Delete":
                    String username = tokens[1];
                    if (username.equals("All")) {
                        heroesHealth.clear();
                        heroesEnergy.clear();
                    } else {
                        heroesHealth.remove(username);
                        heroesEnergy.remove(username);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println("People count: " + heroesHealth.size());
        heroesHealth
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .forEach(hero -> {
                    String name = hero.getKey();
                    int health = heroesHealth.get(name);
                    int energy = heroesEnergy.get(name);
                    System.out.printf("%s - %d - %d%n", name, health, energy);
                });


    }
}