package P26_ExamPreparation1;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String instructions = scanner.nextLine();

        while (!instructions.equals("Generate")) {
            String[] tokens = instructions.split(">>>");
            String command = tokens[0];

            switch (command) {
                case "Contains":
                    String subString = tokens[1];

                    if (key.contains(subString)) {
                        System.out.printf("%s contains %s%n", key, subString);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;

                case "Flip":
                    String upperOrLower = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    String modified = key.substring(startIndex, endIndex);

                    if (upperOrLower.equals("Upper")) {
                        modified = modified.toUpperCase();
                        StringBuilder sb = new StringBuilder();
                        sb.append(key);
                        sb.replace(startIndex, endIndex, modified);
                        key = sb.toString();
                    } else {
                        modified = modified.toLowerCase();
                        StringBuilder sb = new StringBuilder();
                        sb.append(key);
                        sb.replace(startIndex, endIndex, modified);
                        key = sb.toString();

                    }
                    System.out.println(key);
                    break;

                case "Slice":
                    int sliceBeginIndex = Integer.parseInt(tokens[1]);
                    int sliceEndIndex = Integer.parseInt(tokens[2]);

                    StringBuilder deleter = new StringBuilder();
                    deleter.append(key);
                    deleter.replace(sliceBeginIndex, sliceEndIndex, "");
                    key = deleter.toString();

                    System.out.println(key);
                    break;
                default:
                    System.out.println("wrong input!!!");
            }
            instructions = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", key);

    }
}