package edu.ntnu.stud.ui.io.output;

import edu.ntnu.stud.MainMenuEnum;
import edu.ntnu.stud.TrainDepartureEnum;
import edu.ntnu.stud.core.TrainDeparture;
import edu.ntnu.stud.ui.Statistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Class responsible for most of the prompts that help the user utilize the terminal.
 */
public class UserInterface {
  TerminalPrinter terminalPrinter = new TerminalPrinter();


  public void displayMainMenu() {
    menuBorder();
    terminalPrinter.print("Welcome to GoTrain, a user friendly Train Dispatch System!");
    terminalPrinter.print("To access app feature input one of the command word below.");
    terminalPrinter.print("List of commands in CAPITAL letters: ");
    for (MainMenuEnum option : MainMenuEnum.values()) {
      terminalPrinter.print(formatMenuOption(option));
    }
    menuBorder();
  }

  private String formatMenuOption(MainMenuEnum option) {
    if (option.getCommandWords().length > 0) {
      String firstCommandWord = option.getCommandWords()[0].toUpperCase();
      return firstCommandWord + " - " + option.getFullDescription();
    }
    return option.getFullDescription();
  }

  public void displaySearchMenu() {
    menuBorder();
    terminalPrinter.print("Search Train Departures");
    terminalPrinter.print("Input one of the command words below to search:");
    terminalPrinter.print("List of search commands:");
    for (TrainDepartureEnum option : TrainDepartureEnum.values()) {
      if (option.name().startsWith("SEARCH_")) {
        terminalPrinter.print(formatTrainDepartureMenuOption(option));
      }
    }
    menuBorder();
  }
  public void displayEditMenu(String title) {
    menuBorder();
    terminalPrinter.print(title);
    terminalPrinter.print("Input one of the command words below to edit:");
    terminalPrinter.print("List of edit commands:");
    for (TrainDepartureEnum option : TrainDepartureEnum.values()) {
      if (option.name().startsWith("EDIT_")) {
        terminalPrinter.print(formatTrainDepartureMenuOption(option));
      }
    }
    menuBorder();
  }
  private String formatTrainDepartureMenuOption(TrainDepartureEnum option) {
    return option.getCommandWord().toUpperCase() + " - " + option.getDescription();
  }

  /**
   * Displays the train departure details of a possible trainDeparture and checks if the train departure is present.
   * @param trainDepartureOptional the train departure that is or isn't present.
   */
  public void displayTrainDepartureDetails(Optional<TrainDeparture> trainDepartureOptional) {
    if (trainDepartureOptional.isPresent()) {
      TrainDeparture trainDeparture = trainDepartureOptional.get();
      terminalPrinter.print("Departure Time: " + trainDeparture.getDepartureTime());
      terminalPrinter.print("Line: " + trainDeparture.getLine());
      terminalPrinter.print("Train Number: " + trainDeparture.getTrainNumber());
      terminalPrinter.print("Destination: " + trainDeparture.getDestination());
      terminalPrinter.print("Track: " + trainDeparture.getTrack());
      terminalPrinter.print("Delay: " + trainDeparture.getDelay());
    } else {
      terminalPrinter.print("No train departure found with the given number.");
    }
  }

  public void displayTrainDeparturesList(List<TrainDeparture> departures) {
    if (departures.isEmpty()) {
      terminalPrinter.print("No train departures found for the given criteria.");
    } else {
      terminalPrinter.print("Train Departures:");
      for (TrainDeparture departure : departures) {
        displayTrainDepartureDetails(Optional.ofNullable(departure));
      }
    }
  }

  public void displayStatistics(Statistics stats) {
    terminalPrinter.print("Total Departures: " + stats.getTotalDepartures());
    printFormattedMap("Departures per destination: ", stats.getDeparturesByDestination());
    printFormattedMap("Departures per track: ", stats.getDeparturesByTrack());
    printFormattedMap("Departures per line: ", stats.getDeparturesByLine());
    terminalPrinter.print("Current average departure delay: " + Math.round(stats.getAverageDelay()) + " minutes");
    terminalPrinter.print("Percentage of departures not delayed: " + Math.round(stats.getPercentageNotDelayed()) + "%");
  }


  public void departureTimePrompt() {
    terminalPrinter.print("Please enter the departure time (format HH:MM): ");
  }


  public void linePrompt() {
    terminalPrinter.print("Enter a Line: ");
  }

  public void trainNumberPrompt() {
    terminalPrinter.print("Enter a train number: ");
  }

  public void destinationPrompt() {
    terminalPrinter.print("Enter a destination: ");
  }

  public void trackPrompt() {
    terminalPrinter.print("Enter a track: ");
  }

  public void delayPrompt() {
    terminalPrinter.print("Enter a delay in format hh:mm ");
  }

  public void departureCreationMessage(TrainDeparture trainDeparture) {
    terminalPrinter.print("New Train Departure Created Successfully!");
    displayTrainDepartureDetails(Optional.ofNullable(trainDeparture));
  }


  public void clockTimePrompt() {
    terminalPrinter.print("Enter the current time: ");
  }

  public void displayClockUpdatedMessage() {
    terminalPrinter.print("Time have successfully been updated. Departed trains have removed from Information board.");
  }



  public void exitMessage() {
    terminalPrinter.print("Thanks for using our app. Take care!");
  }


  public void displayInvalidOptionMessage() {
    terminalPrinter.print("Sorry, that is not a valid command.");
    terminalPrinter.print("Please refer to the list of valid commands and try again.");
  }



  public void displayDepartureNotFoundMessage() {
    terminalPrinter.print("There are no departures connected to the provided Train Number");
  }

  public void displayEditSuccessMessage() {
    terminalPrinter.print("Success! Thank you for providing the updated information");
  }

  public void displayTrainNumberNotAvailable() {
    terminalPrinter.print("This Train Number is already in use");
  }

  public void displayDepartureRemovalSuccessMessage() {
    terminalPrinter.print("This Train departure have successfully been deleted");
  }

  public void errorMessageTimeFormat() {
    terminalPrinter.printError("Invalid time format, please try again (HH:MM): ");
  }



  private void printFormattedMap(String message, Map<?, ?> map) {
    terminalPrinter.print(message);
    map.forEach((key, value) -> terminalPrinter.print("  " + key + ": " + value));
  }
  private void menuBorder() {
    terminalPrinter.print("_______________________________________");
  }

}
