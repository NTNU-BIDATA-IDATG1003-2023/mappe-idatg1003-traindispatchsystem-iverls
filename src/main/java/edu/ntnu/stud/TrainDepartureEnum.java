package edu.ntnu.stud;

/**
 * Enum class responsible for allowing the user to choose option as well as allowing the user to know that the
 * selected option is as expected. This enum class is specific for the optinos available within each main menu option.
 */
public enum TrainDepartureEnum {
  SEARCH_DEPARTURE_TIME("searchdeparturetime", "Search by Departure Time"),
  SEARCH_LINE("searchline", "Search by Line"),
  SEARCH_TRAIN_NUMBER("searchtrainnumber", "Search by Train Number"),
  SEARCH_DESTINATION("searchdestination", "Search by Destination"),
  SEARCH_TRACK("searchtrack", "Search by Track"),
  SEARCH_DELAY("searchdelay", "Search by Delay"),

  // Edit options
  EDIT_DEPARTURE_TIME("editdeparturetime", "Edit Departure Time"),
  EDIT_LINE("editline", "Edit Line"),
  EDIT_TRAIN_NUMBER("edittrainnumber", "Edit Train Number"),
  EDIT_DESTINATION("editdestination", "Edit Destination"),
  EDIT_TRACK("edittrack", "Edit Track"),
  EDIT_DELAY("editdelay", "Edit Delay");

  private final String commandWord;
  private final String description;

  TrainDepartureEnum(String commandWord, String description) {
    this.commandWord = commandWord;
    this.description = description;
  }

  public String getCommandWord() {
    return commandWord;
  }

  public String getDescription() {
    return description;
  }

  /**
   * implicit constructor overwritten to better utilize javas enum functionality for parameters for each enum value.
   * this allows for user-friendly output and input to choose option.
   * @param input string that will be used to find the corresponding enum value.
   * @return the enum value which the input string corresponds to, returns null for invalid input.
   */
  public static TrainDepartureEnum fromCommandWord(String input) {
    if (input != null) {
      String normalizedInput = input.trim().toLowerCase();
      for (TrainDepartureEnum option : TrainDepartureEnum.values()) {
        if (option.getCommandWord().equals(normalizedInput)) {
          return option;
        }
      }
    }
    return null;
  }

  /**
   * toString method overwritten for simplest implementation of user-friendly output.
   * @return a string representing the TrainDepartureEnum
   */
  @Override
  public String toString() {
    return commandWord + " - " + description;
  }
}
