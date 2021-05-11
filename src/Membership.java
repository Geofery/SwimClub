import java.time.Year;
import java.util.ArrayList;

public class Membership {
  ArrayList<Member> youthTeam;
  ArrayList<Member> seniorTeam;
  ArrayList<Member> seniorXoTeam;
  ArrayList<Member> passive;
  int year = 2021;

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


  public void ageIdentifier(Member member) {    //@ not null ???

    int getAge = Integer.parseInt(member.getAge());
    if ((year - getAge) < 18) {
      createYouthTeam();
      youthTeam.add(member);
    } else if ((year - getAge) >= 18) {
      createSeniorTeam();
      seniorTeam.add(member);
    } else if ((year - getAge) >= 60) {
      createSeniorXoTeam();
      seniorXoTeam.add(member);
    } else {
      createPassive();
      passive.add(member);
    }
  }
}
