package P16_MidExam1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> journal = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String item = tokens[1];
            int index = journal.indexOf(item);

            switch (command) {
                case "Collect":
                    if (index < 0) {
                        journal.add(item);
                    }
                    break;
                case "Drop":
                    if (index >= 0 && index < journal.size()) {
                        journal.remove(item);
                    }
                    break;
                case "Combine Items":
                    String[] splitCombine = item.split(":");
                    String oldItem = splitCombine[0];
                    String newItem = splitCombine[1];
                    index = journal.indexOf(oldItem) + 1;
                    if (journal.contains(oldItem)) {
                        journal.add(index, newItem);
                    }
                    break;
                case "Renew":
                    if (journal.contains(item) && index >= 0 && index < journal.size()) {
                        journal.remove(item);
                        journal.add(item);
                    }
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println(journal.toString().replaceAll("[\\[\\]]", ""));
    }
}