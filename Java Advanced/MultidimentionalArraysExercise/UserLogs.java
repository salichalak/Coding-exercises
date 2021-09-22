package MultidimentionalArraysExercise;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> info = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] data = input.split("\\s+");
            String username = data[2].split("=")[1];
            String ip = data[0].split("=")[1];

            info.putIfAbsent(username, new LinkedHashMap<>());
            info.get(username).putIfAbsent(ip, 0);
            info.get(username).put(ip, info.get(username).get(ip) + 1);


            info.entrySet().stream().
                    forEach(entry -> {
                                System.out.println(entry.getKey() + ": ");
                                int countEntry = entry.getValue().size();
                                for (var ipEntry : entry.getValue().entrySet()) {
                                    if (countEntry > 1) {
                                        System.out.print(ipEntry.getKey() + " => " + ipEntry.getValue() + ", ");
                                    } else {
                                        System.out.print(ipEntry.getKey() + " => " + ipEntry.getValue() + ".");
                                    }
                                    countEntry--;
                                }
                                System.out.println();
                            }
                    );
        }
    }
}