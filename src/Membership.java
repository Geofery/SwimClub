import java.util.ArrayList;
import java.util.Collections;


public class Membership { //TODO gøres private
  private ArrayList<Member> youthTeam = new ArrayList<>();
  private ArrayList<Member> seniorTeam = new ArrayList<>();
  private ArrayList<Member> seniorXoTeam = new ArrayList<>();
  private ArrayList<Member> passive = new ArrayList<>();
  private ArrayList<Member> allMembers = new ArrayList<>();
  private int year = 2021;
  private String memberId;

  public void ageIdentifier(Member member) { //TODO eventuel udregn alderen på members.
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

  public ArrayList<Member> allMembers() {
    allMembers.addAll(youthTeam);
    allMembers.addAll(seniorTeam);
    allMembers.addAll(seniorXoTeam);
    allMembers.addAll(passive);
    return allMembers;
  }

  public void displayMembers(UI ui) {
    ui.displayLine();
    Collections.sort(allMembers, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
    for (int i = 0; i < allMembers.size(); i++) {
      ui.displayGreen(i + 1 + ". " + allMembers.get(i).toString());
    }
    ui.displayLine();
  }

  public void deleteMember(UI ui) {
    ui.displayGreen("Input member ID of the member you want deleted: ");
    String memberId = ui.getString();
    for (int i = 0; i < allMembers.size(); i++) {
      if (allMembers.get(i).getMemberId().equals(memberId)){
        allMembers.remove(i);
      }
    }
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

  public ArrayList<Member> allmembers() {
    return allMembers;
  }

  public void setYouthTeam(ArrayList<Member> youthTeam) {
    this.youthTeam = youthTeam;
  }

  public void setSeniorTeam(ArrayList<Member> seniorTeam) {
    this.seniorTeam = seniorTeam;
  }

  public void setSeniorXoTeam(ArrayList<Member> seniorXoTeam) {
    this.seniorXoTeam = seniorXoTeam;
  }

  public void setPassive(ArrayList<Member> passive) {
    this.passive = passive;
  }

  public void setAllMembers(ArrayList<Member> allMembers) {
    this.allMembers = allMembers;
  }
  public void convertToCompetitionMember(UI ui, Training training, CompetitionMember competitionMember, FileHandler fileHandler) { //todo valiadate !age > 60
    displayMembers(ui);
    ui.displayGreen("Input member Id");
    String memberId = ui.getString();
    while (!validateMemberId(memberId, ui)) {
      memberId = ui.getString();
    }

    ui.displayGreen("What swimstyle, do you want to the member to comepete in?");
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


      if (validateMemberAge(memberId, ui) ==true){
        training = new Training(ui.date(), result);
        for (int i = 0; i < allMembers.size(); i++) {
          if (allMembers.get(i).getMemberId().equals(memberId)) {
            competitionMember = new CompetitionMember(allMembers.get(i).getMemberId().replaceAll("M", "C"),
                allMembers.get(i).getFirstName(), allMembers.get(i).getSurName(),
                allMembers.get(i).getAge(), allMembers.get(i).getSex(),
                allMembers.get(i).isActive(), choice, training);
                allMembers.remove(i);
          }
        }
        fileHandler.saveCompetitionMember(competitionMember, choice, training);
        fileHandler.refreshMembers(allMembers);
      }
    }
  }

  public boolean validateMemberAge(String memberId, UI ui){
    int validateAge = 1961;
    for (int i = 0; i < allMembers.size(); i++) {
      if (allMembers.get(i).getMemberId().equals(memberId) && Integer.parseInt(allMembers.get(i).getAge()) > validateAge){
        return true;
      }
    }
    ui.errorRed("Member is to old to compete!");
    return false;
  }

  public boolean validateMemberId(String memberId, UI ui){
    if (memberId.startsWith("M")){
      return true;
    }else
      ui.errorRed("Invalid input");
    return false;
  }
}