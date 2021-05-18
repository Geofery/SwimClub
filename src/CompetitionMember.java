import java.util.ArrayList;

public class CompetitionMember extends Member {
    private String swimStyle;

    ArrayList<Training> trainingResults = new ArrayList<Training>();
    ArrayList<Competition> competitionResults = new ArrayList<Competition>();
    public CompetitionMember(String memberId, String firstName, String surName, String age, String sex, boolean active,
                             String swimStyle) {
        super(memberId, firstName, surName, age, sex, active);
        this.swimStyle = swimStyle;
       // this.trainingResults = trainings;
        //this.competitionResults = competitions;
    }



    public String getSwimStyle() {
        return swimStyle;
    }

    public void setSwimStyle(String swimStyle) {
        this.swimStyle = swimStyle;
    }

}
