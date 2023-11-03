package edu.ntnu.stud;

public class UserInteraction {

  public void Start() {
    UserInterface userInterface = new UserInterface();
    boolean isRunning = true;

    while (isRunning) {
      String input = userInterface.displayMainMenu();

      switch (input) {

        case "1":

          TrainDeparture trainDeparture;

          trainDeparture = userInterface.newTrainDeparture();
          userInterface.displayNewTrainDepartureDetails(trainDeparture);

          break;

        case "2":
          userInterface.exitMessage();
          isRunning = false;
      }
    }


  }


}
