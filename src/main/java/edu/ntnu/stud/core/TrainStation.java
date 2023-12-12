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

/**
 * Class that represents a train station with several train departures.
 */
public class TrainStation {
  private final Map<String, TrainDeparture> trainDepartures;
  private final Clock currentTime;
  public final Statistics stationStatistics;

  /**
   * Constructor for train station.
   */
  public TrainStation() {
    this.trainDepartures = new HashMap<>();
    this.currentTime = new Clock();
    TrainDepartureGenerator trainDepartureGenerator = new TrainDepartureGenerator(this);
    trainDepartureGenerator.generateTrainDepartures(15);
    this.stationStatistics = new Statistics(this);
  }

  /**
   * Add a train departure.
   * @param trainDeparture train departure to be added.
   */
  public void addTrainDeparture(TrainDeparture trainDeparture) {
    String trainNumber = trainDeparture.getTrainNumber();
    if (!trainDepartures.containsKey(trainNumber)) {
      trainDepartures.put(trainNumber, trainDeparture);
    }
  }

  /**
   * remove train departure
   * @param trainNumber train number of the departure that is to be removed.
   */
  public void removeTrainDeparture(String trainNumber) {
      trainDepartures.remove(trainNumber);
  }

  /**
   * Updates current time
   * @param newTime the new time
   */
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

  /**
   * Get the current time of the station.
   * @return returns the current time of the station.
   */
  public LocalTime getCurrentTime() {
    return currentTime.getCurrentTime();
  }


  /**
   * Get all the train departures in this train station.
   * @return all the train departures.
   */
  public Collection<TrainDeparture> getAllDepartures() {
    return trainDepartures.values();
  }
  public List<TrainDeparture> findTrainDeparturesByDepartureTime(LocalTime departureTime) {
    return trainDepartures.values().stream()
        .filter(departure -> departure.getDepartureTime().equals(departureTime))
        .collect(Collectors.toList());
  }

  /**
   * Find the train departures by line.
   * @param line line
   * @return the train departures as a list.
   */
  public List<TrainDeparture> findTrainDeparturesByLine(String line) {
    return trainDepartures.values().stream()
        .filter(departure -> departure.getLine().equalsIgnoreCase(line))
        .collect(Collectors.toList());
  }

  /**
   * Find train departure by train number.
   * @param trainNumber train number
   * @return optional containing the train departure if it is present.
   */
  public Optional<TrainDeparture> findTrainDepartureByNumber(String trainNumber) {
      return Optional.ofNullable(trainDepartures.get(trainNumber));
    }

  /**
   * Find the train departures by destinatino.
   * @param destination destination
   * @return list of train departures.
   */
  public List<TrainDeparture> findTrainDeparturesByDestination(String destination) {
    return trainDepartures.values().stream()
        .filter(departure -> departure.getDestination().equalsIgnoreCase(destination))
        .collect(Collectors.toList());
  }

  /**
   * Find train departures by track
   * @param trackNumber track number
   * @return list of train departures.
   */
  public List<TrainDeparture> findTrainDeparturesByTrack(int trackNumber) {
    return trainDepartures.values().stream()
        .filter(departure -> departure.getTrack() == trackNumber)
        .collect(Collectors.toList());
  }

  /**
   * Find train departures by delay.
   * @param delay the delay.
   * @return list of train departures.
   */
  public List<TrainDeparture> findTrainDeparturesByDelay(LocalTime delay) {
    return trainDepartures.values().stream()
        .filter(departure -> departure.getDelay().equals(delay))
        .collect(Collectors.toList());
  }


  /**
   * get the station statistics.
   * @return the station statistics.
   */
  public Statistics getStationStatistics() {
    return stationStatistics;
  }
}
