import java.util.ArrayList;

public class Finance {

    int youthPrice = 1000;
    int seniorPrice = 1600;
    double seniorXoPrice = 1600 * 0.8;
    int passivePrice = 500;

    public int youthSubFee(Membership membership) {
        return membership.getYouthTeam().size() * youthPrice;
    }

    public int seniorSubFee(Membership membership) {
        return membership.getSeniorTeam().size() * seniorPrice;
    }

    public int seniorXoSubFee(Membership membership) {
        double seniorXoSub = membership.getSeniorXoTeam().size() * seniorXoPrice;
        return (int) seniorXoSub;
    }

    public int passiveSubFee(Membership membership) {
        return membership.getPassive().size() * passivePrice;
    }

    public void viewFinances(UI ui, Membership membership) {//Todo chris Print BadStandingMember @Jens
        int sum = youthSubFee(membership) + seniorSubFee(membership) + seniorXoSubFee(membership) + passiveSubFee(membership);
        ui.getPattern(youthSubFee(membership));ui.displayGreen(" kr."); //New method
        ui.displayGreenPrint("Total income from senior subscribers: = ");ui.getPattern(seniorSubFee(membership)); ui.displayGreen(" kr.");
        ui.displayGreenPrint("Total income from seniors > 60 subscribers: = ");ui.getPattern(seniorXoSubFee(membership)); ui.displayGreen(" kr.");
        ui.displayGreenPrint("Total income from passive subscribers: = "); ui.getPattern(passiveSubFee(membership));ui.displayGreen(" kr.");
        ui.displayGreenPrint("Total income from subscribers: = ");ui.getPattern(sum);ui.displayGreen(" kr.");
        ui.displayLine();

    }

    public void financeCreditors(UI ui, Membership membership, Finance finance, Member member) { //TODO hver enkelt medlem på.
        double percentage;
        int badStandingMember;
        int badStanding;
        int total = 0;

        ui.displayGreen("Members with negative credit");
        percentage = membership.getYouthTeam().size() * 0.02;
        badStandingMember = (int) Math.ceil(percentage);
        badStanding = (int) Math.ceil(percentage) * youthPrice;
        ui.displayGreen("Youth member: " + badStanding + "kr.");
        total += badStanding;
        getBadstandingMembers(badStandingMember,membership.getYouthTeam().size(), ui, member);

        percentage = membership.getSeniorTeam().size() * 0.02;
        badStanding = (int) Math.ceil(percentage) * seniorPrice;
        ui.displayGreen("Senior member: " + badStanding + "kr.");
        total += badStanding;
        getBadstandingMembers(badStandingMember,membership.getSeniorTeam().size(), ui, member);

        percentage = membership.getSeniorXoTeam().size() * 0.02;
        badStanding = (int) Math.ceil(percentage) * (int) seniorXoPrice;
        ui.displayGreen("SeniorXo member: " + badStanding + "kr.");
        total += badStanding;
        getBadstandingMembers(badStandingMember, membership.getSeniorXoTeam().size(), ui, member);

        percentage = membership.getPassive().size() * 0.02;
        badStanding = (int) Math.ceil(percentage) * passivePrice;
        ui.displayGreen("Passive member: " + badStanding + "kr.");
        total += badStanding;
        getBadstandingMembers(badStandingMember, membership.getPassive().size(), ui, member);

        ui.errorRed("Total missed payments: " + total + "kr.");
        ui.displayLine();
    }

    public void getBadstandingMembers(int badStandingMember, int size, UI ui, Member member){
        for (int i = 0; i < badStandingMember; i++) {
            ui.displayGreen(member.toString());
        }
    }
}

