package P14_ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine()
                .split(", ")).collect(Collectors.toList());


        String command = scanner.nextLine();

        while (!command.equals("course start")) {
            String[] tokens = command.split(":");
            String option = tokens[0];
            String title = tokens[1];
            String exerciseTitle = title + "-" + "Exercise";

            if (option.equals("Add")) {
                if (!schedule.contains(title)) {
                    schedule.add(title);
                }
            } else if (option.equals("Insert")) {
                if (!schedule.contains(title)) {
                    schedule.add(Integer.parseInt(tokens[2]), title);
                }
            } else if (option.equals("Remove")) {
                schedule.remove(title);
                if (schedule.contains(exerciseTitle)) {
                    schedule.remove(exerciseTitle);
                }


            } else if (option.equals("Swap")) {
                if (schedule.contains(tokens[1]) && schedule.contains(tokens[2])) {
                    int indexFirst = schedule.indexOf(tokens[1]);
                    int indexSecond = schedule.indexOf(tokens[2]);
                    String firstExercise = tokens[1] + "-Exercise";
                    String secondExercise = tokens[2] + "-Exercise";
                    schedule.set(indexFirst, tokens[2]);
                    schedule.set(indexSecond, tokens[1]);

                    if (schedule.contains(secondExercise)) {
                        schedule.remove(secondExercise);
                        schedule.add(schedule.indexOf(tokens[2]) + 1, secondExercise);
                    }
                    if (schedule.contains(firstExercise)) {
                        schedule.remove(firstExercise);
                        schedule.add(schedule.indexOf(tokens[1]) + 1, firstExercise);
                    }

                }
            } else if (option.equals("Exercise")) {

                if (schedule.contains(title) && !schedule.contains(exerciseTitle)) {
                    schedule.add(schedule.indexOf(title) + 1, exerciseTitle);
                } else if (!schedule.contains(title)) {
                    schedule.add(title);
                    schedule.add(exerciseTitle);
                }

            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < schedule.size(); i++) {
            System.out.println(i + 1 + "." + schedule.get(i));
        }
    }
}