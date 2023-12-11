package edu.ntnu.stud.ui.io.output;

import edu.ntnu.stud.core.TrainDeparture;
import java.util.Optional;

public class UserInterface {

  public void print(String stringToPrint) {
    System.out.println(stringToPrint);
  }

  public void printError(String stringToPrint) {
    System.err.println(stringToPrint);
  }

  public void displayMainMenu() {
    print("Welcome to the Train Dispatch App. Here are your options:");
    print("1. View information board");
    print("2. Search train departure");
    print("3. Update clock");
    print("4. Add delay to specified train departure");
    print("5. Assign line to specified train departure");
    print("6. Create new train departure");
    print("7. Delete specified train departure");
    print("8. Exit application");
    print("Please choose an option by pressing a number: ");

  }

  public void departureTimePromt() {
    print("Enter a departure time in format hh:mm ");
  }

  public void linePromt() {
    print("Enter a Line: ");
  }

  public void trainNumberPrompt() {
    print("Enter a train number: ");
  }

  public void destinationPromt() {
    print("Enter a destination: ");
  }

  public void trackPromt() {
    print("Enter a track: ");
  }

  public void delayPromt() {
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



  public void errorMessageTimeFormat() {
    printError("Invalid time format, please try again (HH:MM): ");
  }
  public void exitMessage() {
 print("Thanks for using our app. Take care!");
  }
}
