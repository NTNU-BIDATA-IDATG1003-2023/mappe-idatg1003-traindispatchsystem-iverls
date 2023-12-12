package edu.ntnu.stud;

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

  @Override
  public String toString() {
    return commandWord + " - " + description;
  }
}
