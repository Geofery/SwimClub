
import java.util.ArrayList;
import java.util.Random;

public class Membership {
    ArrayList<Member> youthTeam = new ArrayList<>();
    ArrayList<Member> seniorTeam = new ArrayList<>();
    ArrayList<Member> seniorXoTeam = new ArrayList<>();
    ArrayList<Member> passive = new ArrayList<>();
    ArrayList<Member> allMembers = new ArrayList<>();
    int year = 2021;
    String memberId;
    int youthSize = youthTeam.size(); //a try to get numbers of member in each array to controller class
    int seniorSize = seniorTeam.size();
    int seniorXoSize = seniorXoTeam.size();
    int passiveSize = passive.size();


    public void ageIdentifier(Member member) {
        int getAge = Integer.parseInt(member.getAge());
        if ((year - getAge) < 18) {
            youthTeam.add(member);
        } else if ((year - getAge) >= 18 && !(year - getAge > 60)) {
            seniorTeam.add(member);
        } else if ((year - getAge) >= 60) {
            seniorXoTeam.add(member);
        } else {
            passive.add(member);
        }
    }

    public void generateMemberId(Member member, Membership membership, CompetitionMember competitionMember) {
        if (member.getType() == 'C') {
            memberId = "C" + new Random(1000) + 1;
            validateMemberId(member, membership, competitionMember);
           /* if (membership.allMembers.contains(member.getMemberId().equals(memberId))) {
                generateMemberId(member, membership, competitionMember);
            }else*/ member.setMemberId(memberId);
        } else if (member.getType() == 'M') {
            memberId = "M" + new Random(1000) + 1;
           /* if (membership.allMembers.contains(member.getMemberId().equals(memberId))) {
                generateMemberId(member, membership, competitionMember);
            }else */
            validateMemberId(member, membership, competitionMember);
            member.setMemberId(memberId);
        }
        }

        public void validateMemberId(Member member, Membership membership,CompetitionMember competitionMember){
            if (membership.allMembers.contains(member.getMemberId().equals(memberId))) {
                generateMemberId(member, membership, competitionMember);
            }else member.setMemberId(memberId);

        }


        public ArrayList<Member> allMembers () {
            allMembers.addAll(youthTeam);
            allMembers.addAll(seniorTeam);
            allMembers.addAll(seniorXoTeam);
            allMembers.addAll(passive);
            return allMembers;
        }

        public void displayMembers (UI ui){
            for (int i = 0; i < allMembers.size(); i++) {
                ui.displayGreen(i + 1 + ". " + allMembers.get(i).toString());
            }
        }

        public void deleteMember (UI ui){
            ui.displayGreen("Input number of the member you want deleted: ");
            allMembers.remove(ui.getScanInt() - 1);
        }

        public void registerNewMember (UI ui, Member member, Membership membership, FileHandler fileHandler){
            ui.displayGreen("Please enter Name");
            String name = ui.getString();
            ui.displayGreen("Please enter surname");
            String surName = ui.getString();
            ui.displayGreen("Please enter year of birth");
            String year = ui.getString();
            ui.displayGreen("Please enter sex");
            String sex = ui.getString();
            member = new Member(name, surName, year, sex);
            membership.ageIdentifier(member);
            fileHandler.saveMember(member);
        }
    }