public class Competition extends Member {
    private String result;
    private String swimStyle;

    public Competition(String firstName, String surName, String age, String sex, boolean active, boolean competing, String result, String swimStyle) {
        super(firstName, surName, age, sex, active, competing);
        this.result = result;
        this.swimStyle = swimStyle;


    }
}
