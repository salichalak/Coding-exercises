package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();

            if (command.equals("2")) {
                stack.pop();
            } else if (command.equals("3")) {
                int maxNumber = Collections.max(stack);
                System.out.println(maxNumber);
            } else if (command.split(" ")[0].equals("1")) {
                int numberToPush = Integer.parseInt(command.split(" ")[1]);
                stack.push(numberToPush);
            }
        }
    }
}