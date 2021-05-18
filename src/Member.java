public class Member {
  private String memberId;
  private String firstName;
  private String surName;
  private String age;
  private String sex;
  private boolean active = true;
  private String result;
  // It should be used when various implementations of the same kind share a common behavior.

  public Member(String memberId, String firstName, String surName, String age, String sex, boolean active, String result) {
    this.memberId = memberId;
    this.firstName = firstName;
    this.surName = surName;
    this.age = age;
    this.sex = sex;
    this.active = active;
    this.result = result;
  }

  public Member(String memberId, String firstName, String surName, String age, String sex, boolean active) {
    this.memberId = memberId;
    this.firstName = firstName;
    this.surName = surName;
    this.age = age;
    this.sex = sex;
    this.active = active;
  }

  public Member(String memberId, String firstName, String surName, String age, String sex) {
    this.memberId = memberId;
    this.firstName = firstName;
    this.surName = surName;
    this.age = age;
    this.sex = sex;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public String getMemberId() {
    return memberId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSurName() {
    return surName;
  }

  public String getAge() {
    return age;
  }

  public String getSex() {
    return sex;
  }

  public boolean isActive() {
    return active;
  }

  @Override
  public String toString() {
    return "Member ID: " + memberId + ", " + " First name: " + firstName + ", "
        + " Surname: " + surName + ", " + " Age: " + age + ", " + " Sex: " + sex
        + ", " + " Membership status: " + active + ", " + " result " + result;
  }
}

