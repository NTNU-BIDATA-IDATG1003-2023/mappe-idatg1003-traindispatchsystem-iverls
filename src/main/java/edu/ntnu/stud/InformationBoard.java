package edu.ntnu.stud;

import java.util.ArrayList;
import java.util.Optional;

public class InformationBoard {

  UserInterface userInterface = new UserInterface();

  ArrayList<TrainDeparture> trainDepartures = new ArrayList<TrainDeparture>();

  public void addTrainDeparture(TrainDeparture trainDeparture) {
    trainDepartures.add(trainDeparture);
  }

  public void displayInformationBoard() {
    for (TrainDeparture departure : trainDepartures) {
      userInterface.displayNewTrainDepartureDetails(departure);
    }
  }

  public TrainDeparture findTrainDepartureByNumber(String trainNumber) {
    for (TrainDeparture departure : trainDepartures) {
      if (departure.getTrainNumber().equals(trainNumber)) {
        return departure;
      }
    }
    return null;
  }

}
