package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();
        String input = "";

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            switch (tokens[0]) {
                case "1":
                    stack.push(input);
                    input += tokens[1];
                    break;
                case "2":
                    stack.push(input);
                    int count = Integer.parseInt(tokens[1]);
                    input = input.substring(0, input.length() - count);
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(input.charAt(index - 1));
                    break;
                case "4":
                    input = stack.pop();
                    break;
            }
        }

    }
}