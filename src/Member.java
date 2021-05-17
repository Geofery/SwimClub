public class Member {
    private String firstName;
    private String surName;
    private String age;
    private String sex;
    private boolean active = true;
    private String result;
    //private boolean competing = true;
    // It should be used when various implementations of the same kind share a common behavior.


    public Member(String firstName, String surName, String age, String sex, boolean active, String result) {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
        this.sex = sex;
        this.active = active;
        this.result = result;
        // this.competing = competing;
    }

    public Member(String firstName, String surName, String age, String sex, boolean active) {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
        this.sex = sex;
        this.active = active;
    }

    public Member(String firstName, String surName, String age, String sex) {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
        this.sex = sex;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getResult() {
        return result;
    }
// public boolean isCompeting() { return competing; }


    @Override
    public String toString() {
        return "First name: " + firstName + " Surname: " + surName + " Age: " + age + " Sex: " + sex +
                " Membership status: " + active + " result " + result + "\n";
    }
}

