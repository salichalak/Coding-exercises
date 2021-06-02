package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, names);

        int n = Integer.parseInt(scanner.nextLine());
        int round = 1;

        while (children.size() > 1) {
            for (int i = 0; i < n - 1; i++) {
                String currentChild = children.poll();
                children.offer(currentChild);
            }

            if (isPrime(round)) {
                String child = children.peek();
                System.out.println("Prime " + child);
            } else {
                String child = children.poll();
                System.out.println("Removed " + child);
            }
            round++;
        }

        String lastChild = children.poll();
        System.out.println("Last is " + lastChild);
    }

    private static boolean isPrime(int round) {
        if (round == 1) {
            return false;
        }

        for (int i = 2; i < round; i++) {
            if (round % i == 0) {
                return false;
            }
        }
        return true;
    }
}