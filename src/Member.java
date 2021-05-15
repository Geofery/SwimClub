public class Member {
  private String firstName;
  private String surName;
  private String age;
  private String sex;
  private boolean isActive = true;
  private String result;
  // It should be used when various implementations of the same kind share a common behavior.


  public Member(String firstName, String surName, String age, String sex, boolean membershipStatus, String results) {
    this.firstName = firstName;
    this.surName = surName;
    this.age = age;
    this.sex = sex;
    this.isActive = membershipStatus;
    this.result = results;
  }

  public Member(String firstName, String surName, String age, String sex) {
    this.firstName = firstName;
    this.surName = surName;
    this.age = age;
    this.sex = sex;
  }

  public void setActive(boolean active) {
    this.isActive = active;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSurName() {
    return surName;
  }

  public String getSex() {
    return sex;
  }

  public boolean isActive() {
    return isActive;
  }

  public String getResult() {
    return result;
  }

  public String getAge() {
    return age;
  }


    @Override
    public String toString() {
      return "First name: " + firstName + " Surname: " + surName + " Age: " + age + " Sex: " + sex +
              " Membership status: " + isActive + " Results: " + result + "\n";
    }
  }

