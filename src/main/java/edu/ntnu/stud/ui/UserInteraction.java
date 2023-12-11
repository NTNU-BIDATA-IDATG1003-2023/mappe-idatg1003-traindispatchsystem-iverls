package edu.ntnu.stud.ui;

import edu.ntnu.stud.InformationBoard;
import edu.ntnu.stud.InputHandler;
import edu.ntnu.stud.core.TrainDeparture;
import edu.ntnu.stud.ui.io.output.UserInterface;

public class UserInteraction {

  UserInterface userInterface = new UserInterface();
  InputHandler inputHandler = new InputHandler();
  InformationBoard informationBoard = new InformationBoard();

  public void StartUI() {

    boolean isRunning = true;

    while (isRunning) {
      userInterface.displayMainMenu();
      String input = inputHandler.menuChoice();

      switch (input) {

        case "1":
          viewInformatonboard();
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

  public void viewInformatonboard()
  {
    informationBoard.displayInformationBoard();
  }


  public void searchTrainDepartures()
  {
    /**
    String trainNumber;
    TrainDeparture trainDeparture;
    trainNumber = userInterface.searchDepartureByTrainNumber();
    trainDeparture = informationBoard.findTrainDepartureByNumber(trainNumber);
    userInterface.displayNewTrainDepartureDetails(trainDeparture);
     **/
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
        inputHandler.getTrainNumberInput(), inputHandler.getDestinationInput(), inputHandler.getTrackInputInput(), inputHandler.getDelayInput());
    userInterface.displayNewTrainDepartureDetails(trainDeparture);
    informationBoard.addTrainDeparture(trainDeparture);
  }

  public void removeTrainDeparture()
  {

  }


}
