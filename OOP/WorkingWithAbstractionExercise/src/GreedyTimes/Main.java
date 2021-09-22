
package GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] itemsAndQuantity = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long stones = 0;
        long money = 0;

        getInput(bagCapacity, itemsAndQuantity, bag, gold, stones, money);

        for (var entry : bag.entrySet()) {
            Long sumValues = entry.getValue().values().stream().mapToLong(l -> l).sum();
            System.out.printf("<%s> $%s%n", entry.getKey(), sumValues);

            entry.getValue()
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(e ->
                    System.out.println("##" + e.getKey() + " - " + e.getValue()));
        }
    }

    private static void getInput(long capacityBag, String[] itemsAndQuantity, LinkedHashMap<String, LinkedHashMap<String, Long>> bag, long gold, long stones, long money) {
        for (int i = 0; i < itemsAndQuantity.length; i += 2) {
            String name = itemsAndQuantity[i];
            long quantity = Long.parseLong(itemsAndQuantity[i + 1]);

            String input = "";

            if (name.length() == 3) {
                input = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                input = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                input = "Gold";
            }

            long totalItemsCapacity = bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + quantity;

            if (input.equals("") || capacityBag < totalItemsCapacity) {
                continue;
            }

            switch (input) {
                case "Gem":
                    if (!bag.containsKey(input)) {
                        if (bag.containsKey("Gold")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(input).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(input)) {
                        if (bag.containsKey("Gem")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(input).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            bag.putIfAbsent(input, new LinkedHashMap<>());

            if (!bag.get(input).containsKey(name)) {
                bag.get(input).put(name, 0L);
            }

            bag.get(input).put(name, bag.get(input).get(name) + quantity);

            switch (input) {
                case "Gold":
                    gold += quantity;
                    break;
                case "Gem":
                    stones += quantity;
                    break;
                case "Cash":
                    money += quantity;
                    break;
            }
        }
    }
}