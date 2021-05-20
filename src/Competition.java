import java.util.ArrayList;

public class Competition {
  private String swimStyle;
  private String place;
  private String date;
  private String result;
  private int rank;

  public Competition(String swimStyle, String place, String date, String result, int rank) {
    this.swimStyle = swimStyle;
    this.place = place;
    this.date = date;
    this.result = result;
    this.rank = rank;
  }

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
}


