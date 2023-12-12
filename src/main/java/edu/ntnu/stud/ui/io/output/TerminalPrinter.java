package edu.ntnu.stud.ui.io.output;

/**
 * Class responsible for printing to the terminal.
 */
public class TerminalPrinter {

  public void print(String stringToPrint) {
    System.out.println(stringToPrint);
  }

  public void printError(String stringToPrint) {
    System.err.println(stringToPrint);
  }

}
