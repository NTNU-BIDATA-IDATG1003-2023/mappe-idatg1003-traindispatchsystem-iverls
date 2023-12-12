package edu.ntnu.stud;
import edu.ntnu.stud.core.TrainDeparture;
import edu.ntnu.stud.core.TrainStation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TrainStationTest {

    TrainDeparture trainDeparture;
    TrainStation trainStation;
    @BeforeEach
    void beforeEach(){
        trainStation = new TrainStation();
        trainDeparture = new TrainDeparture(LocalTime.parse("22:05"),
                "L1", "64", "Oslo s", 2, LocalTime.parse("00:01"));
    }

    @Test
    void addTrainDeparture() {
        trainStation.addTrainDeparture(trainDeparture);

        assertTrue(trainStation.getAllDepartures().contains(trainDeparture));
    }

    @Test
    void removeTrainDeparture() {
        String trainNumber = "64";

        trainStation.addTrainDeparture(trainDeparture);
        trainStation.removeTrainDeparture(trainNumber);

        assertFalse(trainStation.getAllDepartures().contains(trainDeparture));
    }

    @Test
    void updateCurrentTime() {
        TrainStation trainStation = new TrainStation();
        LocalTime initialTime = trainStation.getCurrentTime();

        trainStation.updateCurrentTime(initialTime.plusMinutes(30));

        assertNotEquals(initialTime, trainStation.getCurrentTime());
        assertEquals(initialTime.plusMinutes(30), trainStation.getCurrentTime());
    }

    @Test
    void findTrainDepartureByNumber() {
        String trainNumber = "64";

        trainStation.addTrainDeparture(trainDeparture);
        trainStation.addTrainDeparture(new TrainDeparture(LocalTime.parse("22:05"),
                "L1", "100", "Oslo s", 2, LocalTime.parse("00:01")));

        Optional<TrainDeparture> foundDeparture = trainStation.findTrainDepartureByNumber(trainNumber);

        assertTrue(foundDeparture.isPresent());
        assertEquals(trainDeparture, foundDeparture.get());
        assertFalse(trainStation.findTrainDepartureByNumber("99").isPresent());
    }
    @Test
    void findTrainDeparturesByDepartureTime() {
        TrainStation trainStation = new TrainStation();
        TrainDeparture trainDeparture2 = new TrainDeparture(LocalTime.parse("22:05"),
                "L1", "100", "Oslo s", 2, LocalTime.parse("00:01"));
        LocalTime departureTime = trainDeparture.getDepartureTime();

        trainStation.addTrainDeparture(trainDeparture);
        trainStation.addTrainDeparture(trainDeparture2);

        List<TrainDeparture> departuresByTime = trainStation.findTrainDeparturesByDepartureTime(departureTime);

        assertTrue(departuresByTime.contains(trainDeparture));
        assertTrue(departuresByTime.contains(trainDeparture2));
    }

    @Test
    void findTrainDeparturesByLine() {
        TrainStation trainStation = new TrainStation();
        TrainDeparture trainDeparture2 = new TrainDeparture(LocalTime.parse("22:05"),
                "L1", "100", "Oslo s", 2, LocalTime.parse("00:01"));
        String line = trainDeparture.getLine();

        trainStation.addTrainDeparture(trainDeparture);
        trainStation.addTrainDeparture(trainDeparture2);

        List<TrainDeparture> departuresByLine = trainStation.findTrainDeparturesByLine(line);

        assertTrue(departuresByLine.contains(trainDeparture));
        assertTrue(departuresByLine.contains(trainDeparture2));
    }

    @Test
    void findTrainDeparturesByDestination() {
        TrainStation trainStation = new TrainStation();
        TrainDeparture trainDeparture2 = new TrainDeparture(LocalTime.parse("22:05"),
                "L1", "100", "Oslo s", 2, LocalTime.parse("00:01"));
        String destination = trainDeparture.getDestination();

        trainStation.addTrainDeparture(trainDeparture);
        trainStation.addTrainDeparture(trainDeparture2);

        List<TrainDeparture> departuresByDestination = trainStation.findTrainDeparturesByDestination(destination);

        assertTrue(departuresByDestination.contains(trainDeparture));
        assertTrue(departuresByDestination.contains(trainDeparture2));
    }

}
