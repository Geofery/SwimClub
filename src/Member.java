public class Member {
  private String firstName;
  private String surName;
  private String age;
  private String sex;
  private boolean membershipStatus;
  private String results;
  // It should be used when various implementations of the same kind share a common behavior.


  public Member(String firstName, String surName, String age, String sex, boolean membershipStatus, String results) {
    this.firstName = firstName;
    this.surName = surName;
    this.age = age;
    this.sex = sex;
    this.membershipStatus = membershipStatus;
    this.results = results;
  }

  public Member(String firstName, String surName, String age, String sex, String results) {
    this.firstName = firstName;
    this.surName = surName;
    this.age = age;
    this.sex = sex;
    this.results = results;
  }

  public String getAge() {
    return age;
  }

  @Override
  public String toString() {
    return firstName + '\'' +
        ", surName='" + surName + '\'' +
        ", age='" + age + '\'' +
        ", sex='" + sex + '\'' +
        ", membershipStatus=" + membershipStatus +
        ", results='" + results;
  }
}
