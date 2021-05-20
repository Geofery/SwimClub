import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CompetitionMembership {

  ArrayList<CompetitionMember> youthTeam = new ArrayList<>();
  ArrayList<CompetitionMember> seniorTeam = new ArrayList<>();
  ArrayList<CompetitionMember> allMembers = new ArrayList<>();
  ArrayList<CompetitionMember> youthFrontcrawl = new ArrayList<>();
  ArrayList<CompetitionMember> seniorFrontcrawl = new ArrayList<>();
  ArrayList<CompetitionMember> youthButterfly = new ArrayList<>();
  ArrayList<CompetitionMember> seniorButterfly = new ArrayList<>();
  ArrayList<CompetitionMember> youthBackstroke = new ArrayList<>();
  ArrayList<CompetitionMember> seniorBackstroke = new ArrayList<>();
  ArrayList<CompetitionMember> youthBreaststroke = new ArrayList<>();
  ArrayList<CompetitionMember> seniorBreaststroke = new ArrayList<>();

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

  public void swimStyleIdentifierYouth(CompetitionMember competitionMember) {
    for (int i = 0; i < youthTeam.size(); i++) { //TODO Christopher!
      if (youthTeam.get(i).getSwimStyle().equals(SwimStyle.Frontcrawl)){
        youthFrontcrawl.add(competitionMember);
      } else if (youthTeam.get(i).getSwimStyle().equals(SwimStyle.Butterfly)){
        youthButterfly.add(competitionMember);
      } else if (youthTeam.get(i).getSwimStyle().equals(SwimStyle.Backstroke)){
        youthBackstroke.add(competitionMember);
      }else
        youthBreaststroke.add(competitionMember);
    }
  }
  public void swimStyleIdentifierSenior(CompetitionMember competitionMember) {
    for (int i = 0; i < seniorTeam.size(); i++) {
      if (seniorTeam.get(i).getSwimStyle().equals(SwimStyle.Frontcrawl)){
        seniorFrontcrawl.add(competitionMember);
      } else if (seniorTeam.get(i).getSwimStyle().equals(SwimStyle.Butterfly)){
        seniorButterfly.add(competitionMember);
      } else if (seniorTeam.get(i).getSwimStyle().equals(SwimStyle.Backstroke)){
        seniorBackstroke.add(competitionMember);
      }else
        seniorBreaststroke.add(competitionMember);
    }
  }

  public void showSwimmers(UI ui) {
    ui.displayLine();
    Collections.sort(allMembers, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
    for (int i = 0; i < allMembers.size(); i++) {
      ui.displayGreen(i + 1 + ". " + allMembers.get(i).toString());
    }
    ui.displayLine();
  }




}