public class Finance {

    int youthPrice = 1000;
    int seniorPrice = 1600;
    double seniorXoPrice = 1600 * 0.8;
    int passivePrice = 500;

    public int youthSubFee(Membership membership) {
        return membership.youthTeam.size() * youthPrice;
    }
    public int seniorSubFee(Membership membership) {
        return membership.seniorTeam.size() * seniorPrice;
    }
    public int seniorXoSubFee(Membership membership) {
        double seniorXoSub = membership.seniorXoTeam.size() * seniorXoPrice;
        return (int) seniorXoSub;
    }
    public int passiveSubFee(Membership membership) {
        return membership.passive.size() * passivePrice;
    }
}

