import java.lang.management.MemoryManagerMXBean;

public class Controller {
  UI ui = new UI();
  Member member;
  Membership membership = new Membership();


  public void run() {
    Menu menu = new Menu();

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.showMainMenu();
      choice = ui.getScanInt();
      switch (choice) {
        case 1:
          createMember();
          break;
        case 2:
          break;
        case 3:
          break;
        case 4:
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

  public void createMember() {
    member = new Member(ui.getString(), ui.getString(), ui.getString(), ui.getString());
    membership.ageIdentifier();
  }

  public void subsdsadsadasMenu() {
    Menu menu = new Menu();

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.showMainMenu();
      choice = ui.getScanInt();
      switch (choice) {
        case 1:
          break;
        case 2:
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


}

