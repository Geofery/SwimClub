import java.util.ArrayList;

public class Controller {
  UI ui = new UI();
  Member member;
  LoginGui loginGui = new LoginGui();
  FileHandler fileHandler = new FileHandler();
  Membership membership = new Membership();
  Finance finance = new Finance();



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
          showMembers();
          break;
        case 5:
          adminLogin();
          break;
        case 9:
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
          ui.errorRed("Water you sinking aboat");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          ui.errorRed("F40");
          ui.displayGreen("Swim ya later! :D");


          keepRunning = false;
      }
    } while (keepRunning);
  }

  public void joinTheClub() {
    registerNewMember();
  }

  public void viewMembership() {
    //TODO Christopher
    //vise 1 bruger ud fra index eller navn og surname.
    //comapareTo Collections .equals eller andre metoder.
  }

  public void competitionResults() {
    //Top 5 svømmere?
    //
  }

  public void showMembers() {
    //Filtrering natual order...
    fileHandler.loadMembers(membership, member);
    ui.displayGreen(membership.youthTeam + "\n" + membership.seniorTeam + "\n" + membership.seniorXoTeam + "\n" + membership.passive);
  }

  public void adminLogin() {
    loginGui.getLoginRights();
    if (loginGui.getLoginRights() == 1) {
      chairmanSubMenu();
    } else if (loginGui.getLoginRights() == 2) {
      financeSubMenu();
    } else if (loginGui.getLoginRights() == 3)
      coachSubMenu();
    else
      ui.errorRed("Water up with the e-mail or password!");
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
          addLostFound();
          ;
          break;
        case 5:
          deleteLostFound();
          ;
          break;
        case 9:
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
          ui.errorRed("Water you doing !");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          ui.errorRed("F40");
          ui.displayGreen("We do it dirty in the deep end !!! :D");


          keepRunning = false;
      }
    } while (keepRunning);
  }

  public void registerNewMember() {
    ui.displayGreen("Please enter Name");
    String name = ui.getString();
   ui.displayGreen("Please enter surname");
   String surName = ui.getString();
    ui.displayGreen("Please enter year of birth");
    String year = ui.getString();
    ui.displayGreen("Please enter sex");
    String sex = ui.getString();
    member = new Member(name, surName, year, sex);
    membership.ageIdentifier(member);
    fileHandler.saveMember(member);
  }

  public void changeMembershipStatus() {
  }

  public void changeActivityLevel() {
  }

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
          addLostFound();
          ;
          break;
        case 5:
          deleteLostFound();
          break;
        case 9:
          ui.displayGreen("Swimming away .....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.displayGreen("Still swimming....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.errorRed("SHARK !!!");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          ui.errorRed("F40");
          ui.displayGreen("Thanks for Swimming! :D");


          keepRunning = false;
      }
    } while (keepRunning);
  }

  public void membershipStatistics() {
  }

  public void viewFinances() {
    finance.getSubscription(membership);
  }

  public void deleteMember() {
  }


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

  public void showSwimmers() {
  }

  public void addLostFound() {
  }

  public void deleteLostFound() {
  }

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

  public void frontCrawl() {
  }

  public void butterfly() {
  }

  public void backstroke() {
  }

  public void breaststroke() {
  }

  public void sidestroke() {
  }

}

