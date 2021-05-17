import java.io.*;
import java.util.Scanner;

public class FileHandler {
  File file = new File("Members2.txt");

  private String firstName;
  private String surName;
  private String age;
  private String sex;
  private boolean active;
  private  String result;
  //private boolean competing;

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
      active = member.isActive();
      result = member.getResult();
     // competing = competition.isCompeting();

      bw.write(firstName.replaceAll("\\[", "").replaceAll("]", "")
          .replaceAll(",", "\t") + " " + surName + "\t\t\t" + age + "\t" + sex + "\t" + active + "\t" + result);
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
      active = fileReader.nextBoolean();

      //IF Statement som nogengange bruger result og andre
      //gange skipper den.
      result = fileReader.next();
      if (result.equals(null)) {
        member = new Member(firstName, surName, age, sex);
      } else
      member = new Member(firstName, surName, age, sex, active, result);
      membership.ageIdentifier(member);
    }
  }
}
