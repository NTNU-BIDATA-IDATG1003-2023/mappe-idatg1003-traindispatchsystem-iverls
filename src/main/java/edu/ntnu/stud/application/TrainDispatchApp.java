package edu.ntnu.stud.application;

import edu.ntnu.stud.ui.UserInteraction;

/**
 * This is the main class for the train dispatch application.
 */
public class TrainDispatchApp {

  /**
   * Main function that initiates the program.
   * @param args the arguments the user may add, however, this program does not expect any arguments from the user.
   */
  public static void main(String[] args) {
    UserInteraction userInteraction = new UserInteraction();
    userInteraction.StartUI();

  }
}
