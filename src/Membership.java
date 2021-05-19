import java.util.ArrayList;
import java.util.Collections;


public class Membership {
    ArrayList<Member> youthTeam = new ArrayList<>();
    ArrayList<Member> seniorTeam = new ArrayList<>();
    ArrayList<Member> seniorXoTeam = new ArrayList<>();
    ArrayList<Member> passive = new ArrayList<>();
    ArrayList<Member> allMembers = new ArrayList<>();
    int year = 2021;
    String memberId = "M";


    public void ageIdentifier(Member member) {
        int getAge = Integer.parseInt(member.getAge());
        if ((year - getAge) < 18 && member.isActive() == true) {
            youthTeam.add(member);
        } else if ((year - getAge) >= 18 && !(year - getAge > 60) && member.isActive() == true) {
            seniorTeam.add(member);
        } else if ((year - getAge) >= 60 && member.isActive() == true) {
            seniorXoTeam.add(member);
        } else {
            passive.add(member);
        }
    }

    public String generateMemberId() {
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

    public ArrayList<Member> allMembers() {
        allMembers.addAll(youthTeam);
        allMembers.addAll(seniorTeam);
        allMembers.addAll(seniorXoTeam);
        allMembers.addAll(passive);
        return allMembers;
    }

    public void displayMembers(UI ui, Membership membership) {
        ui.displayLine();
        Collections.sort(membership.allMembers, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
        for (int i = 0; i < allMembers.size(); i++) {
            ui.displayGreen(i + 1 + ". " + allMembers.get(i).toString());
        }
        ui.displayLine();
    }

    public void deleteMember(UI ui) {
        ui.displayGreen("Input number of the member you want deleted: ");
        allMembers.remove(ui.getScanInt() - 1);
    }

    public void addNewMember(UI ui, Member member, Membership membership, FileHandler fileHandler) {
        ui.displayGreen("Please enter first name");
        String firstName = ui.getString();
        ui.displayGreen("Please enter surname");
        String surName = ui.getString();
        ui.displayGreen("Please enter year of birth");
        String year = ui.getString();
        ui.displayGreen("Please enter sex");
        String sex = ui.getString();
        String memberId = generateMemberId();
        boolean active;
        member = new Member(memberId, firstName, surName, year, sex, true);
        fileHandler.saveMember(member);
        membership.ageIdentifier(member);
        allMembers.add(member);
    }
}