package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, data);

        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String operand = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            if ("+".equals(operand)) {
                stack.push(String.valueOf(firstNum + secondNum));
            } else if ("-".equals(operand)) {
                stack.push(String.valueOf(firstNum - secondNum));
            }
        }
        System.out.println(stack.pop());
    }
}