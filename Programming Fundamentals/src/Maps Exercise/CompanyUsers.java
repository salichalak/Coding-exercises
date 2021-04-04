package P21_MapsExercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> companies = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("->");

            for (int i = 0; i < tokens.length; i++) {
                tokens[i] = tokens[i].trim();
            }

            String company = tokens[0];
            String id = tokens[1];

            if (!companies.containsKey(company)) {
                companies.put(company, new ArrayList<String>());
            }
            if (companies.containsKey(company) && !companies.get(company).contains(id)) {
                companies.get(company).add(id);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, ArrayList<String>> entry : companies.entrySet()) {
            System.out.println(entry.getKey());
            for (String ids : entry.getValue()) {
                System.out.println("-- " + ids);
            }
        }

    }
}