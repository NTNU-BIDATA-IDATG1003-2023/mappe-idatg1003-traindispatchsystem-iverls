package edu.ntnu.stud.ui;

import edu.ntnu.stud.core.TrainDeparture;
import edu.ntnu.stud.core.TrainStation;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InformationBoard {
  private TrainStation trainStation;

  public InformationBoard(TrainStation trainStation) {
    this.trainStation = trainStation;
  }

  public List<TrainDeparture> sortedDepartures() {
    Collection<TrainDeparture> departures = trainStation.getAllDepartures();
    return departures.stream()
        .sorted(Comparator.comparing(TrainDeparture::getDepartureTime))
        .collect(Collectors.toList());
  }



  public void displayInformationBoard(TrainStation trainStation) {
    List<TrainDeparture> sortedDepartures = sortedDepartures();
    for (TrainDeparture departure : sortedDepartures) {
      System.out.println("Departure time: " + departure.getDepartureTime() + ", Line: " + departure.getLine() +
          ", Train number: " + departure.getTrainNumber() + ", Destination: " + departure.getDestination() +
          ", Track: " + (departure.getTrack() > 0 ? departure.getTrack() : "Not allocated at this time") +
          ", Delay: " + (departure.getDelay().equals(LocalTime.of(0, 0)) ? "" : departure.getDelay()));
    }
  }
  public Optional<TrainDeparture> findTrainDepartureByNumber(String trainNumber) {
    return trainStation.findTrainDepartureByNumber(trainNumber);
  }

  public List<TrainDeparture> findTrainDeparturesByDestination(String destination) {
    return trainStation.findTrainDeparturesByDestination(destination);
  }

}

