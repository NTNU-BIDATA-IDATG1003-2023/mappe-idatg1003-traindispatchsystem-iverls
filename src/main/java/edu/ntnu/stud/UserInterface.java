package edu.ntnu.stud;

public class UserInterface {
  UserInput userInput = new UserInput();
  InputHandler inputHandler = new InputHandler();

  public String displayMainMenu() {
    System.out.println("Welcome to the Train Dispatch App. Here are your options:");
    System.out.println("1. Create new Train Departure");
    System.out.println("2. View information board");
    System.out.println("3. Search for Train Departure by Train Number");
    System.out.println("4. Exit application");
    return userInput.promptForInput("Please choose an option by pressing a number: ");

  }

  public TrainDeparture newTrainDeparture() {
    String userInputDeparture = userInput.promptForInput("Enter a departure time in format hh:mm ");
    String userInputLine = userInput.promptForInput("Enter a Line: ");
    String userInputTrainNumber = userInput.promptForInput("Enter a train number: ");
    String userInputDestination = userInput.promptForInput("Enter a destination: ");
    String userInputTrack = userInput.promptForInput("Enter a track: ");
    String userInputDelay = userInput.promptForInput("Enter a delay in format hh:mm: ");
    return inputHandler.createTrainDeparture(userInputDeparture, userInputLine, userInputTrainNumber, userInputDestination, userInputTrack, userInputDelay);
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

  public String searchDepartureByTrainNumber() {
    return userInput.promptForInput("Please provide Train Number: ");
  }

  public void exitMessage() {
    System.out.println("Thanks for using our app. Take care!");
  }

}
