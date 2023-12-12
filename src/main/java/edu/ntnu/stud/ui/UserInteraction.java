package edu.ntnu.stud.ui;

import edu.ntnu.stud.InputHandler;
import edu.ntnu.stud.MainMenuEnum;
import edu.ntnu.stud.TrainDepartureEnum;
import edu.ntnu.stud.core.TrainDeparture;
import edu.ntnu.stud.core.TrainStation;
import edu.ntnu.stud.ui.io.output.UserInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class UserInteraction {

  UserInterface userInterface = new UserInterface();
  InputHandler inputHandler = new InputHandler();
  TrainStation trainStation = new TrainStation();
  InformationBoard informationBoard = new InformationBoard(trainStation);

  /**
   * Starts the program and user interface.
   */
  public void StartUI() {

    boolean isRunning = true;

    while (isRunning) {
      userInterface.displayMainMenu();
      String userChoice = inputHandler.menuChoice();
      MainMenuEnum selectedOption = MainMenuEnum.fromInput(userChoice);

      if (selectedOption == null) {
        userInterface.displayInvalidOptionMessage();
        continue;     //jumps to next iteration of while loop
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

  /**
   * Method to search train departures.
   */
  public void searchTrainDepartures() {
    userInterface.displaySearchMenu();
    String searchChoice = inputHandler.menuChoice();

    TrainDepartureEnum command = TrainDepartureEnum.fromCommandWord(searchChoice);

    switch (command) {
      case SEARCH_DEPARTURE_TIME -> searchByDepartureTime();
      case SEARCH_LINE -> searchByLine();
      case SEARCH_TRAIN_NUMBER -> searchByTrainNumber();
      case SEARCH_DESTINATION -> searchByDestination();
      case SEARCH_TRACK -> searchByTrack();
      case SEARCH_DELAY -> searchByDelay();
      default -> userInterface.displayInvalidOptionMessage();
    }
  }


  /**
   * Method to edit train departures.
   */
  public void editTrainDeparture() {
    userInterface.trainNumberPrompt();
    String trainNumber = inputHandler.getTrainNumberInput();
    Optional<TrainDeparture> trainDepartureOptional = trainStation.findTrainDepartureByNumber(trainNumber);

    if (trainDepartureOptional.isPresent()) {
      TrainDeparture departure = trainDepartureOptional.get();
      userInterface.displayEditMenu("Edit Train Departure");
      String choice = inputHandler.menuChoice();

      TrainDepartureEnum command = TrainDepartureEnum.fromCommandWord(choice);

      if (command == null) {
        userInterface.displayInvalidOptionMessage();
        return;
      }

      switch (command) {
        case EDIT_DEPARTURE_TIME -> editDepartureTime(departure);
        case EDIT_LINE-> editLine(departure);
        case EDIT_TRAIN_NUMBER -> editTrainNumber(departure);
        case EDIT_DESTINATION -> editDestination(departure);
        case EDIT_TRACK -> editTrack(departure);
        case EDIT_DELAY -> editDelay(departure);
        default -> userInterface.displayInvalidOptionMessage();
      }
    } else {
      userInterface.displayDepartureNotFoundMessage();
    }
  }

  private void editDestination(TrainDeparture departure) {
    userInterface.destinationPrompt(); // Prompt the user for the new destination
    String newDestination = inputHandler.getDestinationInput(); // Get the new destination from the user
    departure.setDestination(newDestination); // Set the new destination in the departure object
    userInterface.displayEditSuccessMessage(); // Display a success message
    waitForEnterKeyPress(); // Wait for user to press Enter
  }


  private void editTrainNumber(TrainDeparture departure) {
    userInterface.trainNumberPrompt(); // Prompt the user for the new train number
    String newTrainNumber = inputHandler.getTrainNumberInput(); // Get the new train number from the user
    departure.setTrainNumber(newTrainNumber); // Set the new train number in the departure object
    userInterface.displayEditSuccessMessage(); // Display a success message
    waitForEnterKeyPress(); // Wait for user to press Enter
  }


  private void editLine(TrainDeparture departure) {
    userInterface.linePrompt(); // Prompt the user for the new line
    String newLine = inputHandler.getLineInput(); // Get the new line from the user
    departure.setLine(newLine); // Set the new line in the departure object
    userInterface.displayEditSuccessMessage(); // Display a success message
    waitForEnterKeyPress(); // Wait for user to press Enter
  }


  private void editDepartureTime(TrainDeparture departure) {
    userInterface.departureTimePrompt(); // Prompt the user for the new departure time
    LocalTime newDepartureTime = inputHandler.getDepartureTimeInput(); // Get the new departure time from the user
    departure.setDepartureTime(newDepartureTime); // Set the new departure time in the departure object
    userInterface.displayEditSuccessMessage(); // Display a success message
    waitForEnterKeyPress(); // Wait for user to press Enter
  }


  public void viewInformationBoard() {
    informationBoard.displayInformationBoard(trainStation);
    waitForEnterKeyPress();
    }

  private void searchByDepartureTime() {
    userInterface.departureTimePrompt(); // Prompt the user for a departure time
    LocalTime departureTime = inputHandler.getDepartureTimeInput(); // Get the departure time input from the user

    // Filter the train departures by the specified departure time
    List<TrainDeparture> departures = trainStation.findTrainDeparturesByDepartureTime(departureTime);

    // Display the filtered list of train departures
    userInterface.displayTrainDeparturesList(departures);

    waitForEnterKeyPress(); // Wait for the user to press enter before proceeding
  }
  private void searchByLine() {
    userInterface.linePrompt();
    String line = inputHandler.getLineInput();
    List<TrainDeparture> departures = trainStation.findTrainDeparturesByLine(line);
    userInterface.displayTrainDeparturesList(departures);
    waitForEnterKeyPress();
  }

  private void searchByTrainNumber() {
    userInterface.trainNumberPrompt();
    String trainNumber = inputHandler.getTrainNumberInput();
    Optional<TrainDeparture> trainDeparture = trainStation.findTrainDepartureByNumber(trainNumber);
    userInterface.displayTrainDepartureDetails(trainDeparture);
    waitForEnterKeyPress();
  }

  private void searchByDestination() {
    userInterface.destinationPrompt();
    String destination = inputHandler.getDestinationInput();
    List<TrainDeparture> departures = trainStation.findTrainDeparturesByDestination(destination);
    userInterface.displayTrainDeparturesList(departures);
    waitForEnterKeyPress();
  }
  private void searchByTrack() {
    userInterface.trackPrompt(); // Prompt the user for a track number
    int trackNumber = inputHandler.getTrackInput(); // Get the track number input from the user

    // Filter the train departures by the specified track number
    List<TrainDeparture> departures = trainStation.findTrainDeparturesByTrack(trackNumber);

    // Display the filtered list of train departures
    userInterface.displayTrainDeparturesList(departures);

    waitForEnterKeyPress(); // Wait for the user to press enter before proceeding
  }
  private void searchByDelay() {
    userInterface.delayPrompt();
    LocalTime delay = inputHandler.getDelayInput();
    List<TrainDeparture> departures = trainStation.findTrainDeparturesByDelay(delay);
    userInterface.displayTrainDeparturesList(departures);
    waitForEnterKeyPress();
  }
  private void editTrack(TrainDeparture departure) {
    userInterface.trackPrompt();
    int newTrack = inputHandler.getTrackInput();
    departure.setTrack(newTrack);
    userInterface.displayEditSuccessMessage();
    waitForEnterKeyPress();
  }

  private void editDelay(TrainDeparture departure) {
    userInterface.delayPrompt();
    LocalTime newDelay = inputHandler.getDelayInput();
    departure.setDelay(newDelay);
    userInterface.displayEditSuccessMessage();
    waitForEnterKeyPress();
  }

  public void updateClock() {

      LocalTime newTime = inputHandler.getClockTimeInput();
      trainStation.updateCurrentTime(newTime);
      userInterface.displayClockUpdatedMessage(newTime);
    waitForEnterKeyPress();
  }

  public void createTrainDeparture() {
    String trainNumber = inputHandler.getTrainNumberInput();

    if (trainStation.findTrainDepartureByNumber(trainNumber).isPresent()) {
      userInterface.displayTrainNumberNotAvailable();
    }
    else {
      TrainDeparture trainDeparture = new TrainDeparture(inputHandler.getDepartureTimeInput(),
          inputHandler.getLineInput(), trainNumber, inputHandler.getDestinationInput(), inputHandler.getTrackInput(), inputHandler.getDelayInput());
      userInterface.departureCreationMessage(trainDeparture);
      userInterface.displayTrainDepartureDetails(Optional.of(trainDeparture));
      trainStation.addTrainDeparture(trainDeparture);
    }
    waitForEnterKeyPress();
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
    waitForEnterKeyPress();
  }
  public void showStatistics() {
    Statistics stats = trainStation.getStationStatistics();
    userInterface.displayStatistics(stats);
    waitForEnterKeyPress();
  }

  public void waitForEnterKeyPress() {
    System.out.println("Press Enter key to return to the main menu...");

    try {
      new BufferedReader(new InputStreamReader(System.in)).readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
