import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
  File file = new File("NewList.txt");
  File trainings = new File("Training.txt");
  File competitionMembers = new File("CompetitionMembers.txt");

  private String memberId;
  private String firstName;
  private String surName;
  private String age;
  private String sex;
  private String active;
  //.-.-.-.--.-.-.-....-.-.-.-.
  private String swimStyle;
  private String place;
  private String date;
  private String result;
  private int rank;
  private Training trainingResult;
  private Competition competitionResult;


  //TODO FW and BW initializes at the top?? to be used in all methods?
  public void saveMember(Member member) {
    FileWriter fw = null;
    try {
      fw = new FileWriter(file, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    BufferedWriter bw = new BufferedWriter(fw);
    try {
      memberId = member.getMemberId();
      firstName = member.getFirstName();
      surName = member.getSurName();
      age = member.getAge();
      sex = member.getGender();
      active = member.getActive();

      bw.write(memberId.replaceAll("\\[", "").replaceAll("]", "")
          .replaceAll(",", "\t") + " " + firstName + " " + surName + "\t\t\t" + age + "\t" + sex + "\t" + active);
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
      memberId = fileReader.next();
      firstName = fileReader.next();
      surName = fileReader.next();
      age = fileReader.next();
      sex = fileReader.next();
      active = fileReader.next();
      member = new Member(memberId, firstName, surName, age, sex, active);
      membership.ageIdentifier(member);
    }
  }

  ////////////////////////////////////////////////////////////

//TODO Can we resuse the two methods above??
  public void saveCompetitions(CompetitionMember competitionMember, String choice) {
    FileWriter fw = null;
    try {
      fw = new FileWriter(competitionMembers, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    BufferedWriter bw = new BufferedWriter(fw);
    try {

      memberId = competitionMember.getMemberId();
      firstName = competitionMember.getFirstName();
      surName = competitionMember.getSurName();
      age = competitionMember.getAge();
      sex = competitionMember.getGender();
      active = competitionMember.getActive();
      swimStyle = choice;

      bw.write(memberId.replaceAll("\\[", "").replaceAll("]", "")
          .replaceAll(",", "\t") + " " + firstName + " " + surName + " " + age + " " + sex + " " + active + " " + swimStyle); //+ " " + place + " " + date + " " + result + " " + rank);
      bw.newLine();
      bw.close();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void saveCompetitionMember(CompetitionMember competitionMember, String choice, Training training) {
    FileWriter fw = null;
    try {
      fw = new FileWriter(competitionMembers, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    BufferedWriter bw = new BufferedWriter(fw);
    try {
      memberId = competitionMember.getMemberId();
      firstName = competitionMember.getFirstName();
      surName = competitionMember.getSurName();
      age = competitionMember.getAge();
      sex = competitionMember.getGender();
      active = competitionMember.getActive();
      swimStyle = competitionMember.getSwimStyle();
      trainingResult = competitionMember.getTrainingResult();
      competitionResult = competitionMember.getCompetitionResult();
      date = training.getDate();
      result = training.getResult();


      bw.write(memberId.replaceAll("\\[", "").replaceAll("]", "")
          .replaceAll(",", "\t") + " " + firstName + " " + surName + "\t\t" + age + "\t" + sex +
          "\t" + active + "\t" + swimStyle + "\t" + date + "\t" + result);
      bw.newLine();
      bw.close();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void loadCompetitionMembers(Membership membership, CompetitionMember competitionMember, Training training, CompetitionMembership competitionMembership) {

    Scanner fileReader = null;
    try {
      fileReader = new Scanner(competitionMembers);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    while (fileReader.hasNext()) {
      memberId = fileReader.next();
      firstName = fileReader.next();
      surName = fileReader.next();
      age = fileReader.next();
      sex = fileReader.next();
      active = fileReader.next();
      swimStyle = fileReader.next();
      date = fileReader.next();
      date += " ";
      date += fileReader.next();
      date += " ";
      date += fileReader.next();
      result = fileReader.next();
      training = new Training(date, result);


      competitionMember = new CompetitionMember(memberId, firstName, surName, age, sex, active, swimStyle, training);
      competitionMembership.ageIdentifier(competitionMember);

    }
  }

  public void saveTrainings(CompetitionMember competitionMember, Training training) {
    FileWriter fw = null;
    try {
      fw = new FileWriter(trainings, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    BufferedWriter bw = new BufferedWriter(fw);
    try {
      date = training.getDate();
      result = training.getResult();


      bw.write(date.replaceAll("\\[", "").replaceAll("]", "")
          .replaceAll(",", "\t") + " " + result);
      bw.newLine();
      bw.close();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void loadTrainings(CompetitionMember competitionMember, Training training) {

    Scanner fileReader = null;
    try {
      fileReader = new Scanner(trainings);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    while (fileReader.hasNext()) {
      date = fileReader.next();
      result = fileReader.next();

      training = new Training(date, result);
      training.trainingResults.add(training);
    }
  }

  public void refreshMembers(ArrayList<Member> allMembers){
    FileWriter fw = null;
    try {
      fw = new FileWriter(file);
    } catch (IOException e) {
      e.printStackTrace();
    }
    BufferedWriter bw = new BufferedWriter(fw);
    try {

      for (int i = 0; i < allMembers.size(); i++) {
        fw.write(allMembers.get(i).getMemberId().replaceAll("\\[", "").replaceAll("]", "")
            .replaceAll(",", "\t") + " " + allMembers.get(i).getFirstName() + " "
            + allMembers.get(i).getSurName() + "\t\t\t" +allMembers.get(i).getAge() + "\t"
            + allMembers.get(i).getGender() + "\t" + allMembers.get(i).getActive()+"\n");
      }
        fw.close();
      } catch (IOException e) {
      e.printStackTrace();
      }
  }


  public void refreshCompetitionMembers(ArrayList<CompetitionMember> allCompetitionMembers) {
    FileWriter fw = null;
    try {
      fw = new FileWriter(competitionMembers);
    } catch (IOException e) {
      e.printStackTrace();
    }
    BufferedWriter bw = new BufferedWriter(fw);
    try {

      for (int i = 0; i < allCompetitionMembers.size(); i++) {
        fw.write(allCompetitionMembers.get(i).getMemberId().replaceAll("\\[", "").replaceAll("]", "")
                .replaceAll(",", "\t") + " " + allCompetitionMembers.get(i).getFirstName() + " "
                + allCompetitionMembers.get(i).getSurName() + "\t\t\t" +allCompetitionMembers.get(i).getAge() + "\t"
                + allCompetitionMembers.get(i).getGender() + "\t" + allCompetitionMembers.get(i).getActive()+"\n");
      }
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
