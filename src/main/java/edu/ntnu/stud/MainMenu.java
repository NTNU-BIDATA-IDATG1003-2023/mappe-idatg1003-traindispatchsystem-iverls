package edu.ntnu.stud;

public enum MainMenu {
  VIEW_INFORMATION_BOARD(1, "View information board"),
  SEARCH_TRAIN_DEPARTURE(2, "Search train departure"),
  EDIT_TRAIN_DEPARTURE(3, "Edit specified train departure"),
  UPDATE_TIME(4, "Update time"),
  CREATE_TRAIN_DEPARTURE(5, "Create new train departure"),
  DELETE_TRAIN_DEPARTURE(6, "Delete specified train departure"),
  SHOW_STATISTICS(7, "Show statistics"),
  EXIT_APPLICATION(8, "Exit application");

  private final int optionNumber;
  private final String description;

  MainMenu(int optionNumber, String description) {
    this.optionNumber = optionNumber;
    this.description = description;
  }

  public int getOptionNumber() {
    return optionNumber;
  }

  public String getDescription() {
    return description;
  }

  public static MainMenu fromOptionNumber(String optionNumberStr) {
    try {
      int optionNumber = Integer.parseInt(optionNumberStr);
      for (MainMenu option : MainMenu.values()) {
        if (option.getOptionNumber() == optionNumber) {
          return option;
        }
      }
    } catch (NumberFormatException e) {
      // Handle the case where the input is not a valid number
    }
    return null; // or throw an exception if invalid input
  }

  /**
   * Checks if the provided string corresponds to any MainMenu option.
   *
   * @param option The string representing the menu option.
   * @return true if the string is a valid menu option, false otherwise.
   */
  public static boolean containsMenuOption(String option) {
    for (MainMenu menuOption : MainMenu.values()) {
      if (option.equalsIgnoreCase(menuOption.name())) {
        return true;
      }
    }
    return false;
  }
}

