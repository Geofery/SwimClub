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
    int sum = youthSubFee(membership) + seniorSubFee(membership) + seniorXoSubFee(membership) + passiveSubFee(membership);
    ui.displayLine();
    ui.displayGreen("Total income from youth subscribers " + youthSubFee(membership) + " kr.");
    ui.displayGreen("Total income from senior subscribers " + seniorSubFee(membership) + " kr.");
    ui.displayGreen("Total income from seniors > 60 subscribers " + seniorXoSubFee(membership) + " kr.");
    ui.displayGreen("Total income from passive subscribers " + passiveSubFee(membership) + " kr.");
    ui.displayGreen("Total income from subscribers " + sum + " kr");
   // ui.getPattern(sum);
    //ui.getPattern(seniorSubFee(membership));//Todo Trying to get seniorIncome displayed in a pattern.
    ui.displayLine();
  }
}

