import java.util.Scanner;

public class UI {
  Scanner scanner = new Scanner(System.in);
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";

  public void displayGreen(String message) {
    System.out.println(ANSI_GREEN + message + ANSI_RESET);
  }

  public void display(String message) {
    System.out.println(message);
  }

  public void errorRed(String message){
    System.out.println(ANSI_RED + message + ANSI_RESET);
  }

  /*public String getString() {
    String anwser = scanner.nextLine();
    return anwser;
  }*/
  public String getString() {
    String answer = scanner.nextLine();
    if (answer.contains(" "))
      answer = answer.replaceAll(" ", "");
    return answer;
  }

  public int getScanInt(String errorMessage) {
    while (!scanner.hasNextInt()) {
      errorRed(errorMessage);
      scanner.next();
    }
    int readInt = scanner.nextInt();
    scanner.nextLine();
    return readInt;
  }

  public int getScanInt() {
    return this.getScanInt("Not a valid input!");
  }
}
