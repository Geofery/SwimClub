import java.lang.management.MemoryManagerMXBean;

public class Controller {
  UI ui = new UI();
  Member member;
  Membership membership = new Membership();
  LoginGui loginGui = new LoginGui();


  public void mainMenu() {
    Menu menu = new Menu();

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.showMainMenu();
      choice = ui.getScanInt();
      switch (choice) {
        case 1:
          joinTheClub();
          break;
        case 2:
          viewMembership();
          break;
        case 3:
          competitionResults();
          break;
        case 4:
          adminLogin();
          break;
        case 9:
          ui.displayGreen("Saving your high score.....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.displayGreen("Still saving....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.errorRed("System error!");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          ui.errorRed("F40");
          ui.displayGreen("Thanks for playing! :D");


          keepRunning = false;
      }
    } while (keepRunning);
  }

  public void joinTheClub() {registerNewMember();}
  public void viewMembership() {}
  public void competitionResults() {}
  public void adminLogin() {
    loginGui.getLoginRights();
    if (loginGui.getLoginRights() == 1) {
      chairmanSubMenu();
    }else if (loginGui.getLoginRights() == 2) {
      financeSubMenu();
    }else if (loginGui.getLoginRights() == 3)
      coachSubMenu();
    else
      ui.errorRed("Wrong e-mail or password!");
  }


  public void chairmanSubMenu() {
    Menu menu = new Menu();

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.showMainMenu();
      choice = ui.getScanInt();
      switch (choice) {
        case 1:
          registerNewMember();
          break;
        case 2:
          changeMembershipStatus();
          break;
        case 3:
          changeActivityLevel();
          break;
        case 4:
          addLostFound();;
          break;
        case 5:
          deleteLostFound();;
          break;
        case 9:
          ui.displayGreen("Saving your high score.....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.displayGreen("Still saving....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.errorRed("System error!");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          ui.errorRed("F40");
          ui.displayGreen("Thanks for playing! :D");


          keepRunning = false;
      }
    } while (keepRunning);
  }

  public void registerNewMember(){
      member = new Member(ui.getString(), ui.getString(), ui.getString(), ui.getString());
      membership.ageIdentifier();
  }
  public void changeMembershipStatus(){}
  public void changeActivityLevel(){}

  public void financeSubMenu() {
    Menu menu = new Menu();

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.showMainMenu();
      choice = ui.getScanInt();
      switch (choice) {
        case 1:
          membershipStatistics();
          break;
        case 2:
          viewFinances();
          break;
        case 3:
          deleteMember();
          break;
        case 4:
          addLostFound();;
          break;
        case 5:
          deleteLostFound();
          break;
        case 9:
          ui.displayGreen("Saving your high score.....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.displayGreen("Still saving....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.errorRed("System error!");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          ui.errorRed("F40");
          ui.displayGreen("Thanks for playing! :D");


          keepRunning = false;
      }
    } while (keepRunning);
  }

  public void membershipStatistics(){}
  public void viewFinances(){}
  public void deleteMember(){}


  public void coachSubMenu() {
    Menu menu = new Menu();

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.showMainMenu();
      choice = ui.getScanInt();
      switch (choice) {
        case 1:
          swimStylesSubMenu();
          break;
        case 2:
          showSwimmers();
          break;
        case 3:
          addLostFound();
          break;
        case 4:
          deleteLostFound();
          break;
        case 5:
          break;
        case 9:
          ui.displayGreen("Saving your high score.....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.displayGreen("Still saving....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.errorRed("System error!");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          ui.errorRed("F40");
          ui.displayGreen("Thanks for playing! :D");


          keepRunning = false;
      }
    } while (keepRunning);
  }

  public void showSwimmers(){}
  public void addLostFound(){}
  public void deleteLostFound(){}

  public void swimStylesSubMenu() {
    Menu menu = new Menu();

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.showMainMenu();
      choice = ui.getScanInt();
      switch (choice) {
        case 1:
          frontCrawl();
          break;
        case 2:
          butterfly();
          break;
        case 3:
          backstroke();
          break;
        case 4:
          breaststroke();
          break;
        case 5:
          sidestroke();
          break;
        case 9:
          ui.displayGreen("Saving your high score.....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.displayGreen("Still saving....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.errorRed("System error!");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          ui.errorRed("F40");
          ui.displayGreen("Thanks for playing! :D");


          keepRunning = false;
      }
    } while (keepRunning);
  }

  public void frontCrawl(){}
  public void butterfly(){}
  public void backstroke(){}
  public void breaststroke(){}
  public void sidestroke(){}

}

