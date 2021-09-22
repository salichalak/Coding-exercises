package P13_ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstLine = Arrays.stream(scanner.nextLine()
                .split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondLine = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int size = Math.min(firstLine.size(), secondLine.size());

        for (int i = 0; i < size; i++) {
            System.out.print(firstLine.get(i) + " " + secondLine.get(i) + " ");
        }
        printTheRest(firstLine,size);
        printTheRest(secondLine, size);
    }

    private static void printTheRest(List<Integer> numbers, int beginIndex) {
        for (int index = beginIndex; index < numbers.size(); index++) {
            System.out.print(numbers.get(index) + " ");
        }
    }
}