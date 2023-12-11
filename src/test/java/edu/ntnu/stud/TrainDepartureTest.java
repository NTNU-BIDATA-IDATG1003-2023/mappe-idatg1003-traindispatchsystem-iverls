package edu.ntnu.stud;

import static org.junit.jupiter.api.Assertions.*;

import edu.ntnu.stud.core.TrainDeparture;
import java.time.LocalTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainDepartureTest {

  TrainDeparture trainDeparture;
  @BeforeEach
  void setUp() {
    trainDeparture = new TrainDeparture(LocalTime.parse("22:05"), "L1", "64", "Oslo s", 2, LocalTime.parse("00:01"));

  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void getDepartureTime() {
    assertEquals(LocalTime.parse("22:05"), trainDeparture.getDepartureTime());
    assertNotEquals(LocalTime.parse("22:06"), trainDeparture.getDepartureTime());
  }

  @Test
  void setDepartureTime() {
    trainDeparture.setDepartureTime(LocalTime.parse("22:06"));
    assertEquals(LocalTime.parse("22:06"), trainDeparture.getDepartureTime());
    assertNotEquals(LocalTime.parse("22:05"), trainDeparture.getDepartureTime());
  }

  @Test
  void getLine() {
    assertEquals("L1", trainDeparture.getLine());
    assertNotEquals("L2", trainDeparture.getLine());
  }

  @Test
  void setLine() {
    trainDeparture.setLine("L2");
    assertEquals("L2", trainDeparture.getLine());
    assertNotEquals("L1", trainDeparture.getLine());
  }

  @Test
  void getTrainNumber() {
    assertEquals("64", trainDeparture.getTrainNumber());
    assertNotEquals("62", trainDeparture.getTrainNumber());
  }

  @Test
  void setTrainNumber() {
    trainDeparture.setTrainNumber("62");
    assertEquals("62", trainDeparture.getTrainNumber());
    assertNotEquals("64", trainDeparture.getTrainNumber());
  }

  @Test
  void getDestination() {
    assertEquals("Oslo s", trainDeparture.getDestination());
    assertNotEquals("Jaren", trainDeparture.getDestination());
  }

  @Test
  void setDestination() {
    trainDeparture.setDestination("Jaren");
    assertEquals("Jaren", trainDeparture.getDestination());
    assertNotEquals("Oslo s", trainDeparture.getDestination());
  }

  @Test
  void getTrack() {
    assertEquals(2, trainDeparture.getTrack());
    assertNotEquals(1, trainDeparture.getTrack());
  }

  @Test
  void setTrack() {
    trainDeparture.setTrack(1);
    assertEquals(1, trainDeparture.getTrack());
    assertNotEquals(2, trainDeparture.getTrack());
  }

  @Test
  void getDelay() {
    assertEquals(LocalTime.parse("00:01"), trainDeparture.getDelay());
    assertNotEquals(LocalTime.parse("00:03"), trainDeparture.getDelay());
  }

  @Test
  void setDelay() {
    trainDeparture.setDelay(LocalTime.parse("00:03"));
    assertEquals(LocalTime.parse("00:03"), trainDeparture.getDelay());
    assertNotEquals(LocalTime.parse("00:01"), trainDeparture.getDelay());
  }
}