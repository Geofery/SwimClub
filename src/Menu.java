public class Menu {

  public void showMainMenu(){
    System.out.println("\nWelcome to the Dolphins swim club!\n");
    System.out.println("          ");
    System.out.println("1. Join the club");
    System.out.println("2. View you membership");
    System.out.println("3. Competition results");
    System.out.println("4. Show members");
    System.out.println("5. Admin access");
    System.out.println("6. Show lost and found");
    System.out.println("9. Quit ");
    System.out.println("Please choose: ");
  }

  public void chairmanSubMenu(){
    System.out.println("1. Register new member.");
    System.out.println("2. Change membership status.");
    System.out.println("3. Change activity type."); //TODO beskrivelse skal ændres
    System.out.println("4. Add item to Lost and found");
    System.out.println("5. Delete item from Lost and found");
    System.out.println("9. Main menu");
    System.out.println("Please choose: ");
  }

  public void financeSubMenu(){
    System.out.println("1. Membership Statistics");
    System.out.println("2. View finances");
    System.out.println("3. Delete member");
    System.out.println("4. Add item to Lost and found");
    System.out.println("5. Delete item from Lost and found");
    System.out.println("9. Main menu");
    System.out.println("Please choose: ");
  }

  public void coachSubMenu(){
    System.out.println("1. Show styles.");
    System.out.println("2. Show swimmers.");
    System.out.println("3. Competition results");
    System.out.println("4. Add item to Lost and found");
    System.out.println("5. Delete item from Lost and found");
    System.out.println("9. Main menu");
    System.out.println("Please choose: ");
  }

  public void swimStylesSubMenu(){
    System.out.println("1. Front Crawl");
    System.out.println("2. Butterfly");
    System.out.println("3. Backstroke");
    System.out.println("4. Breaststroke");
    System.out.println("5. Sidestroke");
    System.out.println("9. Coach menu");
    System.out.println("Please choose: ");
  }
}
