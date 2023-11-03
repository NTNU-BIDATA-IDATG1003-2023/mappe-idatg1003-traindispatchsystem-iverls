package edu.ntnu.stud;

public class UserInteraction {

  public void Start() {
    UserInterface userInterface = new UserInterface();
    InformationBoard informationBoard = new InformationBoard();
    boolean isRunning = true;

    while (isRunning) {
      String input = userInterface.displayMainMenu();

      switch (input) {

        case "1":

          TrainDeparture trainDeparture;

          trainDeparture = userInterface.newTrainDeparture();
          userInterface.displayNewTrainDepartureDetails(trainDeparture);
          informationBoard.addTrainDeparture(trainDeparture);

          break;

        case "2":
          informationBoard.displayInformationBoard();

          break;

        case "3":
          String trainNumber;

          trainNumber = userInterface.searchDepartureByTrainNumber();
          trainDeparture = informationBoard.findTrainDepartureByNumber(trainNumber);
          userInterface.displayNewTrainDepartureDetails(trainDeparture);

          break;

        case "4":
          userInterface.exitMessage();
          isRunning = false;
      }
    }


  }


}
