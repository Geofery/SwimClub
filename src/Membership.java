import java.time.Year;
import java.util.ArrayList;

public class Membership {
  ArrayList<Member> youthTeam = new ArrayList<>();
  ArrayList<Member> seniorTeam = new ArrayList<>();
  ArrayList<Member> seniorXoTeam = new ArrayList<>();
  ArrayList<Member> passive  = new ArrayList<>();
  int year = 2021;

  public void ageIdentifier(Member member) {

    int getAge = Integer.parseInt(member.getAge());
    if ((year - getAge) < 18) {
      youthTeam.add(member);
    } else if ((year - getAge) >= 18) {
      seniorTeam.add(member);
    } else if ((year - getAge) >= 60) {
      seniorXoTeam.add(member);
    } else {
      passive.add(member);
    }
  }

  public ArrayList allMembers(){
    ArrayList<Member> allMembers = new ArrayList<>();
    allMembers.addAll(youthTeam);
    allMembers.addAll(seniorTeam);
    allMembers.addAll(seniorXoTeam);
    allMembers.addAll(passive);
return allMembers;
  }
}
