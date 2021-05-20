public class Menu {
  public void showMainMenu(UI ui){
    ui.displayBlue("\n\t\tWhalecome to the Dolphins swim club!\n");

    ui.display("          ");
    ui.display("1. Join the club"+"                         _.-,");
    ui.display("2. View your membership"+"              .--'  '-._");
    ui.display("3. Competition results"+ "            _/`-  _      '.");
    ui.display("4. Show members"+"                  '----'._`.----. \\");
    ui.display("5. Admin access"+"                           `     \\;");
    ui.display("6. Show lost and found"+"                          ;_\\");
    ui.display("9. Quit ");
    ui.displayBlue("Please choose: ");
  }

  public void chairmanSubMenu(UI ui){
    ui.display("1. Register new member.");
    ui.display("2. Change membership status.");
    ui.display("3. Delete a member.");
    ui.display("4. Add item to Lost and found");
    ui.display("5. Delete item from Lost and found");
    ui.display("9. Main menu");
    ui.display("Please choose: ");
  }

  public void financeSubMenu(UI ui){
    ui.display("1. Membership Statistics");
    ui.display("2. View finances");
    ui.display("3. Delete member");
    ui.display("4. Add item to Lost and found");
    ui.display("5. Delete item from Lost and found");
    ui.errorRed("9. DO NOT PUSH!");
    ui.display("Please choose: ");
  }

  public void coachSubMenu(UI ui){
    ui.display("1. Show styles.");
    ui.display("2. Show competition swimmers.");
    ui.display("3. Competition results");
    ui.display("4. Add competition member");
    ui.display("5. Delete competition member");
    ui.display("6. Add item to Lost and found");
    ui.display("7. Delete item from Lost and found");
    ui.display("9. Main menu");
    ui.display("Please choose: ");
  }

  public void swimStylesSubMenu(UI ui){
    ui.display("1. Front Crawl");
    ui.display("2. Butterfly");
    ui.display("3. Backstroke");
    ui.display("4. Breaststroke");
    ui.display("5. Sidestroke");
    ui.display("9. Coach menu");
    ui.display("Please choose: ");
  }
}
