import java.text.DecimalFormat;
import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public void displayGreen(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    public void display(String message) {
        System.out.println(message);
    }

    public void errorRed(String message) { System.out.println(ANSI_RED + message + ANSI_RESET); }

    public void displayBlue(String message) { System.out.println(ANSI_BLUE + message + ANSI_RESET); }

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

    public void displayLine() {
        System.out.println(ANSI_PURPLE +
                "---------------------------------------------------------------------------------------" + ANSI_RESET);
    }


    public DecimalFormat getPattern(int numbers) {
        String pattern = "#.###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        decimalFormat.setGroupingSize(4);

        String number  = decimalFormat.format(numbers);
        displayGreen(number);
        return decimalFormat;
    }

    public int getScanInt() {
        return this.getScanInt("Not a valid input!");
    }
}
