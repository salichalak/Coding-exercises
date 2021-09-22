package P19_MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> friendsList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        int blacklisted = 0;
        int lost = 0;

        String input = "";

        while (!(input = scanner.nextLine()).equals("Report")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Blacklist":
                    String name = tokens[1];
                    if (!friendsList.contains(name)) {
                        System.out.printf("%s was not found.%n", name);
                    } else {
                        for (int i = 0; i < friendsList.size(); i++) {
                            String currentName = friendsList.get(i);
                            if (currentName.equals(name)) {
                                System.out.printf("%s was blacklisted.%n", currentName);
                                friendsList.set(i, "Blacklisted");
                                blacklisted++;
                            }
                        }
                    }
                    break;

                case "Error":
                    int errorIndex = Integer.parseInt(tokens[1]);
                    if (!friendsList.get(errorIndex).equals("Blacklisted") && !friendsList.get(errorIndex).equals("Lost")) {
                        System.out.printf("%s was lost due to an error.%n", friendsList.get(errorIndex));
                        friendsList.set(errorIndex, "Lost");
                        lost++;
                    }
                    break;

                case "Change":
                    int indexToChange = Integer.parseInt(tokens[1]);
                    String newName = tokens[2];
                    if (indexToChange >= 0 && indexToChange < friendsList.size()) {
                        System.out.printf("%s changed his username to %s.%n", friendsList.get(indexToChange), newName);
                        friendsList.set(indexToChange, newName);
                    }
                    break;

                default:
                    break;
            }
        }

        System.out.printf("Blacklisted names: %d%n", blacklisted);
        System.out.printf("Lost names: %d%n", lost);

        for (String username : friendsList) {
            System.out.print(username + " ");
        }

    }
}