package membershipadministrator;

import database.FileHandler;
import membershipadministrator.CompetitionMembership;
import membertypes.CompetitionMember;
import membertypes.Member;
import objects.Competition;
import objects.Training;
import userinterface.SwimStyle;
import userinterface.UI;

import java.util.ArrayList;
import java.util.Collections;

//Christopher & Jeffrey
public class Membership {
  private ArrayList<Member> youthTeam = new ArrayList<>();
  private ArrayList<Member> seniorTeam = new ArrayList<>();
  private ArrayList<Member> seniorXoTeam = new ArrayList<>();
  private ArrayList<Member> passive = new ArrayList<>();
  private ArrayList<Member> allMembers = new ArrayList<>();
  private ArrayList<Member> pendingMembers = new ArrayList<>();
  private int year = 2021;
  private String memberId;

  public ArrayList<Member> getYouthTeam() {
    return youthTeam;
  }

  public ArrayList<Member> getSeniorTeam() {
    return seniorTeam;
  }

  public ArrayList<Member> getSeniorXoTeam() {
    return seniorXoTeam;
  }

  public ArrayList<Member> getPassive() {
    return passive;
  }

  public ArrayList<Member> getAllMembers() {
    return allMembers;
  }

  public ArrayList<Member> getPendingMembers() {
    return pendingMembers;
  }

  public ArrayList<Member> allMembers() {
    allMembers.addAll(youthTeam);
    allMembers.addAll(seniorTeam);
    allMembers.addAll(seniorXoTeam);
    allMembers.addAll(passive);
    return allMembers;
  }

  public void ageIdentifier(Member member) {
    int getAge = Integer.parseInt(member.getAge());
    if ((year - getAge) < 18 && member.getActive().equals("Active")) {
      youthTeam.add(member);
    } else if ((year - getAge) >= 18 && !(year - getAge > 60) && member.getActive().equals("Active")) {
      seniorTeam.add(member);
    } else if ((year - getAge) >= 60 && member.getActive().equals("Active")) {
      seniorXoTeam.add(member);
    } else {
      passive.add(member);
    }
  }

  public String generateMemberId() {
    memberId = "M";
    int randomNumber = (int) (Math.random() * 1000) + 1; //1 to 1000
    memberId += randomNumber;
    validateMemberId();
    return memberId;
  }

  public void validateMemberId() {
    for (int i = 0; i < allMembers.size(); i++) {
      if (memberId == allMembers.get(i).getMemberId()) {
        generateMemberId();
      }
    }
  }

  public void displayMembers(UI ui) {
    ui.displayBlueHeader("\nAll members\n");
    ui.displayBlue("Members\n");
    Collections.sort(allMembers, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
    for (int i = 0; i < allMembers.size(); i++) {
      ui.displayGreen(i + 1 + ". " + allMembers.get(i).toString());
    }
  }

  public void displayAllMembers(UI ui, CompetitionMembership competitionMembership) {
    ui.displayBlueHeader("All members\n");
    ui.displayBlue("Recreational members\n");
    Collections.sort(allMembers, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
    for (int i = 0; i < allMembers.size(); i++) {
      ui.displayGreen(i + 1 + ". " + allMembers.get(i).toString());
    }
    ui.displayLine();
    ui.displayBlue("\nCompetition members\n");
    Collections.sort(competitionMembership.getAllMembers(), (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
    for (int i = 0; i < competitionMembership.getAllMembers().size(); i++) {
      ui.displayGreen(i + 1 + ". " + competitionMembership.getAllMembers().get(i).toString());
    }
    ui.displayLine();
  }

  public void deleteMember(String memberId) {
    for (int i = 0; i < allMembers.size(); i++) {
      if (allMembers.get(i).getMemberId().equals(memberId)) {
        allMembers.remove(i);
      }
    }
  }

  public void validateDeleteMember(UI ui) {
    displayMembers(ui);
    ui.displayGreen("Input member ID of the member you want deleted: ");
    String memberId = ui.getString();
    while (!validateMemberId(memberId, ui)) {
      memberId = ui.getString();
    }
    deleteMember(memberId);
    ui.displayLine();
  }

  public void addNewMember(UI ui, Member member) {
    ui.displayGreen("Please enter first name");
    String firstName = ui.getString();
    ui.displayGreen("Please enter surname");
    String surName = ui.getString();
    ui.displayGreen("Please enter year of birth");
    String year = ui.getString();
    while (!validateAge(year, ui) == true) {
      ui.errorRed("You are too old or to young too be a member");
      year = ui.getString();
    }

    ui.displayGreen("Please enter gender M/F");
    String gender = validateGender(ui);

    String memberId = generateMemberId();
    ui.displayGreen("\nYour member ID is: " + memberId);
    ui.displayLine();
    member = new Member(memberId, firstName, surName, year, gender, "Active");
    pendingMembers.add(member);
  }

  public boolean validateAge(String year, UI ui) {
    int intYear = Integer.parseInt(year);
    if (intYear >= 2019 || intYear <= 1923) {
      return false;
    }
    return true;
  }

  public void pendingMembers(UI ui, FileHandler fileHandler) {
    String memberId;
    int option;
    ui.displayBlueHeader("Pending members");
    ui.displayGreen("");
    for (int i = 0; i < pendingMembers.size(); i++) {
      ui.displayGreen(pendingMembers.get(i).toString());
    }
    ui.displayGreen("\nInput member Id");
    memberId = ui.getString();
    ui.displayBlue("\nSet membership status: \n");
    ui.displayGreen("1. Accept");
    ui.errorRed("2. Deny");
    ui.displayGreen("9. Back to admin");
    option = ui.getScanInt();

    if (option == 1) {
      for (int i = 0; i < pendingMembers.size(); i++) {
        if (memberId.equals(pendingMembers.get(i).getMemberId())) {
          allMembers.add(pendingMembers.get(i));
          fileHandler.saveMember(pendingMembers.get(i));
          ageIdentifier(pendingMembers.get(i));
          pendingMembers.remove(pendingMembers.get(i));
        }
      }
    } else if (option == 2) {
      for (int i = 0; i < pendingMembers.size(); i++) {
        if (memberId.equals(pendingMembers.get(i).getMemberId())) {
          pendingMembers.remove(i);

        }
      }
    } else if (option == 9) {
    } else {
      ui.errorRed("WATER YOU SINKING ABOAT???");
      pendingMembers(ui, fileHandler);
    }
  }

  public void viewMembership(UI ui) {
    ui.displayBlueHeader("View your membership");
    ui.displayGreen("");
    ui.displayGreen("Input your member ID: ");
    String memberId = ui.getString();
    int tracker = 0;
    if (allMembers.size() == 0) {
      ui.errorRed("Your broke and going out of business!");
    } else
      for (int i = 0; i < allMembers.size(); i++) {
        if (memberId.equals(allMembers.get(i).getMemberId())) {
          ui.displayGreen(allMembers.get(i).toString());
        } else
          tracker++;
      }
    if (tracker == allMembers.size()) {
      ui.errorRed("Invalid Member ID!");
    }
    ui.displayLine();
  }

  public String validateGender(UI ui) {
    String gender;
    gender = ui.getString();
    if (gender.equals("f") || gender.equals("F") || gender.equals
        ("female") || gender.equals("Female") || gender.equals("FEMALE")) {
      gender = "Female";
      return gender;
    } else if (gender.equals("m") || gender.equals("M") || gender.equals
        ("male") || gender.equals("Male") || gender.equals("MALE")) {
      gender = "Male";
      return gender;
    }
    ui.errorRed("Invalid gender");
    return validateGender(ui);
  }

  public void changeMembershipStatus(UI ui, FileHandler fileHandler) {
    displayMembers(ui);
    ui.displayGreen("Set membership status: ");
    ui.displayGreen("1. Active");
    ui.displayGreen("2. Passive");
    ui.displayGreen("9. Back to admin");
    int choice = ui.getScanInt();
    String memberId;
    if (choice == 1) {
      ui.displayGreen("Enter member Id: ");
      memberId = ui.getString();
      for (int i = 0; i < allMembers.size(); i++) {
        if (allMembers.get(i).getMemberId().equals(memberId)) {
          allMembers.get(i).setActive("Active");
        }
      }
      fileHandler.refreshMembers(allMembers);
    } else if (choice == 2) {
      ui.displayGreen("Enter member Id: ");
      memberId = ui.getString();
      for (int i = 0; i < allMembers.size(); i++) {
        if (allMembers.get(i).getMemberId().equals(memberId)) {
          allMembers.get(i).setActive("Passive");
        }
      }
      fileHandler.refreshMembers(allMembers);
    } else if (choice == 9) {
    } else {
      ui.errorRed("WATER YOU SINKING ABOAT???");
      changeMembershipStatus(ui, fileHandler);
    }
  }

  public void convertToCompetitionMember(UI ui, Training training, FileHandler fileHandler, CompetitionMember competitionMember, Competition competition) {
    displayMembers(ui);
    ui.displayGreen("Input member Id");
    String memberId = ui.getString();
    while (!validateMemberId(memberId, ui)) {
      memberId = ui.getString();
    }

    ui.displayGreen("What swimstyle, do you want to the member to compete in?");
    ui.displayGreen("1. Frontcrawl: \n2. Backstroke: \n3. Breaststroke: \n4. Butterfly  \n9. to go back\n");
    int coachChoice = ui.getScanInt();
    ui.displayGreen("Enter training result in format **,**");
    String result = ui.getString();
    String choice = "";

    if (coachChoice == 1) {
      choice = SwimStyle.Frontcrawl.toString();
      ui.displayGreen(choice);
    } else if (coachChoice == 2) {
      choice = SwimStyle.Backstroke.toString();
    } else if (coachChoice == 3) {
      choice = SwimStyle.Breaststroke.toString();
    } else if (coachChoice == 4) {
      choice = SwimStyle.Butterfly.toString();
    }

    if (validateMemberAge(memberId, ui) == true) {
      training = new Training(ui.date(), result);
      for (int i = 0; i < getAllMembers().size(); i++) {
        if (getAllMembers().get(i).getMemberId().equals(memberId)) {
          competitionMember = new CompetitionMember(getAllMembers().get(i).getMemberId().replaceAll("M", "C"),
              getAllMembers().get(i).getFirstName(), getAllMembers().get(i).getSurName(),
              getAllMembers().get(i).getAge(), getAllMembers().get(i).getGender(),
              getAllMembers().get(i).getActive(), choice, training);
          deleteMember(memberId);
          fileHandler.saveCompetitionMember(competitionMember, choice, training, competition);
          fileHandler.refreshMembers(getAllMembers());
          ui.displayLine();
        }
      }
    }
  }

  public boolean validateMemberAge(String memberId, UI ui) {
    int validateAge = 1961;
    for (int i = 0; i < allMembers.size(); i++) {
      if (allMembers.get(i).getMemberId().equals(memberId) && Integer.parseInt(allMembers.get(i).getAge()) > validateAge) {
        return true;
      }
    }
    ui.errorRed("Member is to old to compete!");
    return false;
  }

  public boolean validateMemberId(String memberId, UI ui) {
    if (memberId.startsWith("M")) {
      return true;
    } else
      ui.errorRed("Invalid input");
    return false;
  }
}