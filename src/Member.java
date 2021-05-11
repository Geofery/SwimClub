public class Member {
  private String name;
  private String age;
  private String sex;
  private boolean membershipStatus;
  private String results;
 // It should be used when various implementations of the same kind share a common behavior.


  public Member(String name, String age, String sex, String results) {
    this.name = name;
    this.age = age;
    this.sex = sex;
    this.results = results;
  }

  public String getAge() {
    return age;
  }
}
