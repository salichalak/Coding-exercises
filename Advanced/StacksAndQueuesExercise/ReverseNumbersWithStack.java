package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        String input = scanner.nextLine();
        String[] splitInput = input.split(" ");

        for (String element: splitInput) {
            numbers.push(Integer.parseInt(element));
        }

        while (!numbers.isEmpty()) {
            System.out.print(numbers.pop() + " ");
        }
    }
}