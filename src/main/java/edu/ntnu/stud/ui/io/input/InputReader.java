package edu.ntnu.stud.ui.io.input;

import java.util.Scanner;

public class InputReader {
  private final Scanner scanner;

  public InputReader() {
    this.scanner = new Scanner(System.in);
  }

  public String promptForInput(String message) {
    System.out.println(message);
    return scanner.nextLine();
  }

  public String readUserInput() {
    return scanner.nextLine();
  }
}
