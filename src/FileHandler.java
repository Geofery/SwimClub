import java.io.*;
import java.util.Scanner;

public class FileHandler {
  File file = new File("Members2.txt");

  private String firstName;
  private String surName;
  private String age;
  private String sex;
  private boolean membershipStatus;
  private String results;

  public void saveMember(String name, int points) {
    FileWriter fw = null;
    try {
      fw = new FileWriter(file, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    BufferedWriter bw = new BufferedWriter(fw);
    try {
      bw.write(name.replaceAll("\\[", "").replaceAll("]", "")
          .replaceAll(",", "") + " " + points);
      bw.newLine();
      bw.close();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void loadMembers(Membership membership, Member member) {

    Scanner fileReader = null;
    try {
      fileReader = new Scanner(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    while (fileReader.hasNext()) {
      firstName = fileReader.next();
      surName = fileReader.next();
      age = fileReader.next();
      sex = fileReader.next();
      membershipStatus = fileReader.nextBoolean();
      results = fileReader.next();
      member = new Member(firstName, surName, age, sex, membershipStatus, results);
      membership.ageIdentifier(member);

    }
  }
}
