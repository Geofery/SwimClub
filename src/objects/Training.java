package objects;

public class Training {
  private String date;
  private String result;

  public Training(String date, String result) {
    this.date = date;
    this.result = result;
  }

  public String getDate() {
    return date;
  }

  public String getResult() {
    return result;
  }

  @Override
  public String toString() {
    return  date + " " + result;
  }


  public int compareTo(Training o) {
    return this.result.compareTo(o.getResult());
  }
}
