import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class UI {
    LocalDate localDate = LocalDate.now();
    Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public void displayGreen(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    public void displayGreenPrint(String message) {
        System.out.print(ANSI_GREEN + message + ANSI_RESET);
    }

    public void errorRed(String message) { System.out.println(ANSI_RED + message + ANSI_RESET); }

    public void displayBlue(String message) { System.out.println(ANSI_BLUE + message + ANSI_RESET); }
    public void displayBlueHeader(String message) { System.out.println(ANSI_BLUE + "                 " + message + ANSI_RESET); }

    public void display(String message) { System.out.println(message); }

    public String getString() { String anwser = scanner.nextLine();return anwser; }

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
                "\n---------------------------------------------------------------------------------------\n" + ANSI_RESET);
    }

    public String date(){
        String formattedDate = localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        return formattedDate;
    }

    public DecimalFormat getPattern(int numbers) {
        String pattern = "###,###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String number  = decimalFormat.format(numbers);
        displayGreenPrint(number);
        return decimalFormat;
    }

    public int getScanInt() {
        return this.getScanInt("Not a valid input!");
    }
}
