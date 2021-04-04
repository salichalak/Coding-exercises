package P16_MidExam1;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoins = 0;
        boolean isDead = false;

        String[] rooms = scanner.nextLine().split("\\|");

        for (int i = 0; i < rooms.length; i++) {
            String[] currentRoom = rooms[i].split(" ");
            String command = currentRoom[0];
            int number = Integer.parseInt(currentRoom[1]);

            if (command.contains("potion")) {
                int healthNeeded = 100 - health;
                health += number;

                if (health > 100) {
                    health = 100;
                }

                if (healthNeeded <= number) {
                    System.out.printf("You healed for %d hp.%n", healthNeeded);
                } else {
                    System.out.printf("You healed for %d hp.%n", number);
                }

                System.out.printf("Current health: %d hp.%n", health);

            } else if (command.contains("chest")) {
                bitcoins += number;
                System.out.printf("You found %d bitcoins.%n", number);

            } else {
                health -= number;

                if (health > 0) {
                    System.out.printf("You slayed %s.%n", command);
                } else {
                    System.out.printf("You died! Killed by %s.%n", command);
                    System.out.printf("Best room: %d", i + 1);
                    isDead = true;
                    break;
                }
            }
        }

        if (!isDead) {
            System.out.println("You've made it!");
            System.out.println("Bitcoins: " + bitcoins);
            System.out.println("Health: " + health);
        }
    }
}