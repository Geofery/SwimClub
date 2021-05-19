public abstract class Member {
  private String memberId;
  private String firstName;
  private String surName;
  private String age;
  private String sex;
  private boolean active = true;


  public Member(String memberId, String firstName, String surName, String age, String sex, boolean active) {
    this.memberId = memberId;
    this.firstName = firstName;
    this.surName = surName;
    this.age = age;
    this.sex = sex;
    this.active = active;
  }

  public Member() {
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

  public String getAge() { return age; }

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
        + ", " + " Membership status: " + active;
  }
}

