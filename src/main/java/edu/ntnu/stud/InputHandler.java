package edu.ntnu.stud;

import java.time.LocalTime;

public class InputHandler {

  public TrainDeparture createTrainDeparture(String departureTimeStr, String line, String trainNumber, String destination, String trackStr, String delayStr) {
    Validator.validateTime(departureTimeStr);
    Validator.validateTrack(trackStr);
    Validator.validateTime(delayStr);

    LocalTime departureTime = LocalTime.parse(departureTimeStr);
    int track = Integer.parseInt(trackStr);
    LocalTime delay = LocalTime.parse(delayStr);

    return new TrainDeparture(departureTime, line, trainNumber, destination, track, delay);
  }
}
