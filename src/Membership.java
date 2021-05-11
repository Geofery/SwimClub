import java.util.ArrayList;

public class Membership {
    Member member = new Member();

    Arraylist<member> youthTeam = new ArrayList<>();
    Arraylist<member> seniorTeam = new ArrayList<>();
    Arraylist<member> seniorXoTeam = new ArrayList<>();
    Arraylist<member> passive = new ArrayList<>();


    public int ageIdentifier() {

       int getAge = Integer.parseInt(member.getAge());
        if (getAge > 18) {
            youthTeam.add.subscription +1000;
        } else if (getAge <= 18) {
            seniorTeam.add.seniorTeam.subscription + 1600;
        } else if (getAge< 60) {
             seniorXoTeam.add.subscription + 1600 * 0.8;
        } else {
             passive.add.subscription + 500;
        }
        return 0;
    }


}
