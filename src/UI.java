import java.text.DecimalFormat;
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

    public void errorRed(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    public String getString() {
        String anwser = scanner.nextLine();
        return anwser;
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

    public DecimalFormat getPattern(int message) {
        String pattern = "#,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        decimalFormat.setGroupingSize(4);

        String number = decimalFormat.format(123456789.123);
       // System.out.println(number);
        return decimalFormat;
    }

    public int getScanInt() {
        return this.getScanInt("Not a valid input!");
    }
}
