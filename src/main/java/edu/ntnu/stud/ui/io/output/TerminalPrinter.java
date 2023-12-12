package edu.ntnu.stud.ui.io.output;

public class TerminalPrinter {

  public void print(String stringToPrint) {
    System.out.println(stringToPrint);
  }

  public void printError(String stringToPrint) {
    System.err.println(stringToPrint);
  }

}
