package StacksAndQueuesLab;

import java.util.*;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, names);

        int n = Integer.parseInt(scanner.nextLine());


        while (children.size() > 1) {
            for (int i = 0; i < n - 1; i++) {
                String currentChild = children.poll();
                children.offer(currentChild);
            }

            String childToRemove = children.poll();
            System.out.println("Removed " + childToRemove);
        }

        String lastChild = children.poll();
        System.out.println("Last is " + lastChild);
    }
}