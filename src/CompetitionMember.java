public class CompetitionMember extends Member {
    private Training trainingResult;
    private Competition competitionResult;
    private String swimStyle;

    public CompetitionMember(String memberId, String firstName, String surName, String age, String sex, boolean active,
                             String swimStyle, Training trainingResult, Competition competitionResult) {
        super(memberId, firstName, surName, age, sex, active);
        this.swimStyle = swimStyle;
        this.trainingResult = trainingResult;
        this.competitionResult = competitionResult;
    }

    public CompetitionMember(String memberId, String firstName, String surName, String age, String sex, boolean active, String swimStyle, Training trainingResult) {
        super(memberId, firstName, surName, age, sex, active);
        this.swimStyle = swimStyle;
        this.trainingResult = trainingResult;
    }

    public Training getTrainingResult() { return trainingResult; }
    public Competition getCompetitionResult() { return competitionResult; }
    public String getSwimStyle() { return swimStyle; }

    @Override
    public String toString() {
        return  "Member ID: " + getMemberId() + ", First name: " + getFirstName()
                + ", Surname: " + getSurName() + ", Age: " + getAge()  + ", Sex: " + getGender()
                + "\nSwimStyle: "  + swimStyle + ", Date: " + trainingResult.getDate() +
                ", Training result: " + trainingResult.getResult() + ", CompetitionResult: "
                + competitionResult+ "\n";
    }

}

