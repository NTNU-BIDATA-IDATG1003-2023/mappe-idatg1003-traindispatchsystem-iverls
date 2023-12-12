package edu.ntnu.stud.core;

import java.time.LocalTime;

/**
 * Class responsible for handling the time management used by the TrainStation class.
 */
public class Clock {
  private LocalTime currentTime;

  public Clock() {
    this.currentTime = LocalTime.now();
  }

  /**
   * Sets the current time.
   * @param newTime the new time.
   */
  public void setCurrentTime(LocalTime newTime) {
    if (newTime.isAfter(currentTime)) {
      this.currentTime = newTime;
    } else {
      throw new IllegalArgumentException("This time has already pasted");
    }
  }

  public LocalTime getCurrentTime() {
    return currentTime;
  }
}
