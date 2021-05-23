public class Member {
  private String memberId;
  private String firstName;
  private String surName;
  private String age;
  private String gender;
  private boolean active; // TODO lav til en String Active /Passive Evt. en Metode


  public Member(String memberId, String firstName, String surName, String age, String gender, boolean active) {
    this.memberId = memberId;
    this.firstName = firstName;
    this.surName = surName;
    this.age = age;
    this.gender = gender;
    this.active = active;
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

  public String getGender() {
    return gender;
  }

  public boolean isActive() {
    return active;
  }

  @Override
  public String toString() {
    return "Member ID: " + memberId + ", " + " First name: " + firstName + ", "
        + " Surname: " + surName + ", " + " Age: " + age + ", " + " Gender: " + gender
        + ", " + " Membership status: " + active;
  }
}

