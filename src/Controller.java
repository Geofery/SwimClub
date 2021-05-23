import java.util.Locale;

public class Controller {
  UI ui = new UI();
  FileHandler fileHandler = new FileHandler();
  Membership membership = new Membership();
  Finance finance = new Finance();
  LostAndFound lostAndFound = new LostAndFound();
  SwimStyle swimStyle;
  Member member;
  CompetitionMembership competitionMembership = new CompetitionMembership();
  CompetitionMember competitionMember;
  Training training;


  public void mainMenu() {
    Menu menu = new Menu();
    ui.play();
    fileHandler.loadMembers(membership, member); //loads all the member into the array
    fileHandler.loadCompetitionMembers(membership, competitionMember, training, competitionMembership);
    lostAndFound.createLostAndFoundList(ui);
    membership.allMembers();
    competitionMembership.allMembers();
    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.showMainMenu(ui);
      choice = ui.getScanInt();
      switch (choice) {
        case 1 -> membership.addNewMember(ui, member, membership, fileHandler);
        case 2 -> viewMembership();
        case 3 -> competitionResults();
        case 4 -> membership.displayMembers(ui);
        case 5 -> adminLogin();
        case 6 -> lostAndFound.displayLostAndFound(ui);
        case 9 -> {
          ui.displayGreen("If in doubt, swim it out.....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.displayGreen("The wetter the better....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.errorRed("Water you sinking aboat");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          ui.displayGreen("We do it dirty in the deep end !!! :D");
          keepRunning = false;
        }
      }
    } while (keepRunning);
  }

  public void viewMembership() { //Todo make name or member id????
    ui.displayBlueHeader("View your Membership");
    ui.displayGreen("Input your member ID: ");
    String memberId = ui.getString();
    int tracker = 0;
    if (membership.getAllMembers().size() == 0) {
      ui.errorRed("Your broke and going out of business!");
    }else
    for (int i = 0; i < membership.getAllMembers().size(); i++) {
      if (memberId.equals(membership.getAllMembers().get(i).getMemberId())) {
        ui.displayGreen(membership.getAllMembers().get(i).toString());
      } else
        tracker++;
    }

    if (tracker == membership.getAllMembers().size())
      ui.errorRed("Invalid Member ID!");

    ui.displayLine();
  }

  public void competitionResults() {//Todo needs work
    //Top 5 svømmere?
    //
    ui.displayLine();
  }

  public void adminLogin() {
    ui.displayGreen("Please enter E-mail: ");
    String email = ui.getString().toLowerCase(Locale.ROOT);
    ui.displayGreen("Please enter your password: ");
    String password = ui.getString();

    if (email.equals("chairman") && password.equals("1234")) {
      ui.displayGreen("Login successful!");
      ui.displayLine();
      chairmanSubMenu();
    } else if (email.equals("finance") && password.equals("1234")) {
      ui.displayGreen("Login successful!");
      ui.displayLine();
      financeSubMenu();
    } else if (email.equals("coach") && password.equals("1234")) {
      ui.displayGreen("Login successful!");
      ui.displayLine();
      coachSubMenu();
    } else
      ui.errorRed("WATER YOU DOING??? ");
  }

  //JOptionPain
      /* JFrame frame = loginGui.createFrame();

        loginGui.listenForLogin();
        frame.setVisible(false);
        ui.displayLine();
        if (loginGui.getLoginRights() == 1) {
            chairmanSubMenu();
        } else if (loginGui.getLoginRights() == 2) {
            financeSubMenu();
        } else if (loginGui.getLoginRights() == 3) {
            coachSubMenu();
        } else
            ui.errorRed("Water you doing?!");
        ui.displayLine();*/

  public void chairmanSubMenu() {
    Menu menu = new Menu();

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.chairmanSubMenu(ui);
      choice = ui.getScanInt();
      switch (choice) {
        case 1 -> membership.addNewMember(ui, member, membership, fileHandler);
        case 2 -> membership.changeMembershipStatus(ui);
        case 3 -> membership.validateDeleteMember(ui);
        case 4 -> lostAndFound.addLostItem(ui);
        case 5 -> lostAndFound.deleteItem(ui);
        case 9 -> {
          ui.displayGreen("Checking if you forgot anyfin.....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.displayGreen("Anyfin can happen when your part dolphin....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.errorRed("Water you doing !");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          ui.errorRed("Dont go further out than the belly button");
          ui.displayGreen("Sea ya later! :D");
          keepRunning = false;
        }
      }
    } while (keepRunning);
  }

  public void financeSubMenu() {
    Menu menu = new Menu();

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.financeSubMenu(ui);
      choice = ui.getScanInt();
      switch (choice) {
        case 1 -> finance.financeCreditors(ui, membership, finance,member);
        case 2 -> finance.viewFinances(ui, membership);
        case 3 -> membership.validateDeleteMember(ui);
        case 4 -> lostAndFound.addLostItem(ui);
        case 5 -> lostAndFound.deleteItem(ui);
        case 9 -> {
          ui.errorRed("WATER YOU SINKING ABOAT??");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.displayGreen("Swimming away");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.errorRed("SHARK !!!");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          ui.errorRed("U Dead???");
          ui.displayGreen("Told you not to push it! :D");
          keepRunning = false;
        }
      }
    } while (keepRunning);
  }

  public void coachSubMenu() {
    Menu menu = new Menu();
    competitionMembership.swimStyleIdentifierYouth(competitionMember);
    competitionMembership.swimStyleIdentifierSenior(competitionMember);

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.coachSubMenu(ui);
      choice = ui.getScanInt();
      switch (choice) {
        case 1 -> swimStylesSubMenu();
        case 2 -> competitionMembership.showSwimmers(ui);
        case 3 -> competitionResults();
        case 4 -> membership.convertToCompetitionMember(ui,training,fileHandler,competitionMember);
        case 5 -> deleteCompetitonMember();
        case 6 -> lostAndFound.addLostItem(ui);
        case 7 -> lostAndFound.deleteItem(ui);
        case 9 -> {
          ui.displayGreen("Swimming away.....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.displayGreen("Still swimming....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.errorRed("SHARK!!!");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          ui.errorRed("False alarm!");
          ui.displayGreen("Don't count laps. Make every lap count. :D");
          keepRunning = false;
        }
      }
    } while (keepRunning);
  }

  private void deleteCompetitonMember() { //todo if there is time
    for (int i = 0; i < membership.getAllMembers().size(); i++) {
      membership.displayMembers(ui);
      ui.displayGreen("input member Id og the member you want to delete");
      String memberId = ui.getString();
      if (membership.getAllMembers().get(i).getMemberId().equals(memberId)) {

      }
    }
  }

  public void swimStylesSubMenu() {
    Menu menu = new Menu();

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.swimStylesSubMenu(ui);
      choice = ui.getScanInt();
      switch (choice) {
        case 1 -> frontCrawl();
        case 2 -> butterfly();
        case 3 -> backstroke();
        case 4 -> breaststroke();
        case 9 -> {
          ui.displayGreen("Water we waiting for.....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.displayGreen("Water-ever it takes....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.errorRed("System error!");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          ui.errorRed("7 Days Without Swimming Makes One Weak.");
          ui.displayGreen("You should eat your pasta if you want to swim fasta! :D");
          keepRunning = false;
        }
      }
    } while (keepRunning);
  }

  public void frontCrawl() {

  competitionMembership.showFrontcrawl(ui,competitionMember);
  }

  public void butterfly() {
  }

  public void backstroke() {
  }

  public void breaststroke() {
  }


}

