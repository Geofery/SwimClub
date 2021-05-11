public class Finance {

    public void getSubscription(Membership membership) {
        int youthSub = membership.youthTeam.size()*1000;
        int seniorSub = membership.seniorTeam.size()*1600;
        double seniorXoSub = membership.seniorXoTeam.size() *(1600*0.8);
        int passiveSub = membership.passive.size()*500;
    }

}
