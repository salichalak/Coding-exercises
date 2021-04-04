package P13_ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationsAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Contains":
                    int contains = Integer.parseInt(tokens[1]);

                    if (listOfNumbers.contains(contains)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (tokens[1].equals("even")) {
                        for (int i = 0; i < listOfNumbers.size(); i++) {
                            if (listOfNumbers.get(i) % 2 == 0) {
                                System.out.print(listOfNumbers.get(i) + " ");
                            }
                        }

                    } else if (tokens[1].equals("odd")) {
                        for (int i = 0; i < listOfNumbers.size(); i++) {
                            if (listOfNumbers.get(i) % 2 != 0) {
                                System.out.print(listOfNumbers.get(i) + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;
                case "Get":
                    int sum = 0;
                    for (Integer number : listOfNumbers) {
                        sum += number;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String outputFilter = "";
                    int num = Integer.parseInt(tokens[2]);

                    if (tokens[1].equals("<")) {
                        for (Integer aList : listOfNumbers) {
                            if (aList < num) {
                                outputFilter += String.valueOf(aList) + " ";

                            }
                        }
                        System.out.println(outputFilter);
                    } else if (tokens[1].equals(">")) {
                        for (Integer aList : listOfNumbers) {
                            if (aList > num) {
                                outputFilter += String.valueOf(aList) + " ";

                            }
                        }
                        System.out.println(outputFilter);
                    } else if (tokens[1].equals(">=")) {
                        for (Integer aList : listOfNumbers) {
                            if (aList >= num) {
                                outputFilter += String.valueOf(aList) + " ";

                            }
                        }
                        System.out.println(outputFilter);
                    } else if (tokens[1].equals("<=")) {
                        for (Integer aList : listOfNumbers) {
                            if (aList <= num) {
                                outputFilter += String.valueOf(aList) + " ";

                            }
                        }
                        System.out.println(outputFilter);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}