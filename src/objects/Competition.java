package objects;

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

  //Bliver ikke brugt da vi ikke har adgang til det fra vores ArrayList
  public String getPlace() {
    return place;
  }

  public String getDate() {
    return date;
  }

  public String getResult() {
    return result;
  }

  public int getRank() {
    return rank;
  }

  //Ser bedst ud når vi udskriver vores members.
  /*@Override
  public String toString() {
    return "Location: " + place  +
        ", Date: " + date  +
        ", Swim time: " + result +
        ", Position: " + rank;
  }*/

  //Kan gemme til fil uden ændringer.
  @Override
  public String toString() {
    return place + " " + date+ " " + result + " " + rank;
  }
}


