package edu.ntnu.stud.core;

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
  public TrainDepartureGenerator trainDepartureGenerator;

  public TrainStation() {
    this.trainDepartures = new HashMap<>();
    this.trainDepartureGenerator = new TrainDepartureGenerator(this);
    trainDepartureGenerator.generateTrainDepartures(15);
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

  public void removeExpiredTrainDepartures(LocalTime currentTime) {
    trainDepartures.entrySet().removeIf(entry -> isDepartureExpired(entry.getValue(), currentTime));
  }

  private boolean isDepartureExpired(TrainDeparture departure, LocalTime currentTime) {
    LocalTime departureTimeWithDelay = departure.getDepartureTime().plusHours(departure.getDelay().getHour())
        .plusMinutes(departure.getDelay().getMinute());

    return departureTimeWithDelay.isBefore(currentTime);
  }

    public Optional<TrainDeparture> findTrainDepartureByNumber(String trainNumber) {
      return Optional.ofNullable(trainDepartures.get(trainNumber));
    }

    public Collection<TrainDeparture> getAllDepartures() {
      return trainDepartures.values();
    }
  public List<TrainDeparture> findTrainDeparturesByDestination(String destination) {
    return trainDepartures.values().stream()
        .filter(departure -> departure.getDestination().equalsIgnoreCase(destination))
        .collect(Collectors.toList());
  }


  public int getTotalDepartures() {
    return trainDepartures.size();
  }

  public Map<String, Integer> getDeparturesByDestination() {
    Map<String, Integer> countByDestination = new HashMap<>();
    for (TrainDeparture departure : trainDepartures.values()) {
      countByDestination.merge(departure.getDestination(), 1, Integer::sum);
    }
    return countByDestination;
  }


  public Map<Integer, Integer> getDeparturesByTrack() {
    Map<Integer, Integer> countByTrack = new HashMap<>();
    for (TrainDeparture departure : trainDepartures.values()) {
      countByTrack.merge(departure.getTrack(), 1, Integer::sum);
    }
    return countByTrack;
  }

  public Map<String, Integer> getDeparturesByLine() {
    Map<String, Integer> countByLine = new HashMap<>();
    for (TrainDeparture departure : trainDepartures.values()) {
      countByLine.merge(departure.getLine(), 1, Integer::sum);
    }
    return countByLine;
  }


  public double getAverageDelay() {
    if (trainDepartures.isEmpty()) {
      return 0;
    }
    int totalDelayMinutes = trainDepartures.values().stream()
        .mapToInt(departure -> departure.getDelay().getHour() * 60 + departure.getDelay().getMinute())
        .sum();
    return (double) totalDelayMinutes / trainDepartures.size();
  }


  public double getPercentageNotDelayed() {
    if (trainDepartures.isEmpty()) {
      return 100.0;
    }
    long notDelayedCount = trainDepartures.values().stream()
        .filter(departure -> departure.getDelay().equals(LocalTime.of(0, 0)))
        .count();
    return (double) notDelayedCount / trainDepartures.size() * 100;
  }

}
