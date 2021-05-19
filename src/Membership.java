
import java.util.ArrayList;
import java.util.Random;

public class Membership {
    ArrayList<Member> youthTeam = new ArrayList<>();
    ArrayList<Member> seniorTeam = new ArrayList<>();
    ArrayList<Member> seniorXoTeam = new ArrayList<>();
    ArrayList<Member> passive = new ArrayList<>();
    ArrayList<Member> allMembers = new ArrayList<>();
    int year = 2021;
    String memberId = "M";
    int youthSize = youthTeam.size(); //a try to get numbers of member in each array to controller class
    int seniorSize = seniorTeam.size();
    int seniorXoSize = seniorXoTeam.size();
    int passiveSize = passive.size();


    public void ageIdentifier(CasualMember casualMember) {
        int getAge = Integer.parseInt(casualMember.getAge());
        if ((year - getAge) < 18) {
            youthTeam.add(casualMember);
        } else if ((year - getAge) >= 18 && !(year - getAge > 60)) {
            seniorTeam.add(casualMember);
        } else if ((year - getAge) >= 60) {
            seniorXoTeam.add(casualMember);
        } else {
            passive.add(casualMember);
        }
    }

    public String generateMemberId() {
        int randomNumber = (int)(Math.random() * 1000)+1; //1 to 1000
        memberId +=randomNumber;
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

        public void displayMembers (UI ui){
            for (int i = 0; i < allMembers.size(); i++) {
                ui.displayGreen(i + 1 + ". " + allMembers.get(i).toString());
            }
        }

        public void deleteMember (UI ui){
            ui.displayGreen("Input number of the member you want deleted: ");
            allMembers.remove(ui.getScanInt() - 1);
        }

        public void registerNewMember (UI ui, CasualMember casualMember, Membership membership, FileHandler fileHandler){
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
            casualMember = new CasualMember(memberId,firstName, surName, year, sex, true);
            membership.ageIdentifier(casualMember);
            fileHandler.saveMember(casualMember);
        }
    }