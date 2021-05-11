public class Main {
  public static void main(String[] args) {
    new Main().run();
  }
  public void run() {
    FileHandler fileHandler = new FileHandler();
    fileHandler.loadMembers();
    Membership membership = new Membership();
    System.out.println(membership.seniorXoTeam.toString());
  }
}
