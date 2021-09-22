package P17_MidExam2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String list = scanner.nextLine();
        String[] splitList = list.split("!");
        List<String> groceries = Arrays.stream(splitList).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String item = tokens[1];

            switch (command) {
                case "Urgent":
                    if (!groceries.contains(item)) {
                        groceries.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    if (groceries.contains(item)) {
                        groceries.remove(item);
                    }
                    break;
                case "Correct":
                    String newItem = tokens[2];
                    for (int i = 0; i < groceries.size(); i++) {
                        if (groceries.get(i).contains(item)) {
                            groceries.set(i, newItem);
                        }
                    }
                    break;
                case "Rearrange":
                    if (groceries.contains(item)) {
                        groceries.remove(item);
                        groceries.add(item);
                    }
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", groceries));
    }
}