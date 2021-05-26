public class CompetitionMember extends Member {
    private Training training;
    private Competition competition;
    private String swimStyle;


    public CompetitionMember(String memberId, String firstName, String surName, String age, String sex, String active,
                             String swimStyle, Training trainingResult, Competition competitionResult) {
        super(memberId, firstName, surName, age, sex, active);
        this.swimStyle = swimStyle;
        this.training = trainingResult;
        this.competition = competitionResult;
    }

    public CompetitionMember(String memberId, String firstName, String surName, String age, String sex, String active, String swimStyle, Training trainingResult) {
        super(memberId, firstName, surName, age, sex, active);
        this.swimStyle = swimStyle;
        this.training = trainingResult;
    }

    public Training getTraining() { return training; }
    public Competition getCompetition() { return competition; }
    public String getSwimStyle() { return swimStyle; }



    @Override
    public String toString() {
        return "Member ID: " + getMemberId() + ", First name: " + getFirstName()
            + ", Surname: " + getSurName() + ", Age: " + getAge() + ", Sex: " + getGender()
            + "\nSwimStyle: " + swimStyle +",\n" + training + "\n" + "Competition: "
            + competition + "\n";
    }
}

