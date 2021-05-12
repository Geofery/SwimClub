import java.io.*;
import java.util.Scanner;

public class FileHandler {
  File file = new File("Members2.txt");

  private String firstName;
  private String surName;
  private String age;
  private String sex;
  private boolean membershipStatus;
  private String result;

  public void saveMember(Member member) {
    FileWriter fw = null;
    try {
      fw = new FileWriter(file, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    BufferedWriter bw = new BufferedWriter(fw);
    try {

      firstName = member.getFirstName();
      surName = member.getSurName();
      age = member.getAge();
      sex = member.getSex();
      membershipStatus = member.isMembershipStatus();
      result = member.getResult();



      bw.write(firstName.replaceAll("\\[", "").replaceAll("]", "")
          .replaceAll(",", "\t") + " " + surName + "\t\t\t" + age + "\t" + sex + "\t" + membershipStatus + "\t" + result);
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
      result = fileReader.next();
      //If Statement der kigger på result er null eller har en værdi.
      member = new Member(firstName, surName, age, sex, membershipStatus, result);
      membership.ageIdentifier(member);
    }
  }
}
