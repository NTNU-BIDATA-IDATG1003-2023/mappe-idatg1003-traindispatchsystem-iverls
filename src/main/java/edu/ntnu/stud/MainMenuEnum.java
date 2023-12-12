package edu.ntnu.stud;

public enum MainMenuEnum {
  VIEW_INFORMATION_BOARD(new String[]{"view", "information", "board"}, "View Information Board"),
  SEARCH_TRAIN_DEPARTURE(new String[]{"search"}, "Search for Train Departure"),
  EDIT_TRAIN_DEPARTURE(new String[]{"edit"}, "Edit Train Departure"),
  UPDATE_TIME(new String[]{"update", "time"}, "Update Time"),
  CREATE_TRAIN_DEPARTURE(new String[]{"create", "new"}, "Create New Train Departure"),
  DELETE_TRAIN_DEPARTURE(new String[]{"delete"}, "Delete Train Departure"),
  SHOW_STATISTICS(new String[]{"statistics"}, "Show Statistics"),
  EXIT_APPLICATION(new String[]{"exit"}, "Exit Application");

  private final String[] commandWords;
  private final String fullDescription;

  MainMenuEnum(String[] commandWords, String fullDescription) {
    this.commandWords = commandWords;
    this.fullDescription = fullDescription;
  }

  public String[] getCommandWords() {
    return commandWords;
  }

  public String getFullDescription() {
    return fullDescription;
  }

  public static MainMenuEnum fromInput(String input) {
    if (input == null || input.trim().isEmpty()) {
      return null;
    }

    String normalizedInput = input.toLowerCase().replace(" ", "");

    for (MainMenuEnum option : MainMenuEnum.values()) {
      for (String word : option.getCommandWords()) {
        if (normalizedInput.contains(word.toLowerCase())) {
          return option;
        }
      }
    }
    return null;
  }
}


