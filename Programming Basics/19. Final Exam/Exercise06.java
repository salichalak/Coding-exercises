package Pb_Exam_Online;

import java.util.Scanner;

public class PassengersPerFlight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int airlines = Integer.parseInt(scanner.nextLine());

        String flightWithMaxPassengers = "";
        int maxPassengers = 0;
        int averagePassengersMaxFlight = 0;
        int totalPassengers = 0;
        int flightCounter = 0;

        for (int i = 1; i <= airlines; i++) {
            String company = scanner.nextLine();
            String input = scanner.nextLine();
            totalPassengers = 0;
            flightCounter = 0;

            while (!"Finish".equals(input)) {
                flightCounter++;
                int passengers = Integer.parseInt(input);
                totalPassengers += passengers;

                input = scanner.nextLine();
            }
			
            int average = totalPassengers / flightCounter;
            System.out.printf("%s: %d passengers.%n", company, average);

            if (average > maxPassengers) {
                maxPassengers = totalPassengers / flightCounter;
                flightWithMaxPassengers = company;;
            }
        }
		
        System.out.printf("%s has most passengers per flight: %d", flightWithMaxPassengers, maxPassengers);
    }
}