import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

  public class FileHandler {
    UI ui = new UI();
    File file = new File("Members.txt");
    private String name;
    private int score;

    public void saveScore(String name, int points) {
      FileWriter fw = null;
      try {
        fw = new FileWriter(file, true);
      } catch (IOException e) {
        e.printStackTrace();
        System.out.println("test");
      }
      BufferedWriter bw = new BufferedWriter(fw);
      try {
        bw.write(name.replaceAll("\\[", "").replaceAll("]", "")
            .replaceAll(",", "") + " " + points );
        bw.newLine();
        bw.close();
        fw.close();
      } catch (IOException e) {
        e.printStackTrace();
        System.out.println("test2");
      }
    }

    public void loadScores()  {
      Scanner fileReader = null;
      try {
        fileReader = new Scanner(file);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      ui.displayGreen("Name   Win streak ");
      ui.display("______________________");


      while (fileReader.hasNext()) {
        name = fileReader.next();
        score = fileReader.nextInt();
      }
    }
  }
