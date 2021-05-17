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
    ui.displayGreen("Total income from youth subscribers " + youthSubFee(membership) + " kr.");  // Old method
    ui.displayGreen("Total income from senior subscribers " + seniorSubFee(membership) + " kr.");
    ui.displayGreen("Total income from seniors > 60 subscribers " + seniorXoSubFee(membership) + " kr.");
    ui.displayGreen("Total income from passive subscribers " + passiveSubFee(membership) + " kr.");
    ui.displayGreen("Total income from subscribers " + sum + " kr.");
    ui.displayLine();
    ui.displayGreenPrint("Total income from youth subscribers: = ");
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
    membership.displayMembers(ui);
    membership.deleteMember(ui);
    ui.displayLine();
  }
}

