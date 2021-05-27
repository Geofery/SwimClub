package objects;

//Christopher & Jeffrey
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

  public String toDisplayString() {
    return "Location: " + place  +
        ", Date: " + date  +
        ", Swim time: " + result +
        ", Position: " + rank;
  }

  @Override
  public String toString() {
    return place + " " + date+ " " + result + " " + rank;
  }
}


