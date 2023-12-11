package edu.ntnu.stud.ui;

import edu.ntnu.stud.InputHandler;
import edu.ntnu.stud.core.TrainDeparture;
import edu.ntnu.stud.core.TrainStation;
import edu.ntnu.stud.ui.io.output.UserInterface;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class UserInteraction {

  UserInterface userInterface = new UserInterface();
  InputHandler inputHandler = new InputHandler();
  TrainStation trainStation = new TrainStation();
  InformationBoard informationBoard = new InformationBoard(trainStation);

  public void StartUI() {

    boolean isRunning = true;

    while (isRunning) {
      userInterface.displayMainMenu();
      String mainMenuChoice = inputHandler.menuChoice();

      switch (mainMenuChoice) {

        case "1":
          viewInformationBoard();
          break;
        case "2":
          searchTrainDepartures();
          break;
        case "3":
          editDeparture();
          break;
        case "4":
          updateClock();
          break;
        case "5":
          createTrainDeparture();
          break;
        case "6":
          removeTrainDeparture();
          break;
        case "7":
          userInterface.exitMessage();
          isRunning = false;
      }
    }


  }

  public void viewInformationBoard() {
    informationBoard.displayInformationBoard(trainStation);

    }

  public void searchTrainDepartures() {
    userInterface.displaySearchMenu();
    String searchChoice = inputHandler.menuChoice();

    switch (searchChoice) {
      case "1":
        searchByTrainNumber();
        break;
      case "2":
        searchByDestination();
        break;
      default:
        userInterface.displayInvalidOptionMessage();
        break;
    }
  }

  private void searchByTrainNumber() {
    userInterface.trainNumberPrompt();
    String trainNumber = inputHandler.getTrainNumberInput();
    Optional<TrainDeparture> trainDeparture = informationBoard.findTrainDepartureByNumber(trainNumber);
    userInterface.displayTrainDepartureDetails(trainDeparture);
  }

  private void searchByDestination() {
    userInterface.destinationPrompt();
    String destination = inputHandler.getDestinationInput();
    List<TrainDeparture> departures = informationBoard.findTrainDeparturesByDestination(destination);
    userInterface.displayTrainDeparturesList(departures);
  }


  public void editDeparture() {
    userInterface.trainNumberPrompt();
    String trainNumber = inputHandler.getTrainNumberInput();
    Optional<TrainDeparture> trainDepartureOptional = trainStation.findTrainDepartureByNumber(trainNumber);

    if (trainDepartureOptional.isPresent()) {
      TrainDeparture departure = trainDepartureOptional.get();
      userInterface.displayEditOptions();
      String editChoice = inputHandler.menuChoice();

      switch (editChoice) {
        case "1":
          editTrack(departure);
          break;
        case "2":
          editDelay(departure);
          break;
        default:
          userInterface.displayInvalidOptionMessage();
          break;
      }
    } else {
      userInterface.displayDepartureNotFoundMessage();
    }
  }

  private void editTrack(TrainDeparture departure) {
    userInterface.trackPrompt();
    int newTrack = inputHandler.getTrackInput();
    departure.setTrack(newTrack);
    userInterface.displayEditSuccessMessage();
  }

  private void editDelay(TrainDeparture departure) {
    userInterface.delayPrompt();
    LocalTime newDelay = inputHandler.getDelayInput();
    departure.setDelay(newDelay);
    userInterface.displayEditSuccessMessage();
  }

  public void updateClock()
  {

  }

  public void addDelay()
  {

  }

  public void assignLine()
  {

  }

  public void createTrainDeparture()
  {
    TrainDeparture trainDeparture = new TrainDeparture(inputHandler.getDepartureTimeInput(), inputHandler.getLineInput(),
        inputHandler.getTrainNumberInput(), inputHandler.getDestinationInput(), inputHandler.getTrackInput(), inputHandler.getDelayInput());
    userInterface.departureCreationMessage();
    userInterface.displayTrainDepartureDetails(Optional.of(trainDeparture));
    trainStation.addTrainDeparture(trainDeparture);
  }

  public void removeTrainDeparture()
  {

  }


}
