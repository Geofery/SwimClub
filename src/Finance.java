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

    public void viewFinances(UI ui, Membership membership) {//Todo chris Print BadStandingMember @Jens
        ui.displayLine();
        int sum = youthSubFee(membership) + seniorSubFee(membership) + seniorXoSubFee(membership) + passiveSubFee(membership);
   /* ui.displayGreen("Total income from youth subscribers: = " + ui.getPattern(youthSubFee(membership)).toString() + "kr.");
    ui.displayGreen("Total income from youth subscribers: = " + ui.getPattern(seniorSubFee(membership)) + "kr.");
    ui.displayGreen("Total income from youth subscribers: = " + ui.getPattern(seniorXoSubFee(membership)) + "kr.");
    ui.displayGreen("Total income from youth subscribers: = " + ui.getPattern(passiveSubFee(membership)) + "kr.");*/
        ui.displayGreen("Total income from youth subscribers: = " + ui.getPattern(sum) + "kr.");
        ui.displayLine();
        ui.getPattern(youthSubFee(membership));
        ui.displayGreen(" kr."); //New method
        ui.displayGreenPrint("Total income from senior subscribers: = ");
        ui.getPattern(seniorSubFee(membership));
        ui.displayGreen(" kr.");
        ui.displayGreenPrint("Total income from seniors > 60 subscribers: = ");
        ui.getPattern(seniorXoSubFee(membership));
        ui.displayGreen(" kr.");
        ui.displayGreenPrint("Total income from passive subscribers: = ");
        ui.getPattern(passiveSubFee(membership));
        ui.displayGreen(" kr.");
        ui.displayGreenPrint("Total income from subscribers: = ");
        ui.getPattern(sum);
        ui.displayGreen(" kr.");
        ui.displayLine();

    }

    public void financeCreditors(UI ui, Membership membership, Finance finance) { //TODO CHRISTOPHER!!!! hver enkelt medlem på.
        double percentage;
        int badStanding;
        int missingPayment;
        int total = 0;
        ui.displayLine();
        ui.displayGreen("Members with negative credit");
        percentage = membership.youthTeam.size() * 0.02;
        badStanding = (int) Math.ceil(percentage) * youthPrice;
        ui.displayGreen("Youth member: " + badStanding + "kr.");
        total += badStanding;
        percentage = membership.seniorTeam.size() * 0.02;
        badStanding = (int) Math.ceil(percentage) * seniorPrice;
        ui.displayGreen("Senior member: " + badStanding + "kr.");
        total += badStanding;
        percentage = membership.seniorXoTeam.size() * 0.02;
        badStanding = (int) Math.ceil(percentage) * (int) seniorXoPrice;
        ui.displayGreen("SeniorXo member: " + badStanding + "kr.");
        total += badStanding;
        percentage = membership.passive.size() * 0.02;
        badStanding = (int) Math.ceil(percentage) * passivePrice;
        ui.displayGreen("Passive member: " + badStanding + "kr.");
        total += badStanding;
        ui.errorRed("Total missed payments: " + total + "kr.");
        ui.displayLine();
        //What statistics would be relevant here? if they have paid or not, and when its time to pay the next sub.
    }

    public void deleteMember(UI ui, Membership membership) {
        ui.displayLine();
        membership.displayMembers(ui);
        membership.deleteMember(ui);
        ui.displayLine();
    }
}

