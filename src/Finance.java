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

  public void viewFinances(UI ui, Membership membership) {
    ui.displayLine();
    int sum = youthSubFee(membership) + seniorSubFee(membership) + seniorXoSubFee(membership) + passiveSubFee(membership);
   /* ui.displayGreen("Total income from youth subscribers: = " + ui.getPattern(youthSubFee(membership)).toString() + "kr.");
    ui.displayGreen("Total income from youth subscribers: = " + ui.getPattern(seniorSubFee(membership)) + "kr.");
    ui.displayGreen("Total income from youth subscribers: = " + ui.getPattern(seniorXoSubFee(membership)) + "kr.");
    ui.displayGreen("Total income from youth subscribers: = " + ui.getPattern(passiveSubFee(membership)) + "kr.");
    ui.displayGreen("Total income from youth subscribers: = " + ui.getPattern(sum) + "kr.");*/
    ui.displayLine();
    ui.getPattern(youthSubFee(membership));ui.displayGreen(" kr."); //New method
    ui.displayGreenPrint("Total income from senior subscribers: = ");
    ui.getPattern(seniorSubFee(membership));ui.displayGreen(" kr.");
    ui.displayGreenPrint("Total income from seniors > 60 subscribers: = ");
    ui.getPattern(seniorXoSubFee(membership));ui.displayGreen(" kr.");
    ui.displayGreenPrint("Total income from passive subscribers: = ");
    ui.getPattern(passiveSubFee(membership));ui.displayGreen(" kr.");
    ui.displayGreenPrint("Total income from subscribers: = ");
    ui.getPattern(sum);ui.displayGreen(" kr.");
    ui.displayLine();

  }

  public void financeCreditors(UI ui) {
    ui.displayLine();
    ui.errorRed("Missing stats");
    ui.displayLine();
    //What statistics would be relevant here? if they have paid or not, and when its time to pay the next sub.
  }
  public void deleteMember(UI ui, Membership membership) {
    ui.displayLine();
    membership.displayMembers(ui, membership);
    membership.deleteMember(ui);
    ui.displayLine();
  }
}

