public abstract class Member {
  private String name;
  private String age;
  private boolean membershipStatus;
  private String results;
 // It should be used when various implementations of the same kind share a common behavior.


  public Member(String name, String age, boolean membershipStatus, String results) {
    this.name = name;
    this.age = age;
    this.membershipStatus = membershipStatus;
    this.results = results;
  }
}
