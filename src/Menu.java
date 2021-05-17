public class Menu {
  public void showMainMenu(UI ui){
    ui.displayBlue("\nWelcome to the Dolphins swim club!");
    ui.displayBlue("" +
            "                  _.-,\n" +
            "              .--'  '-._\n" +
            "           _/`-  _      '.\n" +
            "          '----'._`.----. \\\n" +
            "                   `     \\;\n" +
            "                         ;_\\");
    ui.displayLine();

    ui.displayBlue("" +
            "                      .-\"\"\"-.\n" +
            "                     /       \\\n" +
            "                    ;_.-\"\"\"-._;\n" +
            " .,_       __,.---.-(=(o)-(o)=)-.---.,__       _,.\n" +
            " '._'--\"```          \\   ^   /          ```\"--'_.'\n" +
            "    ``\"''~---~~%^%^.%.`._0_.'%,^%^%^~~---~''\"``\n" +
            "    ~^~- `^-% ^~.%~%.^~-%-~.%-^.% ~`% ~-`%^`-~^~\n" +
            "       ~^- ~^- `~.^- %`~.%~-'%~^- %~^- ~^");
    ui.display("          ");
    ui.display("1. Join the club");
    ui.display("2. View you membership");
    ui.display("3. Competition results");
    ui.display("4. Show members");
    ui.display("5. Admin access");
    ui.display("6. Show lost and found");
    ui.display("9. Quit ");
    ui.display("Please choose: ");
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
    ui.display("2. Show swimmers.");
    ui.display("3. Competition results");
    ui.display("4. Add item to Lost and found");
    ui.display("5. Delete item from Lost and found");
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
