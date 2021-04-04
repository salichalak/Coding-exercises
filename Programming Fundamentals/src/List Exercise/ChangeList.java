package P14_ListsExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String command = input.split("\\s+")[0];
            int element = Integer.parseInt(input.split("\\s+")[1]);

            if (command.equals("Delete")) {
                numbers.removeAll(Arrays.asList(element));
            } else if (command.equals("Insert")) {
                int index = Integer.parseInt(input.split("\\s+")[2]);
                numbers.add(index, element);
            }
            input = scanner.nextLine();
        }

        printList(numbers);
    }
    private static void printList(List<Integer> numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}