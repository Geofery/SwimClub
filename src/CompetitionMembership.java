import java.util.ArrayList;
import java.util.Collections;

public class CompetitionMembership {

    private ArrayList<CompetitionMember> youthTeam = new ArrayList<>();
    private ArrayList<CompetitionMember> seniorTeam = new ArrayList<>();
    private ArrayList<CompetitionMember> allMembers = new ArrayList<>();
    private int year = 2021;

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

    public void swimStyleIdentifier(UI ui, String choice) {
        ui.displayBlueHeader(choice + " Competition swimmers: ");
        ui.displayGreen("");
        ui.displayGreen("Youth team");
        for (int i = 0; i < allMembers.size(); i++) {
            int age = Integer.parseInt(allMembers.get(i).getAge());
            if (allMembers.get(i).getSwimStyle().equals(choice) && 18 > (year - age)) {
                ui.displayGreen(allMembers.get(i).toString());
            }
        }
        ui.displayGreen("Senior Team");
        for (int i = 0; i < allMembers.size(); i++) {
            int age = Integer.parseInt(allMembers.get(i).getAge());
            if (allMembers.get(i).getSwimStyle().equals(choice) && 18 < (year - age)) {
                ui.displayGreen(allMembers.get(i).toString());
            }
        }
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

    public void deleteCompetitonMember(UI ui){// Copy ??
        ui.displayBlueHeader("Delete competition member");
        ui.displayGreen("");
        ui.displayGreen("Enter the member Id og the swimmer: ");
        String choice  = ui.getString();
        for (int i = 0; i < allMembers.size(); i++) {
            if (allMembers.get(i).getMemberId().equals(choice)){
                allMembers.remove(i);
            }
        }
        ui.displayLine();
    }

    public void frontCrawl(UI ui){
    }

    public void butterfly(UI ui) {
    }

    public void backstroke(UI ui) {
    }

    public void breaststroke(UI ui) {
    }
}
