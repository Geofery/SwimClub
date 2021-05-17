import java.util.ArrayList;

public class CompetitionMember extends Member {
    ArrayList<Training> trainings = new ArrayList<Training>();
    ArrayList<Competetion> competetions = new ArrayList<Competetion>();

    public CompetitionMember(String firstName, String surName, String age, String sex, boolean active, boolean competing, String result, String swimStyle) {
        super(firstName, surName, age, sex, active, result);
        this.result = result;
        this.swimStyle = swimStyle;



    }
}
