package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (browserHistory.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                }
            } else {
                browserHistory.push(command);
                System.out.println(command);
            }
            command = scanner.nextLine();
        }
    }
}