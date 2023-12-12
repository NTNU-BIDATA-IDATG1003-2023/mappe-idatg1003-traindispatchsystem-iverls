package edu.ntnu.stud;

public enum TrainStationInfoEnum {
  VIEW("view"),
  SEARCH("search"),
  EDIT("edit"),
  UPDATE("update"),
  CREATE("create"),
  DELETE("delete"),
  STATISTICS("statistics"),
  EXIT("exit"),
  TRAIN_NUMBER("train number"),
  DESTINATION("destination"),
  TIME("time"),
  PLATFORM("platform"),
  UNKNOWN("unknown command");

  private final String commandString;

  TrainStationInfoEnum(String commandString) {
    this.commandString = commandString;
  }

  public String getCommandString() {
    return commandString;
  }

  public static TrainStationInfoEnum fromString(String text) {
    for (TrainStationInfoEnum command : TrainStationInfoEnum.values()) {
      if (command.commandString.equalsIgnoreCase(text)) {
        return command;
      }
    }
    return UNKNOWN; // or throw an exception if invalid input
  }
}