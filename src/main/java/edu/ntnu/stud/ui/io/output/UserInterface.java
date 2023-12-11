package edu.ntnu.stud.ui.io.output;

import edu.ntnu.stud.InputHandler;
import edu.ntnu.stud.core.TrainDeparture;
import edu.ntnu.stud.ui.io.input.InputReader;

public class UserInterface {

  public void displayMainMenu() {
    System.out.println("Welcome to the Train Dispatch App. Here are your options:");
    System.out.println("1. View information board");
    System.out.println("2. Search train departure");
    System.out.println("3. Update clock");
    System.out.println("4. Add delay to specified train departure");
    System.out.println("5. Assign line to specified train departure");
    System.out.println("6. Create new train departure");
    System.out.println("7. Delete specified train departure");
    System.out.println("8. Exit application");
    System.out.println("Please choose an option by pressing a number: ");

  }

  public void departureTimePromt()
  {
    System.out.println("Enter a departure time in format hh:mm ");
  }
  public void linePromt()
  {
    System.out.println("Enter a Line: ");
  }

  public void trainNumberPromt()
  {
    System.out.println("Enter a train number: ");
  }

  public void destinationPromt()
  {
    System.out.println("Enter a destination: ");
  }

  public void trackPromt()
  {
    System.out.println("Enter a track: ");
  }

  public void delayPromt()
  {
    System.out.println("Enter a delay in format hh:mm ");
  }


  public void displayNewTrainDepartureDetails(TrainDeparture trainDeparture) {
    System.out.println("New Train Departure Created:");
    System.out.println("Departure Time: " + trainDeparture.getDepartureTime());
    System.out.println("Line: " + trainDeparture.getLine());
    System.out.println("Train Number: " + trainDeparture.getTrainNumber());
    System.out.println("Destination: " + trainDeparture.getDestination());
    System.out.println("Track: " + trainDeparture.getTrack());
    System.out.println("Delay: " + trainDeparture.getDelay());
  }
/**
 public String searchDepartureByTrainNumber() {
 return inputReader.promptForInput("Please provide Train Number: ");
 }

 **/

 public void exitMessage() {
 System.out.println("Thanks for using our app. Take care!");
 }



}
