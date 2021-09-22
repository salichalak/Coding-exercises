package Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scn.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        List<String> links = Arrays.stream(scn.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Smartphone smartphone = new Smartphone(numbers, links);

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());
    }
}