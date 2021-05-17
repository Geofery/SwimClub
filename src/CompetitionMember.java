import java.util.ArrayList;

public class CompetitionMember extends Member {
    private String swimStyle;
    ArrayList<Training> trainings = new ArrayList<Training>();
    ArrayList<Competition> competitions = new ArrayList<Competition>();

    public CompetitionMember(String firstName, String surName, String age, String sex, boolean active, String swimStyle, ArrayList trainings, ArrayList competitions) {
        super(firstName, surName, age, sex, active);
        this.swimStyle = swimStyle;
        this.trainings = trainings;
        this.competitions = competitions;
    }
}
