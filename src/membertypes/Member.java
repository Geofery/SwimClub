package membertypes;

public class Member {
  private String memberId;
  private String firstName;
  private String surName;
  private String age;
  private String gender;
  private String active; // TODO lav til en String Active /Passive Evt. en Metode Not possible because ageIdentifier

  public Member(String memberId, String firstName, String surName, String age, String gender, String active) {
    this.memberId = memberId;
    this.firstName = firstName;
    this.surName = surName;
    this.age = age;
    this.gender = gender;
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

  public String getActive() {
    return active;
  }

  public void setActive(String active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return "Member ID: " + memberId + ", " + " First name: " + firstName + ", "
        + " Surname: " + surName + ", " + " Age: " + age + ", " + " Sex: " + gender
        + ", " + " Membership status: " + active;
  }
}

