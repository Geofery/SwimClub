import java.util.ArrayList;

public class Membership {
    Member member;

    ArrayList<Member> youthTeam = new ArrayList<>();
    ArrayList<Member> seniorTeam = new ArrayList<>();
    ArrayList<Member> seniorXoTeam = new ArrayList<>();
    ArrayList<Member> passive = new ArrayList<>();




    public int ageIdentifier() {

       int getAge = Integer.parseInt(member.getAge());
        if (getAge < 18) {
            youthTeam.add(member);
        } else if (getAge >= 18) {
            seniorTeam.add(member);
        } else if (getAge >= 60) {
             seniorXoTeam.add(member);
        } else {
             passive.add(member);
        }
        return 0;
    }


}
