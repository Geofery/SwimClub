public class Menu {
  public void showMainMenu(){

    System.out.println("\nWelcome to Rock, Paper or Scissors!\n");
    System.out.println("          RULES:");
    System.out.println("Get the higest win streak.");
    System.out.println("If you loose, your win streak resets!\n");
    System.out.println("1. New game");
    // System.out.println("2. Show Score");
    System.out.println("2. Show leaderboard");
    System.out.println("9. Quit game");
    System.out.println("Please choose: ");
  }

  public void showNewGameMenu(){
    System.out.println("1. Rock");
    System.out.println("2. Paper");
    System.out.println("3. Scissors");
    System.out.println("4. Show score");
    System.out.println("9. Main menu");
  }

  public void showSubMenu(){}
}
