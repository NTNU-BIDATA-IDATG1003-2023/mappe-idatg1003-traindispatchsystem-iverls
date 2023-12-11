package edu.ntnu.stud.utility;

import edu.ntnu.stud.core.TrainDeparture;
import edu.ntnu.stud.core.TrainStation;
import java.time.LocalTime;
import java.util.Random;

public class TrainDepartureGenerator {

  private TrainStation trainStation;
  private final Random random;

  private final String[] destinations = {"Oslo", "Gjovik", "Trondheim", "Bergen", "Halden"};
  public TrainDepartureGenerator(TrainStation trainStation) {
    this.trainStation = trainStation;
    this.random = new Random();
  }

  public void generateTrainDepartures(int numberOfDepartures) {
    for (int i = 0; i < numberOfDepartures; i++) {
      TrainDeparture departure = createRandomTrainDeparture();
      trainStation.addTrainDeparture(departure);
    }
  }

  private TrainDeparture createRandomTrainDeparture() {
    String trainNumber = String.valueOf(random.nextInt(1000));
    LocalTime departureTime = LocalTime.of(random.nextInt(24), random.nextInt(60));
    String line = "L" + (random.nextInt(5) + 1);
    String destination = destinations[random.nextInt(destinations.length)];
    int track = random.nextInt(3) + 1;
    LocalTime delay = LocalTime.of(0, random.nextInt(60));

    return new TrainDeparture(departureTime, line, trainNumber, destination, track, delay);
  }
}
