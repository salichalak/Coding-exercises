package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bracketIndexes = new ArrayDeque<>();
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                bracketIndexes.push(i);
            } else if (input.charAt(i) == ')') {
                int beginIndex = bracketIndexes.pop();
                int endIndex = i + 1;
                String output = input.substring(beginIndex, endIndex);
                System.out.println(output);
            }
        }

    }
}