import java.io.*;
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
  private Training trainingResult;
  private Competition competitionResult;
  private String place;
  private String date;
  private String result;
  private int rank;

  public void saveMember(CasualMember casualMember) {
    FileWriter fw = null;
    try {
      fw = new FileWriter(file, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    BufferedWriter bw = new BufferedWriter(fw);
    try {
      memberId = casualMember.getMemberId();
      firstName = casualMember.getFirstName();
      surName = casualMember.getSurName();
      age = casualMember.getAge();
      sex = casualMember.getSex();
      active = casualMember.isActive();
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

  public void loadMembers(Membership membership, CasualMember casualMember) {

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
      new CasualMember(memberId, firstName, surName, age, sex, active);
      membership.ageIdentifier(casualMember);
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

      swimStyle = choice;
           /* place = competitionMember.getPlace();
            date = competitionMember.getDate();
            result = competitionMember.getResult();
            rank = competitionMember.getRank();*/


      bw.write(swimStyle.replaceAll("\\[", "").replaceAll("]", "")
          .replaceAll(",", "\t") + " " + place + "\t\t\t" + date + "\t" + result + "\t" + rank);
      bw.newLine();
      bw.close();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void loadCompetitions(Membership membership, Competition competition, CompetitionMember competitionMember) {

    Scanner fileReader = null;
    try {
      fileReader = new Scanner(competitions);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    while (fileReader.hasNext()) {
      swimStyle = fileReader.next();
      place = fileReader.next();
      date = fileReader.next();
      result = fileReader.next();
      rank = fileReader.nextInt();

      competition = new Competition(swimStyle, place, date, result, rank);
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
