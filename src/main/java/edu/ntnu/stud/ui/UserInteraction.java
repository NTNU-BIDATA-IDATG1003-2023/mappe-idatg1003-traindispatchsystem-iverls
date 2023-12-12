package edu.ntnu.stud.ui;

import edu.ntnu.stud.InputHandler;
import edu.ntnu.stud.MainMenu;
import edu.ntnu.stud.TrainStationInfoEnum;
import edu.ntnu.stud.core.Clock;
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
  Clock clock = new Clock();

  public void StartUI() {

    boolean isRunning = true;

    while (isRunning) {
      userInterface.displayMainMenu();
      String userChoice = inputHandler.menuChoice();
      MainMenu selectedOption = MainMenu.fromOptionNumber(userChoice);

      if (selectedOption == null) {
        userInterface.displayInvalidOptionMessage();
        continue;
      }
      System.out.println("Selected Option: " + selectedOption); // Debug print

      switch (selectedOption) {
        case VIEW_INFORMATION_BOARD -> viewInformationBoard();
        case SEARCH_TRAIN_DEPARTURE -> searchTrainDepartures();
        case EDIT_TRAIN_DEPARTURE -> editTrainDeparture();
        case UPDATE_TIME -> updateClock();
        case CREATE_TRAIN_DEPARTURE -> createTrainDeparture();
        case DELETE_TRAIN_DEPARTURE -> deleteTrainDeparture();
        case SHOW_STATISTICS -> showStatistics();
        case EXIT_APPLICATION -> {
          isRunning = false;
          userInterface.exitMessage();
        }
        default -> userInterface.displayInvalidOptionMessage();
      }
    }
  }
  public void searchTrainDepartures() {
    userInterface.displaySearchMenu();
    String searchChoice = inputHandler.menuChoice();

    TrainStationInfoEnum command = TrainStationInfoEnum.fromString(searchChoice);

    switch (command) {
      case TRAIN_NUMBER -> searchByTrainNumber();
      case DESTINATION -> searchByDestination();
      default -> userInterface.displayInvalidOptionMessage();
    }
  }
  public void editTrainDeparture() {
    userInterface.trainNumberPrompt();
    String trainNumber = inputHandler.getTrainNumberInput();
    Optional<TrainDeparture> trainDepartureOptional = trainStation.findTrainDepartureByNumber(trainNumber);

    if (trainDepartureOptional.isPresent()) {
      TrainDeparture departure = trainDepartureOptional.get();
      userInterface.displayEditOptions();
      String editChoice = inputHandler.menuChoice();

      switch (editChoice) {
        case "1" -> editTrack(departure);
        case "2" -> editDelay(departure);
        default -> userInterface.displayInvalidOptionMessage();
      }
    } else {
      userInterface.displayDepartureNotFoundMessage();
    }
  }

  public void viewInformationBoard() {
    informationBoard.displayInformationBoard(trainStation);
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

  public void updateClock() {
    try {
      LocalTime newTime = inputHandler.getClockTimeInput();
      clock.setCurrentTime(newTime);
      trainStation.removeExpiredTrainDepartures(clock.getCurrentTime());
      userInterface.displayClockUpdatedMessage(clock.getCurrentTime());

    } catch (Exception e) {
      userInterface.errorMessageTimeFormat();
    }
  }

  public void createTrainDeparture() {
    String trainNumber = inputHandler.getTrainNumberInput();

    if (trainStation.findTrainDepartureByNumber(trainNumber).isPresent()) {
      userInterface.displayTrainNumberNotAvailable();
    }
    else {
      TrainDeparture trainDeparture = new TrainDeparture(inputHandler.getDepartureTimeInput(),
          inputHandler.getLineInput(), trainNumber, inputHandler.getDestinationInput(), inputHandler.getTrackInput(), inputHandler.getDelayInput());
      userInterface.departureCreationMessage();
      userInterface.displayTrainDepartureDetails(Optional.of(trainDeparture));
      trainStation.addTrainDeparture(trainDeparture);
    }
  }

  public void deleteTrainDeparture() {
    userInterface.trainNumberPrompt();
    String trainNumber = inputHandler.getTrainNumberInput();

    Optional<TrainDeparture> trainDeparture = trainStation.findTrainDepartureByNumber(trainNumber);

    if (trainDeparture.isPresent()) {
      trainStation.removeTrainDeparture(trainNumber);
      userInterface.displayDepartureRemovalSuccessMessage();
    } else {
      userInterface.displayDepartureNotFoundMessage();
    }
  }
  public void showStatistics() {
    Statistics stats = trainStation.getStationStatisti();
    userInterface.displayStatistics(stats);
  }



}
