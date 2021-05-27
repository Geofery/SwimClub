package application;

import menu.Controller;
//Jeffrey & Christopher
public class Main {
  public static void main(String[] args) {
    new Main().run();
  }
  public void run() {
    Controller controller = new Controller();
    controller.mainMenu();
  }
}
