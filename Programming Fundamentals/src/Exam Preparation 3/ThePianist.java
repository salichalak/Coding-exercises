package P28_ExamPreparation3;

import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> pieces = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String piece = input[0];
            String composer = input[1];
            String key = input[2];
            pieces.put(piece, new ArrayList<>());
            pieces.get(piece).add(composer);
            pieces.get(piece).add(key);
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];
            String piece = tokens[1];

            switch (command) {
                case "Add":
                    String composer = tokens[2];
                    String key = tokens[3];
                    if (pieces.containsKey(piece)) {
                        System.out.println(piece + " is already in the collection!");
                    } else {
                        pieces.put(piece, new ArrayList<>());
                        pieces.get(piece).add(composer);
                        pieces.get(piece).add(key);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;
                case "Remove":
                    if (pieces.containsKey(piece)) {
                        pieces.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = tokens[2];
                    if (pieces.containsKey(piece)) {
                        pieces.get(piece).set(1, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                default:
                    break;
            }

            input = scanner.nextLine();
        }

        pieces.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(kv -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                        kv.getKey(), kv.getValue().get(0), kv.getValue().get(1)));
    }
}