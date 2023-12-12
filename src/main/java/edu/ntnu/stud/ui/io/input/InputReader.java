package edu.ntnu.stud.ui.io.input;

import java.util.Scanner;

/**
 * Class that handles input from the user by using the java class Scanner.
 */
public class InputReader {
  private final Scanner scanner;

  /**
   * Constructor that initiates the scanner that is to be used for the input from the terminal.
   * InputReader uses scanner that handles input from System.in.
   */
  public InputReader() {
    this.scanner = new Scanner(System.in);
  }

  /**
   * Read the user input.
   * @return the string representing the user's input.jk
   */
  public String readUserInput() {
    return scanner.nextLine();
  }
}
