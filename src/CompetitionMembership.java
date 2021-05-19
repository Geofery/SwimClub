import java.util.ArrayList;

public class CompetitionMembership  {

  ArrayList<Member> youthTeam = new ArrayList<>();
  ArrayList<Member> seniorTeam = new ArrayList<>();
  ArrayList<Member> allMembers = new ArrayList<>();
  int year = 2021;

  public void ageIdentifier(Member member) {
    int getAge = Integer.parseInt(member.getAge());
    if ((year - getAge) < 18 && member.isActive() == true) {
      youthTeam.add(member);
    } else if ((year - getAge) >= 18 && !(year - getAge > 60) && member.isActive() == true) {
      seniorTeam.add(member);
    }
  }

  public ArrayList<Member> allMembers() {
    allMembers.addAll(youthTeam);
    allMembers.addAll(seniorTeam);
    return allMembers;
  }
}