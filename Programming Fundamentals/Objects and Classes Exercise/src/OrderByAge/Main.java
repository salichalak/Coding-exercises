package OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String name = tokens[0];
            String ID = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            Person person = new Person(name, ID, age);
            people.add(person);

            input = scanner.nextLine();
        }

        List<Person> sortedList = people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());

        for (Person person : sortedList) {
            System.out.println(person);
        }
    }
}