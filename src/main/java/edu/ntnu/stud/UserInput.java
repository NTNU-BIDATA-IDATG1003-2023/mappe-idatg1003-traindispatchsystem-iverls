package edu.ntnu.stud;

import java.util.Scanner;

public class UserInput {
  public Scanner scanner;

  public UserInput() {
    this.scanner = new Scanner(System.in);
  }

  public String promptForInput(String message) {
    System.out.println(message);
    return scanner.nextLine();
  }

}
