package edu.ntnu.stud;

import edu.ntnu.stud.ui.io.input.InputReader;
import edu.ntnu.stud.ui.io.output.TerminalPrinter;
import edu.ntnu.stud.ui.io.output.UserInterface;
import edu.ntnu.stud.utility.Validator;
import java.time.LocalTime;


/**
 * Class responsible for handling user input.
 */
public class InputHandler {

  InputReader inputReader = new InputReader();
  UserInterface userInterface = new UserInterface();
  TerminalPrinter terminalPrinter = new TerminalPrinter();

  public String menuChoice() {
    return inputReader.readUserInput();
  }

  public LocalTime getDepartureTimeInput() {
    userInterface.departureTimePrompt();
    LocalTime departureTime = null;
    boolean validInput = false;

    while (!validInput) {
      String userInputDepartureTime = inputReader.readUserInput();
      if (Validator.validateTime(userInputDepartureTime)) {
        departureTime = LocalTime.parse(userInputDepartureTime);
        validInput = true;
      } else {
        userInterface.errorMessageTimeFormat();
      }
    }
    return departureTime;
  }

  public String getLineInput() {
    userInterface.linePrompt();
    String line = null;
    boolean validInput = false;

    while (!validInput) {
      line = inputReader.readUserInput();
      if (Validator.validateString(line)) {
        validInput = true;
      } else {
        userInterface.errorMessageTimeFormat();
      }
    }
    return line;
  }

  public String getTrainNumberInput() {
    userInterface.trainNumberPrompt();
    String trainNumber = null;
    boolean validInput = false;

    while (!validInput) {
      trainNumber = inputReader.readUserInput();
      if (Validator.validateTrainNumber(trainNumber)) {
        validInput = true;
      } else {
        terminalPrinter.printError("Invalid train number. Please enter a valid number.");
      }
    }

    return trainNumber;
  }

  public String getDestinationInput() {
    userInterface.destinationPrompt();
    return inputReader.readUserInput();
  }

  public int getTrackInput() {
    userInterface.trackPrompt();
    int track = 0;
    boolean validInput = false;

    while (!validInput) {
      String userInputTrack = inputReader.readUserInput();
      if (Validator.validateTrack(userInputTrack)) {
        track = Integer.parseInt(userInputTrack);
        validInput = true;
      } else {
        terminalPrinter.printError("Invalid track number, must be a positive number. Please enter a valid number.");
      }
    }

    return track;
  }

  public LocalTime getDelayInput() {
    userInterface.delayPrompt();
    LocalTime delay = null;
    boolean validInput = false;

    while (!validInput) {
      String userInputDelay = inputReader.readUserInput();
      if (Validator.validateTime(userInputDelay)) {
        delay = LocalTime.parse(userInputDelay);
        validInput = true;
      } else {
        terminalPrinter.printError("Invalid delay format. Please enter a valid time (HH:MM).");
      }
    }

    return delay;
  }

  public LocalTime getClockTimeInput() {
    userInterface.clockTimePrompt();
    LocalTime newTime = null;
    boolean validInput = false;

    while (!validInput) {
      String userInputTime = inputReader.readUserInput();
      if (Validator.validateTime(userInputTime)) {
        newTime = LocalTime.parse(userInputTime);
        validInput = true;
      } else {
        terminalPrinter.printError("Invalid time format. Please enter a valid time (HH:MM).");
      }
    }

    return newTime;
  }


}
