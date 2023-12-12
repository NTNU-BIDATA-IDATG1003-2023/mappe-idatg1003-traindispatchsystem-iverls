package edu.ntnu.stud.core;

import edu.ntnu.stud.ui.Statistics;
import edu.ntnu.stud.utility.TrainDepartureGenerator;
import java.time.LocalTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class TrainStation {
  public final Map<String, TrainDeparture> trainDepartures;
  private Clock currentTime;
  public TrainDepartureGenerator trainDepartureGenerator;
  private final Statistics stationStatistics;

  public TrainStation() {
    this.trainDepartures = new HashMap<>();
    this.currentTime = new Clock();
    this.trainDepartureGenerator = new TrainDepartureGenerator(this);
    trainDepartureGenerator.generateTrainDepartures(15);
    this.stationStatistics = new Statistics(this);
  }

  public void addTrainDeparture(TrainDeparture trainDeparture) {
    String trainNumber = trainDeparture.getTrainNumber();
    if (!trainDepartures.containsKey(trainNumber)) {
      trainDepartures.put(trainNumber, trainDeparture);
    } else {

    }
  }
  public void removeTrainDeparture(String trainNumber) {
    if (trainDepartures.containsKey(trainNumber)) {
      trainDepartures.remove(trainNumber);
    } else {

    }
  }

  public void updateCurrentTime(LocalTime newTime) {

      currentTime.setCurrentTime(newTime);

      trainDepartures.entrySet().removeIf(entry -> {
        TrainDeparture departure = entry.getValue();
        LocalTime departureTimeWithDelay = departure.getDepartureTime()
            .plusHours(departure.getDelay().getHour())
            .plusMinutes(departure.getDelay().getMinute());

        return departureTimeWithDelay.isBefore(currentTime.getCurrentTime());
      });
  }

  public LocalTime getCurrentTime() {
    return currentTime.getCurrentTime();
  }


  public Collection<TrainDeparture> getAllDepartures() {
    return trainDepartures.values();
  }
  public List<TrainDeparture> findTrainDeparturesByDepartureTime(LocalTime departureTime) {
    return trainDepartures.values().stream()
        .filter(departure -> departure.getDepartureTime().equals(departureTime))
        .collect(Collectors.toList());
  }
  public List<TrainDeparture> findTrainDeparturesByLine(String line) {
    return trainDepartures.values().stream()
        .filter(departure -> departure.getLine().equalsIgnoreCase(line))
        .collect(Collectors.toList());
  }

  public Optional<TrainDeparture> findTrainDepartureByNumber(String trainNumber) {
      return Optional.ofNullable(trainDepartures.get(trainNumber));
    }
  public List<TrainDeparture> findTrainDeparturesByDestination(String destination) {
    return trainDepartures.values().stream()
        .filter(departure -> departure.getDestination().equalsIgnoreCase(destination))
        .collect(Collectors.toList());
  }

  public List<TrainDeparture> findTrainDeparturesByTrack(int trackNumber) {
    return trainDepartures.values().stream()
        .filter(departure -> departure.getTrack() == trackNumber)
        .collect(Collectors.toList());
  }
  public List<TrainDeparture> findTrainDeparturesByDelay(LocalTime delay) {
    return trainDepartures.values().stream()
        .filter(departure -> departure.getDelay().equals(delay))
        .collect(Collectors.toList());
  }


  public Statistics getStationStatistics() {
    return stationStatistics;
  }



}
