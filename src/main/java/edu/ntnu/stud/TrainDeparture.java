package edu.ntnu.stud;

import java.time.LocalTime;

/**
 * The class for an object representing a train departure.
 *
 * @author Iver Lieberg Stieng
 * @version 1.0 (23.11.01)
 */

public class TrainDeparture {

  public LocalTime departureTime;
  public String line;
  public String trainNumber;
  public String destination;
  public int track;
  public LocalTime delay;

  /**
   * Constructs and object of type trainDeparture.
   *
   * @param departureTime represents the trains time of departure in hours and minutes.
   * @param line represents the rout the train will take.
   * @param trainNumber a unique number representing a train.
   * @param destination the place where the train will travel.
   * @param track whch track the train will use.
   * @param delay how much the train is delayed.
   */

  public TrainDeparture(LocalTime departureTime, String line, String trainNumber, String destination, int track, LocalTime delay) {
    setDepartureTime(departureTime);
    setLine(line);
    setTrainNumber(trainNumber);
    setDestination(destination);
    setTrack(track);
    setDelay(delay);
  }

  public LocalTime getDepartureTime() {

    return departureTime;
  }

  public void setDepartureTime(LocalTime departureTime) {
    this.departureTime = departureTime;
  }

  public String getLine() {
    return line;
  }

  public void setLine(String line) {
    this.line = line;
  }

  public String getTrainNumber() {
    return trainNumber;
  }

  public void setTrainNumber(String trainNumber) {
    this.trainNumber = trainNumber;
  }

  public  String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public int getTrack() {
    return track;
  }

  public void setTrack(int track) {
    this.track = track;
  }

  public LocalTime getDelay() {
    return delay;
  }

  public void setDelay(LocalTime delay) {
    this.delay = delay;
  }


}
