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
        ui.displayLine();
        ui.displayBlueHeader("Financial overview\n");
        ui.displayGreenPrint("Total income from youth members: = ");ui.getPattern(youthSubFee(membership));ui.displayGreen(" kr."); //New method
        ui.displayGreenPrint("Total income from senior members: = ");ui.getPattern(seniorSubFee(membership)); ui.displayGreen(" kr.");
        ui.displayGreenPrint("Total income from seniors > 60 members: = ");ui.getPattern(seniorXoSubFee(membership)); ui.displayGreen(" kr.");
        ui.displayGreenPrint("Total income from passive members: = "); ui.getPattern(passiveSubFee(membership));ui.displayGreen(" kr.");
        ui.displayGreenPrint("Total income from all members: = ");ui.getPattern(sum);ui.displayGreen(" kr.");
        ui.displayLine();

    }

    public void financeCreditors(UI ui, Membership membership, Finance finance, Member member) { //TODO hver enkelt medlem på.
        double percentage;
        int badStandingMember;
        int badStanding;
        int total = 0;

        ui.displayLine();
        ui.displayBlueHeader("Members with bad credit\n");
        percentage = membership.getYouthTeam().size() * 0.02;
        badStandingMember = (int) Math.ceil(percentage);
        badStanding = (int) Math.ceil(percentage) * youthPrice;
        getBadstandingMembers(badStandingMember,membership.getYouthTeam(), ui);
        ui.errorRed("Youth member: " + badStanding + "kr.");
        total += badStanding;


        percentage = membership.getSeniorTeam().size() * 0.02;
        badStandingMember = (int) Math.ceil(percentage);
        badStanding = (int) Math.ceil(percentage) * seniorPrice;
        getBadstandingMembers(badStandingMember,membership.getSeniorTeam(), ui);
        ui.errorRed("Senior member: " + badStanding + "kr.");
        total += badStanding;

        percentage = membership.getSeniorXoTeam().size() * 0.02;
        badStandingMember = (int) Math.ceil(percentage);
        badStanding = (int) Math.ceil(percentage) * (int) seniorXoPrice;
        getBadstandingMembers(badStandingMember, membership.getSeniorXoTeam(), ui);
        ui.errorRed("SeniorXo member: " + badStanding + "kr.");
        total += badStanding;

        percentage = membership.getPassive().size() * 0.02;
        badStandingMember = (int) Math.ceil(percentage);
        badStanding = (int) Math.ceil(percentage) * passivePrice;
        getBadstandingMembers(badStandingMember, membership.getPassive(), ui);
        ui.errorRed("Passive member: " + badStanding + "kr.\n");
        total += badStanding;

        ui.errorRed("Total missed payments: " + total + "kr.");
        ui.displayLine();
    }

    public void getBadstandingMembers(int badStandingMember, ArrayList<Member> arrayList, UI ui){
        for (int i = 0; i < badStandingMember; i++) {
            ui.displayGreen("Member: \n" + arrayList.get(i).toString() + " Owes money!");
        }
    }
}

