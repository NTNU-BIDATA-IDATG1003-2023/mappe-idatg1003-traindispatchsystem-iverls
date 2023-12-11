package edu.ntnu.stud.core;

import edu.ntnu.stud.utility.TrainDepartureGenerator;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class TrainStation {
  public final Map<String, TrainDeparture> trainDepartures;
  public TrainDepartureGenerator trainDepartureGenerator;

  public TrainStation() {
    this.trainDepartures = new HashMap<>();
    this.trainDepartureGenerator = new TrainDepartureGenerator(this);
    trainDepartureGenerator.generateTrainDepartures(50);
  }

  public void addTrainDeparture(TrainDeparture trainDeparture) {
    String trainNumber = trainDeparture.getTrainNumber();
    if (!trainDepartures.containsKey(trainNumber)) {
      trainDepartures.put(trainNumber, trainDeparture);
    } else {

    }
  }

    public Optional<TrainDeparture> findTrainDepartureByNumber(String trainNumber) {
      return Optional.ofNullable(trainDepartures.get(trainNumber));
    }

    public Collection<TrainDeparture> getAllDepartures() {
      return trainDepartures.values();
    }
  }
