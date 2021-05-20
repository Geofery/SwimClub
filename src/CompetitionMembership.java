import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CompetitionMembership  {

  ArrayList<CompetitionMember> youthTeam = new ArrayList<>();
  ArrayList<CompetitionMember> seniorTeam = new ArrayList<>();
  ArrayList<CompetitionMember> allMembers = new ArrayList<>();
  int year = 2021;

  public void ageIdentifier(CompetitionMember competitionMember) {
    int getAge = Integer.parseInt(competitionMember.getAge());
    if ((year - getAge) < 18 && competitionMember.isActive()) {
      youthTeam.add(competitionMember);
    } else if ((year - getAge) >= 18 && !(year - getAge >= 60) && competitionMember.isActive()) {
      seniorTeam.add(competitionMember);
    }
  }

  public ArrayList<CompetitionMember> allMembers() {
    allMembers.addAll(youthTeam);
    allMembers.addAll(seniorTeam);
    return allMembers;
  }

  public void showSwimmers(UI ui) { //Todo needs Tine
    ui.displayLine();
 //   Collections.sort(allMembers, (o1, o2) -> o1.getTrainingResult().compareTo(o2.getCompetitionResult()));
    for (int i = 0; i < allMembers.size(); i++) {
      ui.displayGreen(i + 1 + ". " + allMembers.get(i).toString());
    }
    ui.displayLine();

  }



}