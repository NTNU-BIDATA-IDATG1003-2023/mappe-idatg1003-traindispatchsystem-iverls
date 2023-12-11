package edu.ntnu.stud;

import edu.ntnu.stud.core.TrainDeparture;
import edu.ntnu.stud.ui.io.input.InputReader;
import edu.ntnu.stud.ui.io.output.UserInterface;
import edu.ntnu.stud.utility.Validator;
import java.time.LocalTime;



public class InputHandler {

  InputReader inputReader = new InputReader();
  UserInterface userInterface = new UserInterface();

  public TrainDeparture createTrainDeparture(String departureTimeStr, String line, String trainNumber, String destination, String trackStr, String delayStr) {
    Validator.validateTime(departureTimeStr);
    Validator.validateTrack(trackStr);
    Validator.validateTime(delayStr);

    LocalTime departureTime = LocalTime.parse(departureTimeStr);
    int track = Integer.parseInt(trackStr);
    LocalTime delay = LocalTime.parse(delayStr);

    return new TrainDeparture(departureTime, line, trainNumber, destination, track, delay);
  }

  public LocalTime getDepartureTimeInput()
  {
    userInterface.departureTimePromt();
    String userInputDepartureTime = inputReader.readUserInput();
    Validator.validateTime(userInputDepartureTime);
    return LocalTime.parse(userInputDepartureTime);
  }

  public String getLineInput()
  {
    userInterface.linePromt();
    return inputReader.readUserInput();
  }

  public String getTrainNumberInput()
  {
    userInterface.trainNumberPromt();
    return inputReader.readUserInput();
  }

  public String getDestinationInput()
  {
    userInterface.destinationPromt();
    return inputReader.readUserInput();
  }

  public int getTrackInputInput()
  {
    userInterface.trackPromt();
    String userInputTrack = inputReader.readUserInput();
    Validator.validateTrack(userInputTrack);
    return Integer.parseInt(userInputTrack);
  }

  public LocalTime getDelayInput()
  {
    userInterface.delayPromt();
    String userInputDelay = inputReader.readUserInput();
    Validator.validateTime(userInputDelay);
    return LocalTime.parse(userInputDelay);
  }






}
