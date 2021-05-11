import java.util.ArrayList;

public class Membership {
  ArrayList<Member> youthTeam;
  ArrayList<Member> seniorTeam;
  ArrayList<Member> seniorXoTeam;
  ArrayList<Member> passive;

  public void createYouthTeam() {
    youthTeam = new ArrayList<>();
  }

  public void createSeniorTeam() {
    seniorTeam = new ArrayList<>();
  }

  public void createSeniorXoTeam() {
    seniorXoTeam = new ArrayList<>();
  }

  public void createPassive() {
    passive = new ArrayList<>();
  }


  public void ageIdentifier(Member member) {
    int getAge = Integer.parseInt(member.getAge());
    if (getAge < 18) {
      createYouthTeam();
      youthTeam.add(member);
    } else if (getAge >= 18) {
      createSeniorTeam();
      seniorTeam.add(member);
    } else if (getAge >= 60) {
      createSeniorXoTeam();
      seniorXoTeam.add(member);
    } else {
      createPassive();
      passive.add(member);
    }
  }

  @Override
  public String toString() {
    return "Members:\n" + youthTeam;
  }
}
