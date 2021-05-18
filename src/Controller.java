import javax.swing.*;
import java.util.Collections;
import java.util.Comparator;

public class Controller {
  UI ui = new UI();
  Member member;
  Competition competition;
  Training training;
  LoginGui loginGui = new LoginGui();
  FileHandler fileHandler = new FileHandler();
  Membership membership = new Membership();
  Finance finance = new Finance();
  LostAndFound lostAndFound = new LostAndFound();
  // Competition competition = new Competition();
  //CompetitionMember competitionMember = new CompetitionMember(member.getMemberId(), member.getFirstName(), member.getSurName(), member.getAge(), member.getSex(), member.isActive(), competition.getSwimStyle());


  public void mainMenu() {
    Menu menu = new Menu();
    fileHandler.loadMembers(membership, member); //loads all the member into the array
    lostAndFound.createLostAndFoundList();
    membership.allMembers();
    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.showMainMenu(ui);
      choice = ui.getScanInt();
      switch (choice) {
        case 1 -> membership.registerNewMember(ui, member, membership, fileHandler);
        case 2 -> viewMembership();
        case 3 -> competitionResults();
        case 4 -> showMembers();
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

  public void viewMembership() {
    //TODO Jeff // Something is wrong it displays a member ++ times  ||  if no member needs to show that.
    ui.displayLine();
    ui.displayBlue("Enter your firstname with a capital letter ");
    String input = ui.getString();
    membership.allMembers();
    for (int i = 0; i < membership.allMembers.size(); i++) {
      if (input.equals(membership.allMembers.get(i).getFirstName())) {
        ui.displayGreen(membership.allMembers.get(i).toString());
      }
    }
    ui.displayLine();
  }

  public void competitionResults() {
    ui.displayLine();
    //Top 5 svømmere?
    //
    ui.displayLine();
  }

  public void showMembers() {
    ui.displayLine();
    Collections.sort(membership.allMembers, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
    membership.displayMembers(ui);
    ui.displayLine();
  }

  public void adminLogin() { //TODO Jeff FIX så det virker!
    JFrame frame = loginGui.createFrame();
    while (!loginGui.isFilledOut())
      ;
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
      menu.chairmanSubMenu(ui);
      choice = ui.getScanInt();
      switch (choice) {
        case 1 -> membership.registerNewMember(ui, member, membership, fileHandler);
        case 2 -> changeMembershipStatus();
        case 3 -> deleteMember();
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

  public void changeMembershipStatus() {
    ui.displayLine();
    membership.displayMembers(ui);
    ui.displayGreen("Set membership status: ");
    ui.displayGreen("1. Active");
    ui.displayGreen("2. Passive");
    ui.displayGreen("9. Back to admin");
    int choice = ui.getScanInt();
    if (choice == 1) {
      ui.displayGreen("What member?");
      membership.allMembers.get(ui.getScanInt() - 1).setActive(true);
    } else if (choice == 2) {
      ui.displayGreen("What member?");
      membership.allMembers.get(ui.getScanInt() - 1).setActive(false);
    } else if (choice == 9) {
      chairmanSubMenu();
    } else if (choice != 1 || choice != 2 || choice != 9) {
      ui.errorRed("WATER YOU SINKING ABOAT???");
      chairmanSubMenu();
    }
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
        case 1 -> finance.financeCreditors(ui);
        case 2 -> finance.viewFinances(ui, membership);
        case 3 -> finance.deleteMember(ui, membership);
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


  public void deleteMember() {  // Cant be moved because chairman sub also uses it. finance delete has been moved.
    ui.displayLine();
    membership.displayMembers(ui);
    membership.deleteMember(ui);
    //TODO burde kunne smides ind i switchcase nu og resten af metoden slettes
    ui.displayLine();
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
        case 2 -> showSwimmers();
        case 3 -> competitionResults();
        case 4 -> addCompetitonMember();
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

  public void showSwimmers() {//TODO skal laves færdig
    ui.displayLine();
    showMembers();
    ui.displayLine();
  }

  private void addCompetitonMember() {


  }

  private void deleteCompetitonMember() {
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
        case 5 -> sidestroke();
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

