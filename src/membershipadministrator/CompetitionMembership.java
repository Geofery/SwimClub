package membershipadministrator;

import database.FileHandler;
import membertypes.CompetitionMember;
import objects.Competition;
import objects.Training;
import userinterface.SwimStyle;
import userinterface.UI;
import java.util.ArrayList;
import java.util.Collections;

//Christopher & Jeffrey
public class CompetitionMembership {

  private ArrayList<CompetitionMember> youthTeam = new ArrayList<>();
  private ArrayList<CompetitionMember> seniorTeam = new ArrayList<>();
  private ArrayList<CompetitionMember> allMembers = new ArrayList<>();
  private int year = 2021;

  public ArrayList<CompetitionMember> getAllMembers() {
    return allMembers;
  }

  public void ageIdentifier(CompetitionMember competitionMember) {
    int getAge = Integer.parseInt(competitionMember.getAge());
    if ((year - getAge) < 18) {
      youthTeam.add(competitionMember);
    } else if ((year - getAge) >= 18) {
      seniorTeam.add(competitionMember);
    }
  }

  public ArrayList<CompetitionMember> allMembers() {
    allMembers.addAll(youthTeam);
    allMembers.addAll(seniorTeam);
    return allMembers;
  }

  public void swimStyleIdentifier(UI ui, String choice) {
    ui.displayBlueHeader(choice + " Competition swimmers: ");
    ui.displayGreen("");
    ui.displayBlue("Youth team");
    for (int i = 0; i < youthTeam.size(); i++) {
      int age = Integer.parseInt(youthTeam.get(i).getAge());
      if (youthTeam.get(i).getSwimStyle().equals(choice)) {
        ui.displayGreen(youthTeam.get(i).toString());
      }
    }
    ui.displayBlue("Senior Team");
    for (int i = 0; i < seniorTeam.size(); i++) {
      int age = Integer.parseInt(seniorTeam.get(i).getAge());
      if (seniorTeam.get(i).getSwimStyle().equals(choice)) {
        ui.displayGreen(seniorTeam.get(i).toString());
      }
    }
    ui.displayLine();
  }

  public void showSwimTeam(UI ui) {
    ui.displayBlueHeader("Competition swimmers");
    ui.displayGreen("");
    ui.displayLine();
    ui.displayBlue("Youth team");
    ui.displayGreen("");

    for (int i = 0; i < allMembers.size(); i++) {
      int age = Integer.parseInt(allMembers.get(i).getAge());
      if (18 > year - age) {
        ui.displayGreen(allMembers.get(i).toString());
      }
    }
    ui.displayGreen("");
    ui.displayLine();
    ui.displayBlue("Senior team");
    ui.displayGreen("");

    for (int i = 0; i < allMembers.size(); i++) {
      int age = Integer.parseInt(allMembers.get(i).getAge());
      if (18 < year - age) {
        ui.displayGreen(allMembers.get(i).toString());
      }
    }
    ui.displayLine();
  }

  public void competitionResults(UI ui, Competition competition) {
    ui.displayBlueHeader("Top 5 competition swimmers");
    ui.displayBlue("\n Youth team\n");
    for (int i = 0; i < youthTeam.size(); i++) {
      if (youthTeam.get(i).getCompetition() != competition){
        ui.displayGreen(youthTeam.get(i).toString());
      }
    }
    ui.displayLine();
    ui.displayBlue("\n Senior team\n");
    for (int i = 0; i < seniorTeam.size(); i++) {
      if (seniorTeam.get(i).getCompetition() != competition){
        ui.displayGreen(seniorTeam.get(i).toString());
      }
    }
    ui.displayLine();
  }

  public void deleteCompetitonMember(UI ui, FileHandler fileHandler) {
    ui.displayBlueHeader("Delete competition member");
    ui.displayGreen("");
    ui.displayGreen("Enter the member Id: ");
    String choice = ui.getString();
    for (int i = 0; i < allMembers.size(); i++) {
      if (allMembers.get(i).getMemberId().equals(choice)) {
        allMembers.remove(i);
      }
    }
    fileHandler.refreshCompetitionMembers(allMembers);
    ui.displayLine();
  }

  public void displayTopSwimmers(UI ui, String swimstyle, String teamName, ArrayList<CompetitionMember> team){
    ui.displayBlueHeader(teamName + " team Top 5.");
    ArrayList<CompetitionMember> topFive = new ArrayList<>();
    for (int i = 0; i < team.size(); i++) {
      if (team.get(i).getSwimStyle().equals(swimstyle)) {
        topFive.add(team.get(i));
      }
    }
      Collections.sort(team, (o1, o2) -> o1.getTraining().compareTo(o2.getTraining()));
    for (int i = 0; i < topFive.size(); i++) {
      ui.displayGreen(topFive.get(i).toString());
    }
    }

  public void addCompetition(UI ui, Competition competition, CompetitionMember competitionMember, FileHandler fileHandler, Training training) {
    ui.displayBlueHeader("New competition");
    ui.display("");
    ui.displayGreen("Enter member ID of the competition swimmer: ");
    String memberId = ui.getString();
    while (!validateCompetitionId(memberId, ui)) {
      memberId = ui.getString();
    }
    ui.displayGreen("1. Frontcrawl: \n2. Backstroke: \n3. Breaststroke: \n4. Butterfly  \n9. to go back\n");
    int coachChoice = ui.getScanInt();
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
    String swimStyle = choice;
    ui.displayGreen("Enter location for competition: ");
    String place = ui.getString();
    String date = ui.date();
    ui.displayGreen("Enter swim time");
    String result = ui.getString();
    ui.displayGreen("Enter ranking");
    int rank = ui.getScanInt();

    competition = new Competition(place.replaceAll(" ", ""), date, result, rank);
    for (int i = 0; i < allMembers.size(); i++) {
      if (memberId.equals(allMembers.get(i).getMemberId())) {
        competitionMember = new CompetitionMember(memberId, allMembers.get(i).getFirstName(), allMembers.get(i).getSurName(),
            allMembers.get(i).getAge(), allMembers.get(i).getGender(), allMembers.get(i).getActive(),
            allMembers.get(i).getSwimStyle(), allMembers.get(i).getTraining(), competition);
            allMembers.remove(i);
      }
    }

    allMembers.add(competitionMember);
    fileHandler.saveCompetitionToMember(competitionMember, training,  competition);
    fileHandler.refreshCompetitionMembers(allMembers);
  }

  public boolean validateCompetitionId(String memberId, UI ui) {
    for (int i = 0; i < allMembers.size(); i++) {
      if (memberId.equals(allMembers.get(i).getMemberId())) {
        return true;
      }
    }
    return false;
  }

  public void frontCrawl(UI ui) {
    swimStyleIdentifier(ui, SwimStyle.Frontcrawl.toString());
    displayTopSwimmers(ui,SwimStyle.Frontcrawl.toString(),"Youth", youthTeam);
    displayTopSwimmers(ui,SwimStyle.Frontcrawl.toString(),"Senior", seniorTeam);
  }

  public void butterfly(UI ui) {
    swimStyleIdentifier(ui, SwimStyle.Butterfly.toString());
    displayTopSwimmers(ui,SwimStyle.Butterfly.toString(),"Youth", youthTeam);
    displayTopSwimmers(ui,SwimStyle.Butterfly.toString(),"Senior", seniorTeam);
  }

  public void backstroke(UI ui) {
    swimStyleIdentifier(ui, SwimStyle.Backstroke.toString());
    displayTopSwimmers(ui,SwimStyle.Backstroke.toString(),"Youth", youthTeam);
    displayTopSwimmers(ui,SwimStyle.Backstroke.toString(),"Senior", seniorTeam);
  }

  public void breaststroke(UI ui) {
    swimStyleIdentifier(ui, SwimStyle.Breaststroke.toString());
    displayTopSwimmers(ui,SwimStyle.Breaststroke.toString(),"Youth", youthTeam);
    displayTopSwimmers(ui,SwimStyle.Breaststroke.toString(),"Senior", allMembers);
  }
}


