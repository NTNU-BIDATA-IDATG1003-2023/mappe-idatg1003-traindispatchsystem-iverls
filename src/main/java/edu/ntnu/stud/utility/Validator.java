package edu.ntnu.stud.utility;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class Validator {

  public static boolean validateTime(String timeStr) {
    try {
      LocalTime.parse(timeStr);
      return true;
    }
    catch (DateTimeParseException e) {
      return false;
    }
  }
  public static boolean validateTrack(String trackStr) {
    try {
      int track = Integer.parseInt(trackStr);
      if (track <= 0) {
        return false;
      }
      else {
        return true;
      }
    }
    catch (NumberFormatException e) {
      return false;
    }
  }

  public static boolean validateString(String userInput) {
    return !Objects.equals(userInput, "");
  }

  public static boolean validateTrainNumber(String userInput) {
    return !Objects.equals(userInput, "");
  }
}
