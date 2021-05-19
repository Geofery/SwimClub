import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
  File file = new File("NewList.txt");
  File trainings = new File("Training.txt");
  File competitions = new File("Competitions.txt");

  private String memberId;
  private String firstName;
  private String surName;
  private String age;
  private String sex;
  private boolean active;
  //.-.-.-.--.-.-.-....-.-.-.-.
  private String swimStyle;
  private String place;
  private String date;
  private String result;
  private int rank;
  private Training trainingResult;
  private Competition competitionResult;

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
      sex = member.getSex();
      active = member.isActive();
      //result = member.getResult();
      // competing = competition.isCompeting();

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
      active = fileReader.nextBoolean();
      member = new Member(memberId, firstName, surName, age, sex, active);
      membership.ageIdentifier(member);
    }
  }

  ////////////////////////////////////////////////////////////


  public void saveCompetitions(CompetitionMember competitionMember, String choice) {
    FileWriter fw = null;
    try {
      fw = new FileWriter(competitions, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    BufferedWriter bw = new BufferedWriter(fw);
    try {

      memberId = competitionMember.getMemberId();
      firstName = competitionMember.getFirstName();
      surName = competitionMember.getSurName();
      age = competitionMember.getAge();
      sex = competitionMember.getSex();
      active = competitionMember.isActive();
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
      fw = new FileWriter(competitions, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    BufferedWriter bw = new BufferedWriter(fw);
    try {
      memberId = competitionMember.getMemberId();
      firstName = competitionMember.getFirstName();
      surName = competitionMember.getSurName();
      age = competitionMember.getAge();
      sex = competitionMember.getSex();
      active = competitionMember.isActive();
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


  public void loadCompetitions(Membership membership, Competition competition, CompetitionMember competitionMember, Training training) {

    Scanner fileReader = null;
    try {
      fileReader = new Scanner(competitions);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    while (fileReader.hasNext()) {
      memberId = fileReader.next();
      firstName = fileReader.next();
      surName = fileReader.next();
      age = fileReader.next();
      sex = fileReader.next();
      active = fileReader.nextBoolean();
      swimStyle = fileReader.next();
      date = fileReader.next();
      date += fileReader.next();
      date += fileReader.next();
      result = fileReader.next();
      training = new Training(date, result);

      competitionMember = new CompetitionMember(memberId, firstName, surName, age, sex, active, swimStyle, training);
      competition.competitionResults.add(competition);
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
}
