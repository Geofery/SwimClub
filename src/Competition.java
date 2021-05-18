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
  ArrayList<Training> trainingResults = new ArrayList<Training>();
  ArrayList<Competition> competitionResults = new ArrayList<Competition>();
  /*public String getSwimStyle() {
    return swimStyle;
  }*/

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


