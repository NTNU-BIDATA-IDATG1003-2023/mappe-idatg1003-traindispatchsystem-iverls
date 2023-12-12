package edu.ntnu.stud.ui;

import edu.ntnu.stud.core.TrainDeparture;
import edu.ntnu.stud.core.TrainStation;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Statistics {

  private final TrainStation trainStation;
  private int totalDepartures;
  private final Map<String, Integer> departuresByDestination;
  private final Map<String, Integer> departuresByLine;
  private final Map<Integer, Integer> departuresByTrack;
  private double averageDelay;
  private double percentageOfNonDelayedDepartures;

  // Constructor
  public Statistics(TrainStation trainStation) {
    this.trainStation = trainStation;
    this.departuresByDestination = new HashMap<>();
    this.departuresByLine = new HashMap<>();
    this.departuresByTrack = new HashMap<>();
    calculateStatistics();
  }

  // Method to update statistics
  public void calculateStatistics() {
    totalDepartures = trainStation.getAllDepartures().size();
    calculateDeparturesByDestination();
    calculateDeparturesByLine();
    calculateDeparturesByTrack();
    calculateAverageDelay();
    calculatePercentageNotDelayed();
  }

  private void calculateDeparturesByDestination() {
    departuresByDestination.clear();
    for (TrainDeparture departure : trainStation.getAllDepartures()) {
      departuresByDestination.merge(departure.getDestination(), 1, Integer::sum);
    }
  }

  private void calculateDeparturesByLine() {
    departuresByLine.clear();
    for (TrainDeparture departure : trainStation.getAllDepartures()) {
      departuresByLine.merge(departure.getLine(), 1, Integer::sum);
    }
  }

  private void calculateDeparturesByTrack() {
    departuresByTrack.clear();
    for (TrainDeparture departure : trainStation.getAllDepartures()) {
      departuresByTrack.merge(departure.getTrack(), 1, Integer::sum);
    }
  }

  private void calculateAverageDelay() {
    if (totalDepartures == 0) {
      averageDelay = 0;
      return;
    }
    int totalDelayMinutes = trainStation.getAllDepartures().stream()
        .mapToInt(departure -> departure.getDelay().getHour() * 60 + departure.getDelay().getMinute())
        .sum();
    averageDelay = (double) totalDelayMinutes / totalDepartures;
  }

  private void calculatePercentageNotDelayed() {
    if (totalDepartures == 0) {
      percentageOfNonDelayedDepartures = 100.0;
      return;
    }
    long notDelayedCount = trainStation.getAllDepartures().stream()
        .filter(departure -> departure.getDelay().equals(LocalTime.of(0, 0)))
        .count();
    percentageOfNonDelayedDepartures = (double) notDelayedCount / totalDepartures * 100;
  }

  // Getters
  public int getTotalDepartures() {
    return totalDepartures;
  }

  public Map<String, Integer> getDeparturesByDestination() {
    return departuresByDestination;
  }

  public Map<String, Integer> getDeparturesByLine() {
    return departuresByLine;
  }

  public Map<Integer, Integer> getDeparturesByTrack() {
    return departuresByTrack;
  }

  public double getAverageDelay() {
    return averageDelay;
  }

  public double getPercentageNotDelayed() {
    return percentageOfNonDelayedDepartures;
  }
}

