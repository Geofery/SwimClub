public class Membership {


    Member member = new Member();

    public int ageIdentifier() {
        if (member.age > 18) {
            //(subscription +1000);
        } else if (member.age <= 18) {
            //(subscription + 1600);
        } else if (member.age < 60) {
            // (subscription + 1600 * 0.8);
        } else {
            //(subscription + 500);
        }
        return 0;
    }
}
