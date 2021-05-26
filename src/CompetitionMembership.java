import java.util.ArrayList;
import java.util.Collections;

public class CompetitionMembership {

  private ArrayList<CompetitionMember> youthTeam = new ArrayList<>();
  private ArrayList<CompetitionMember> seniorTeam = new ArrayList<>();
  private ArrayList<CompetitionMember> allMembers = new ArrayList<>();
  private int year = 2021;

  public void ageIdentifier(CompetitionMember competitionMember) {
    int getAge = Integer.parseInt(competitionMember.getAge());
    if ((year - getAge) < 18) {
      youthTeam.add(competitionMember);
    } else if ((year - getAge) >= 18) {
      seniorTeam.add(competitionMember);
    }
  }

  public ArrayList<CompetitionMember> getAllMembers() {
    return allMembers;
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

  public void deleteCompetitonMember(UI ui) {
    ui.displayBlueHeader("Delete competition member");
    ui.displayGreen("");
    ui.displayGreen("Enter the member Id og the swimmer: ");
    String choice = ui.getString();
    for (int i = 0; i < allMembers.size(); i++) {
      if (allMembers.get(i).getMemberId().equals(choice)) {
        allMembers.remove(i);
      }
    }
    //fileHandler.refreshCompetitionMembers(allMembers);
    ui.displayLine();
  }

  public void displayTopSwimmers(UI ui, String swimstyle) {
    Collections.sort(youthTeam, (o1, o2) -> o1.getTrainingResult().compareTo(o2.getTrainingResult()));
    Collections.sort(seniorTeam, (o1, o2) -> o1.getTrainingResult().compareTo(o2.getTrainingResult()));
    ui.displayBlueHeader("Youth Team top 5.");
    for (int i = 0; i < 5; i++) {
      if (swimstyle.equals(youthTeam.get(i).getSwimStyle())) {
        ui.displayGreen(youthTeam.get(i).toString());
      }
    }
    ui.displayBlueHeader("Senior Team top 5.");
    for (int i = 0; i < 5; i++) {
      if (swimstyle.equals(youthTeam.get(i).getSwimStyle())) {
        ui.displayGreen(seniorTeam.get(i).toString());
      }
    }
    ui.displayLine();
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
    ui.displayGreen("Enter rank"); //TODO bedre formulering
    String rank = ui.getString();

    competition = new Competition(place, date, result, Integer.parseInt(rank));
    for (int i = 0; i < allMembers.size(); i++) {
      if (memberId.equals(allMembers.get(i).getMemberId())) {
        competitionMember = new CompetitionMember(memberId, allMembers.get(i).getFirstName(), allMembers.get(i).getSurName(),
            allMembers.get(i).getAge(), allMembers.get(i).getGender(), allMembers.get(i).getActive(),
            allMembers.get(i).getSwimStyle(), allMembers.get(i).getTrainingResult(), competition);
            allMembers.remove(i);
      }
    }

    allMembers.add(competitionMember);
    fileHandler.saveCompetitionMember(competitionMember, choice, training, competition);
    //fileHandler.refreshCompetitionMembers(allMembers);
  }

  public boolean validateCompetitionId(String memberId, UI ui) {
    for (int i = 0; i < allMembers.size(); i++) {
      if (memberId.equals(allMembers.get(i).getMemberId())) {
        return true;
      }
    }
    return false;
  }

  public void frontCrawl(UI ui) {//TODO add flere members under FrontCrawl
    swimStyleIdentifier(ui, SwimStyle.Frontcrawl.toString());
    displayTopSwimmers(ui, SwimStyle.Frontcrawl.toString());
  }

  public void butterfly(UI ui) {//TODO add flere members under FrontCrawl
    swimStyleIdentifier(ui, SwimStyle.Butterfly.toString());
    displayTopSwimmers(ui, SwimStyle.Butterfly.toString());
  }

  public void backstroke(UI ui) {//TODO add flere members under FrontCrawl
    swimStyleIdentifier(ui, SwimStyle.Backstroke.toString());
    displayTopSwimmers(ui, SwimStyle.Backstroke.toString());
  }

  public void breaststroke(UI ui) {//TODO add flere members under FrontCrawl
    swimStyleIdentifier(ui, SwimStyle.Breaststroke.toString());
    displayTopSwimmers(ui, SwimStyle.Breaststroke.toString());
  }
}


