package edu.ntnu.stud.core;

import java.time.LocalTime;

public class Clock {
  private LocalTime currentTime;

  public Clock() {
    this.currentTime = LocalTime.now();
  }

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
