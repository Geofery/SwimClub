package objects;
//Christopher & Jeffrey
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

  public int compareTo(Training o) {
    return this.result.compareTo(o.getResult());
  }

  public String toDisplayString(){
    return "Date: " + date + ", Result: " + result;
  }

  @Override
  public String toString() {
    return  date + " " + result;
  }
}
