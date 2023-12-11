package edu.ntnu.stud.ui.io.output;

import edu.ntnu.stud.core.TrainDeparture;
import java.util.List;
import java.util.Optional;

public class UserInterface {

  public void print(String stringToPrint) {
    System.out.println(stringToPrint);
  }

  public void printError(String stringToPrint) {
    System.err.println(stringToPrint);
  }

  public void displayMainMenu() {
    print("Welcome to the Train Dispatch App. Here are your options, that can be selected by writing the corresponding number: ");
    print("1. View information board ");
    print("2. Search train departure ");
    print("3. Edit specified train departure ");
    print("4. Update time ");
    print("5. Create new train departure ");
    print("6. Delete specified train departure ");
    print("7. Exit application ");
    print("Please choose an option by pressing a number: ");

  }

  public void displaySearchMenu() {
    print("Please select search parameter");
    print("1. TrainNumber ");
    print("2. Destination ");
  }

  public void displayEditOptions() {
    print("Please select what information you want to edit");
    print("1. Track ");
    print("2. Delay ");
  }

  public void departureTimePrompt() {
    print("Enter a departure time in format hh:mm ");
  }

  public void linePrompt() {
    print("Enter a Line: ");
  }

  public void trainNumberPrompt() {
    print("Enter a train number: ");
  }

  public void destinationPrompt() {
    print("Enter a destination: ");
  }

  public void trackPrompt() {
    print("Enter a track: ");
  }

  public void delayPrompt() {
    print("Enter a delay in format hh:mm ");
  }

  public void departureCreationMessage() {
    print("New Train Departure Created:");
  }


  public void displayTrainDepartureDetails(Optional<TrainDeparture> trainDepartureOptional) {
    if (trainDepartureOptional.isPresent()) {
      TrainDeparture trainDeparture = trainDepartureOptional.get();
      print("Departure Time: " + trainDeparture.getDepartureTime());
      print("Line: " + trainDeparture.getLine());
      print("Train Number: " + trainDeparture.getTrainNumber());
      print("Destination: " + trainDeparture.getDestination());
      print("Track: " + trainDeparture.getTrack());
      print("Delay: " + trainDeparture.getDelay());
    } else {
      print("No train departure found with the given number.");
    }
  }

  public void displayTrainDeparturesList(List<TrainDeparture> departures) {
    if (departures.isEmpty()) {
      print("No train departures found for the given criteria.");
    } else {
      print("Train Departures:");
      for (TrainDeparture departure : departures) {
        displayTrainDepartureDetails(Optional.ofNullable(departure));
      }
    }
  }

  public void errorMessageTimeFormat() {
    printError("Invalid time format, please try again (HH:MM): ");
  }
  public void exitMessage() {
 print("Thanks for using our app. Take care!");
  }


  public void displayInvalidOptionMessage() {
    print("Sorry, that is not a valid command. Please try again:");
  }


  public void displayDepartureNotFoundMessage() {
    print("There are no departures connected to the provided Train Number");
  }

  public void displayEditSuccessMessage() {
    print("Success! Thank you for providing the updated information");
  }
}
