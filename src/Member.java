public class Member {
  private String name;
  private String age;
  private String sex;
  private boolean membershipStatus;
  private String results;
 // It should be used when various implementations of the same kind share a common behavior.


  public Member(String name, String age, String sex, boolean membershipStatus, String results) {
    this.name = name;
    this.age = age;
    this.sex = sex;
    this.membershipStatus = membershipStatus;
    this.results = results;
  }
}
