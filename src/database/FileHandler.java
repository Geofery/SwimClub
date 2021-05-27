package database;

import membershipadministrator.CompetitionMembership;
import membershipadministrator.Membership;
import membertypes.CompetitionMember;
import membertypes.Member;
import objects.Competition;
import objects.Training;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
  File file = new File("src/database/Members.txt");
  File competitionMembers = new File("src/database/CompetitionMembers.txt");
  FileWriter fw = null;
  BufferedWriter bw = null;
  Scanner fileReader = null;

  private String memberId;
  private String firstName;
  private String surName;
  private String age;
  private String sex;
  private String active;
  private String swimStyle;
  private String trainingDate;
  private String trainingResult;
  private boolean placeholder = true;
  private int rank;

  public void saveMember(Member member) {
    try {
      fw = new FileWriter(file, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
     bw = new BufferedWriter(fw);
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

  public void saveCompetitionMember(CompetitionMember competitionMember, String choice, Training training, Competition competition) {
    try {
      fw = new FileWriter(competitionMembers, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    bw = new BufferedWriter(fw);
    try {
      memberId = competitionMember.getMemberId();
      firstName = competitionMember.getFirstName();
      surName = competitionMember.getSurName();
      age = competitionMember.getAge();
      sex = competitionMember.getGender();
      active = competitionMember.getActive();
      swimStyle = competitionMember.getSwimStyle();
      trainingDate = competitionMember.getTraining().getDate();
      trainingResult = competitionMember.getTraining().getResult();


      bw.write(memberId.replaceAll("\\[", "").replaceAll("]", "")
          .replaceAll(",", "\t") + " " + firstName + " " + surName + "\t\t" + age + "\t" + sex +
          "\t" + active + "\t" + swimStyle + "\t" + trainingDate + "\t" + trainingResult);
      bw.newLine();
      bw.close();
      fw.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void saveCompetitionToMember(CompetitionMember competitionMember, Training training, Competition competition) {
    try {
      fw = new FileWriter(competitionMembers, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    bw = new BufferedWriter(fw);
    try {
      memberId = competitionMember.getMemberId();
      firstName = competitionMember.getFirstName();
      surName = competitionMember.getSurName();
      age = competitionMember.getAge();
      sex = competitionMember.getGender();
      active = competitionMember.getActive();
      swimStyle = competitionMember.getSwimStyle();
      trainingDate = competitionMember.getTraining().getDate();
      trainingResult = competitionMember.getTraining().getResult();
      competition = competitionMember.getCompetition();



      bw.write(memberId.replaceAll("\\[", "").replaceAll("]", "")
          .replaceAll(",", "\t") + " " + firstName + " " + surName + "\t\t" + age + "\t" + sex +
          "\t" + active + "\t" + swimStyle + "\t" + trainingDate + "\t" + trainingResult + " " + placeholder + " " + competition);
      bw.newLine();
      bw.close();
      fw.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void loadCompetitionMembers(Membership membership, CompetitionMember competitionMember, Training training, CompetitionMembership competitionMembership, Competition competition) {
    try {
      fileReader = new Scanner(competitionMembers);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    while (fileReader.hasNext()) {
      rank = 0;
      memberId = fileReader.next();
      firstName = fileReader.next();
      surName = fileReader.next();
      age = fileReader.next();
      sex = fileReader.next();
      active = fileReader.next();
      swimStyle = fileReader.next();
      trainingDate = fileReader.next();
      trainingDate += " ";
      trainingDate += fileReader.next();
      trainingDate += " ";
      trainingDate += fileReader.next();
      trainingResult = fileReader.next();
      training = new Training(trainingDate, trainingResult);
      if (fileReader.hasNextBoolean()) {
        boolean placeholder = fileReader.nextBoolean();
        String place = fileReader.next();
        String competitionDate = fileReader.next();
        competitionDate += " ";
        competitionDate += fileReader.next();
        competitionDate += " ";
        competitionDate += fileReader.next();
        String competitionTime = fileReader.next();
        rank = fileReader.nextInt();
        competition = new Competition(place, competitionDate, competitionTime, rank);
      }

       if (rank >= 1) {
        competitionMember = new CompetitionMember(memberId, firstName, surName, age, sex, active, swimStyle, training, competition);
        competitionMembership.ageIdentifier(competitionMember);
      } else if (rank < 1) {
        competitionMember = new CompetitionMember(memberId, firstName, surName, age, sex, active, swimStyle, training);
        competitionMembership.ageIdentifier(competitionMember);
      }
    }
  }

  public void refreshMembers(ArrayList<Member> allMembers) {
    try {
      fw = new FileWriter(file);
    } catch (IOException e) {
      e.printStackTrace();
    }
    bw = new BufferedWriter(fw);
    try {

      for (int i = 0; i < allMembers.size(); i++) {
        fw.write(allMembers.get(i).getMemberId().replaceAll("\\[", "").replaceAll("]", "")
            .replaceAll(",", "\t") + " " + allMembers.get(i).getFirstName() + " "
            + allMembers.get(i).getSurName() + "\t\t\t" + allMembers.get(i).getAge() + "\t"
            + allMembers.get(i).getGender() + "\t" + allMembers.get(i).getActive() + "\n");
      }
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void refreshCompetitionMembers(ArrayList<CompetitionMember> allCompetitionMembers) {
    try {
      fw = new FileWriter(competitionMembers);
      fileReader = new Scanner(competitionMembers);
    } catch (IOException e) {
      e.printStackTrace();
    }
    bw = new BufferedWriter(fw);
    try {

      for (int i = 0; i < allCompetitionMembers.size(); i++) {
        if (allCompetitionMembers.get(i).getCompetition() == null) {
        fw.write(allCompetitionMembers.get(i).getMemberId().replaceAll("\\[", "").replaceAll("]", "")
            .replaceAll(",", "\t") + " " + allCompetitionMembers.get(i).getFirstName() + " "
            + allCompetitionMembers.get(i).getSurName() + "\t\t\t" + allCompetitionMembers.get(i).getAge() + "\t"
            + allCompetitionMembers.get(i).getGender() + "\t" + allCompetitionMembers.get(i).getActive() + "\t"
            + allCompetitionMembers.get(i).getSwimStyle() + "\t" + allCompetitionMembers.get(i).getTraining() + "\n");
      }else if (allCompetitionMembers.get(i).getCompetition() != null){
          fw.write(allCompetitionMembers.get(i).getMemberId().replaceAll("\\[", "").replaceAll("]", "")
              .replaceAll(",", "\t") + " " + allCompetitionMembers.get(i).getFirstName() + " "
              + allCompetitionMembers.get(i).getSurName() + "\t\t\t" + allCompetitionMembers.get(i).getAge() + "\t"
              + allCompetitionMembers.get(i).getGender() + "\t" + allCompetitionMembers.get(i).getActive() + "\t" + allCompetitionMembers.get(i).getSwimStyle() + "\t"
              + allCompetitionMembers.get(i).getTraining() + "\t" + placeholder +"\t" +  allCompetitionMembers.get(i).getCompetition() + "\n");
        }
      }

      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
