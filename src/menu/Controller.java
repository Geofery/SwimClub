package menu;

import addon.LostAndFound;
import database.FileHandler;
import membershipadministrator.CompetitionMembership;
import membershipadministrator.Finance;
import membershipadministrator.Membership;
import membertypes.CompetitionMember;
import membertypes.Member;
import objects.Competition;
import objects.Training;
import userinterface.LoginGui;
import userinterface.SwimStyle;
import userinterface.UI;
import javax.swing.*;

public class Controller {
  UI ui = new UI();
  FileHandler fileHandler = new FileHandler();
  Membership membership = new Membership();
  Finance finance = new Finance();
  LostAndFound lostAndFound = new LostAndFound();
  SwimStyle swimStyle;
  Competition competition;
  Member member;
  CompetitionMembership competitionMembership = new CompetitionMembership();
  CompetitionMember competitionMember;
  Training training;
  LoginGui loginGui;

  public void mainMenu() {
    Menu menu = new Menu();
    ui.play();
    fileHandler.loadMembers(membership, member); //loads all the member into the array
    fileHandler.loadCompetitionMembers(membership, competitionMember, training, competitionMembership, competition);
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
        case 1 -> membership.addNewMember(ui, member);
        case 2 -> membership.viewMembership(ui);
        case 3 -> competitionMembership.competitionResults(ui, competition);
        case 4 -> membership.displayAllMembers(ui, competitionMembership);
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

  public void adminLogin() {
    //Alternative admin menu
    /*ui.displayGreen("Please enter E-mail: ");
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
  }*/

    loginGui = new LoginGui();
    JFrame frame = loginGui.createFrame();

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
    ui.displayLine();
  }

  public void chairmanSubMenu() {
    Menu menu = new Menu();

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.chairmanSubMenu(ui, membership);
      choice = ui.getScanInt();
      switch (choice) {
        case 1 -> membership.addNewMember(ui, member);
        case 2 -> membership.changeMembershipStatus(ui, fileHandler);
        case 3 -> membership.pendingMembers(ui, fileHandler);
        case 4 -> membership.validateDeleteMember(ui);
        case 5 -> lostAndFound.addLostItem(ui);
        case 6 -> lostAndFound.deleteItem(ui);
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
        case 1 -> finance.financeCreditors(ui, membership, finance, member);
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

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.coachSubMenu(ui);
      choice = ui.getScanInt();
      switch (choice) {
        case 1 -> swimStylesSubMenu();
        case 2 -> competitionMembership.showSwimTeam(ui);
        case 3 -> competitionMembership.competitionResults(ui, competition);
        case 4 -> membership.convertToCompetitionMember(ui, training, fileHandler, competitionMember, competition);
        case 5 -> competitionMembership.addCompetition(ui, competition, competitionMember, fileHandler, training);
        case 6 -> competitionMembership.deleteCompetitonMember(ui);
        case 7 -> lostAndFound.addLostItem(ui);
        case 8 -> lostAndFound.deleteItem(ui);
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

  public void swimStylesSubMenu() {
    Menu menu = new Menu();

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.swimStylesSubMenu(ui);
      choice = ui.getScanInt();
      switch (choice) {
        case 1 -> competitionMembership.frontCrawl(ui);
        case 2 -> competitionMembership.butterfly(ui);
        case 3 -> competitionMembership.backstroke(ui);
        case 4 -> competitionMembership.breaststroke(ui);
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
}

