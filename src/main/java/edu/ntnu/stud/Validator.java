package edu.ntnu.stud;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Validator {

  public static void validateTime(String timeStr) {
    try {
      LocalTime.parse(timeStr);
    }
    catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalide time format ");
    }
  }
  public static void validateTrack(String trackStr) {
    try {
      int track = Integer.parseInt(trackStr);
      if (track <= 0) {
        throw new IllegalArgumentException("Track number must be a positive ");
      }
    }
    catch (NumberFormatException e) {
      throw new IllegalArgumentException("Track number must be a number");
    }
  }
}
