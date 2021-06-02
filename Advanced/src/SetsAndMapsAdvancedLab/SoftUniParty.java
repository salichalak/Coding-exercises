package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();

        String guestID = scanner.nextLine();
        while (!guestID.equals("PARTY")) {
            if (Character.isDigit(guestID.charAt(0))) {
                vip.add(guestID);
            } else {
                regular.add(guestID);
            }

            guestID = scanner.nextLine();
        }

        guestID = scanner.nextLine();
        while (!guestID.equals("END")) {
            if (vip.contains(guestID)) {
                vip.remove(guestID);
            } else {
                regular.remove(guestID);
            }

            guestID = scanner.nextLine();
        }

        System.out.println(vip.size() + regular.size());
        for (String vipGuest : vip) {
            System.out.println(vipGuest);
        }

        for (String regularGuest : regular) {
            System.out.println(regularGuest);
        }
    }
}