import java.util.ArrayList;
import java.util.Date;

public class Training {
  private String date;
  private String result;

  public Training(String date, String result) {
    this.date = date;
    this.result = result;
  }

  ArrayList<Training> trainingResults = new ArrayList<Training>();

  public String getDate() {
    return date;
  }

  public String getResult() {
    return result;
  }
}
