public class CompetitionMember extends Member {
    private String trainingResult;
    private String competitionResult;
    private String swimStyle;

    public CompetitionMember(String memberId, String firstName, String surName, String age, String sex, boolean active,
                             String swimStyle, String trainingResult, String competitionResult) {
        super(memberId, firstName, surName, age, sex, active);
        this.swimStyle = swimStyle;
        this.trainingResult = trainingResult;
        this.competitionResult = competitionResult;
    }

    public String getTrainingResult() { return trainingResult; }
    public String getCompetitionResult() { return competitionResult; }
    public String getSwimStyle() { return swimStyle; }

    public void setTrainingResult(String trainingResult) { this.trainingResult = trainingResult; }
    public void setCompetitionResult(String competitionResult) { this.competitionResult = competitionResult; }
    public void setSwimStyle(String swimStyle) {
        this.swimStyle = swimStyle;
    }
}

