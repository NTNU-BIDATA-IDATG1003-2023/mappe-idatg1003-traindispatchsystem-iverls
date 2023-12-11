package edu.ntnu.stud;

import edu.ntnu.stud.ui.io.input.InputReader;
import edu.ntnu.stud.ui.io.output.UserInterface;
import edu.ntnu.stud.utility.Validator;
import java.time.LocalTime;



public class InputHandler {

  InputReader inputReader = new InputReader();
  UserInterface userInterface = new UserInterface();

  public String menuChoice() {
    return inputReader.readUserInput();
  }

  public LocalTime getDepartureTimeInput() {
    LocalTime departureTime = null;
    boolean validInput = false;

    while (!validInput) {
      userInterface.departureTimePromt();
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
    String line = null;
    boolean validInput = false;

    while (!validInput) {
      userInterface.linePromt();
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
    String trainNumber = null;
    boolean validInput = false;

    while (!validInput) {
      userInterface.trainNumberPrompt();
      trainNumber = inputReader.readUserInput();
      if (Validator.validateTrainNumber(trainNumber)) {
        validInput = true;
      } else {
        userInterface.printError("Invalid train number. Please enter a valid number.");
      }
    }

    return trainNumber;
  }

  public String getDestinationInput() {
    userInterface.destinationPromt();
    return inputReader.readUserInput();
  }

  public int getTrackInput() {
    int track = 0;
    boolean validInput = false;

    while (!validInput) {
      userInterface.trackPromt();
      String userInputTrack = inputReader.readUserInput();
      if (Validator.validateTrack(userInputTrack)) {
        track = Integer.parseInt(userInputTrack);
        validInput = true;
      } else {
        userInterface.printError("Invalid track number, must be a positive number. Please enter a valid number.");
      }
    }

    return track;
  }

  public LocalTime getDelayInput() {
    LocalTime delay = null;
    boolean validInput = false;

    while (!validInput) {
      userInterface.delayPromt();
      String userInputDelay = inputReader.readUserInput();
      if (Validator.validateTime(userInputDelay)) {
        delay = LocalTime.parse(userInputDelay);
        validInput = true;
      } else {
        userInterface.printError("Invalid delay format. Please enter a valid time (HH:MM).");
      }
    }

    return delay;
  }

}
