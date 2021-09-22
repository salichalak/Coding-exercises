package OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            if (age > 30) {
                Person person = new Person(name, age);
                people.add(person);
            }

        }

        people.sort(Comparator.comparing(Person::getName));
        for (Person person : people) {
            System.out.println(person);
        }
    }
}