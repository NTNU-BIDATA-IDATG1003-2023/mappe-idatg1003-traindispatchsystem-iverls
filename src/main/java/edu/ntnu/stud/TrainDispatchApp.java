package edu.ntnu.stud;

import java.time.LocalTime;
import java.util.Scanner;

/**
 * This is the main class for the train dispatch application.
 */
public class TrainDispatchApp {

  public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);
      boolean isRunning = true;

      while (isRunning) {
        System.out.println("Welcome to the Train Dispatch App. Choose an option:");
        System.out.println("1. Create new Train Departure");
        System.out.println("2. Exit application");

        String userInput = scanner.nextLine();

        switch (userInput) {

          case "1":

            TrainDeparture trainDeparture;

            System.out.println("Enter a departure time in format hh:mm ");
            String userInputDeparture = scanner.nextLine();

            System.out.println("Enter a Line ");
            String userInputLine = scanner.nextLine();

            System.out.println("Enter a train number ");
            String userInputTrainNumber = scanner.nextLine();

            System.out.println("Enter a destination ");
            String userInputDestination = scanner.nextLine();

            System.out.println("Enter a tack ");
            String userInputTrack = scanner.nextLine();

            System.out.println("Enter a delay in format hh:mm ");
            String userInputDelay = scanner.nextLine();

            trainDeparture = new TrainDeparture(LocalTime.parse(userInputDeparture), userInputLine, userInputTrainNumber, userInputDestination, Integer.parseInt(userInputTrack), LocalTime.parse(userInputDelay));


            System.out.println("New Train Departure Created:");
            System.out.println("Departure Time: " + trainDeparture.getDepartureTime());
            System.out.println("Line: " + trainDeparture.getLine());
            System.out.println("Train Number: " + trainDeparture.getTrainNumber());
            System.out.println("Destination: " + trainDeparture.getDestination());
            System.out.println("Track: " + trainDeparture.getTrack());
            System.out.println("Delay: " + trainDeparture.getDelay());

            break;

          case "2":
            System.out.println("Thanks for using our app. Take care!");
            isRunning = false;

        }
      }



  }
}
