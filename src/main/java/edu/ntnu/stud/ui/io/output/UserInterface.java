package edu.ntnu.stud.ui.io.output;

import edu.ntnu.stud.MainMenu;
import edu.ntnu.stud.core.TrainDeparture;
import edu.ntnu.stud.ui.Statistics;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserInterface {
  TerminalPrinter terminalPrinter = new TerminalPrinter();


  public void displayMainMenu() {
    for (MainMenu option : MainMenu.values()) {
      terminalPrinter.print(option.getOptionNumber() + ". " + option.getDescription());
    }
    terminalPrinter.print("Please choose an option by pressing a number: ");
  }

  public void displaySearchMenu() {
    terminalPrinter.print("Please select search parameter");
    terminalPrinter.print("1. TrainNumber ");
    terminalPrinter.print("2. Destination ");
  }

  public void displayEditOptions() {
    terminalPrinter.print("Please select what information you want to edit");
    terminalPrinter.print("1. Track ");
    terminalPrinter.print("2. Delay ");
  }

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
    terminalPrinter.print("Enter a departure time in format hh:mm ");
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

  public void departureCreationMessage() {
    terminalPrinter.print("New Train Departure Created:");
  }

  public void clockTimePrompt() {
    terminalPrinter.print("Enter the current time: ");
  }

  public void displayClockUpdatedMessage(LocalTime newTime) {
    terminalPrinter.print("Time have successfully been updated. Departed trains have removed from Information board.");
  }



  public void exitMessage() {
    terminalPrinter.print("Thanks for using our app. Take care!");
  }


  public void displayInvalidOptionMessage() {
    terminalPrinter.print("Sorry, that is not a valid command. Please try again:");
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


}
