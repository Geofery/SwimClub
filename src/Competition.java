
public class Competition {
  private String place;
  private String date;
  private String result;
  private int rank;

  public Competition(String place, String date, String result, int rank) {
    this.place = place;
    this.date = date;
    this.result = result;
    this.rank = rank;
  }

  @Override
  public String toString() {
    return "Location: " + place  +
        ", Date: " + date  +
        ", Swim time: " + result +
        ", Position: " + rank;
  }

  //TODO Implement this now please!
}


