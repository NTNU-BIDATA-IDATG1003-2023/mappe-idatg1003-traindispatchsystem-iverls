package edu.ntnu.stud.ui;

import edu.ntnu.stud.InputHandler;
import edu.ntnu.stud.core.TrainDeparture;
import edu.ntnu.stud.core.TrainStation;
import edu.ntnu.stud.ui.io.output.UserInterface;
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
      String input = inputHandler.menuChoice();

      switch (input) {

        case "1":
          viewInformationBoard();
          break;
        case "2":
          searchTrainDepartures();
          break;
        case "3":
          updateClock();
          break;
        case "4":
          addDelay();
          break;
        case "5":
          assignLine();
          break;
        case "6":
          createTrainDeparture();
          break;
        case "7":
          removeTrainDeparture();
          break;
        case "8":
          userInterface.exitMessage();
          isRunning = false;
      }
    }


  }

  public void viewInformationBoard() {
    informationBoard.displayInformationBoard(trainStation);

    }

  public void searchTrainDepartures() {
    String trainNumber;
    Optional<TrainDeparture> trainDeparture;
    userInterface.trainNumberPrompt();
    trainNumber = inputHandler.getTrainNumberInput();
    trainDeparture = trainStation.findTrainDepartureByNumber(trainNumber);
    userInterface.displayTrainDepartureDetails(trainDeparture);
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
