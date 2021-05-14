import java.util.ArrayList;

public class LostAndFound {
  ArrayList<String> lostAndFound = new ArrayList<>();
  private String item;

  public void createLostAndFoundList() {
    lostAndFound.add("Left swim fin.");
    lostAndFound.add("Wedding dress and shoes size XXL.");
    lostAndFound.add("50 vacuum-packed frogs.");
    lostAndFound.add("Speedoes suspiciously discolored.");
    lostAndFound.add("A Goldfish, kinda alive.");
    lostAndFound.add("Some kind of used balloon looking thing, strawberry flavored???");
    lostAndFound.add("White powder in a zip bag, maby used for baking??");
    lostAndFound.add("A fly on a leash.");
  }

  public void displayLostAndFound(UI ui) {
    ui.displayLine();
    ui.displayGreen("Water you looking for??\n \t\t \"Lost and Found!\"\n");
    for (int i = 0; i < lostAndFound.size(); i++) {
      ui.displayGreen(i + 1 + ". " + lostAndFound.get(i));
    }
    ui.displayLine();
  }

  public void addLostItem(UI ui) {
    ui.displayGreen("Please write what item has been found:");
    lostAndFound.add(ui.getString());
  }

  public void deleteItem(UI ui) {
    displayLostAndFound(ui);
    ui.displayGreen("What item has been picked up?");
    lostAndFound.remove(ui.getScanInt() - 1);
  }
}
