import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class FileHandler {
    File file = new File("Members.txt");
    File trainings = new File("Training.txt");
    File competitions = new File("Competitions.txt");

    private String firstName;
    private String surName;
    private String age;
    private String sex;
    private boolean active;
    //.-.-.-.--.-.-.-....-.-.-.-.
    private String swimStyle;
    private String place;
    private String date;
    private String result;
    private int rank;

    public void saveMember(Member member) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {

            firstName = member.getFirstName();
            surName = member.getSurName();
            age = member.getAge();
            sex = member.getSex();
            active = member.isActive();
            //result = member.getResult();
            // competing = competition.isCompeting();

            bw.write(firstName.replaceAll("\\[", "").replaceAll("]", "")
                    .replaceAll(",", "\t") + " " + surName + "\t\t\t" + age + "\t" + sex + "\t" + active);
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMembers(Membership membership, Member member) {

        Scanner fileReader = null;
        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (fileReader.hasNext()) {
            firstName = fileReader.next();
            surName = fileReader.next();
            age = fileReader.next();
            sex = fileReader.next();
            active = fileReader.nextBoolean();

            //IF Statement som nogengange bruger result og andre
            //gange skipper den.
     /* if (result.equals(null)) {
        member = new Member(firstName, surName, age, sex);
      } else*/
            member = new Member(firstName, surName, age, sex, active);
            membership.ageIdentifier(member);
        }
    }


    ////////////////////////////////////////////////////////////


    public void saveCompetitions(Member member, Competition competition) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(competitions, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {

            swimStyle = competition.getSwimStyle();
            place = competition.getPlace();
            date = competition.getDate();
            result = competition.getResult();
            rank = competition.getRank();


            bw.write(swimStyle.replaceAll("\\[", "").replaceAll("]", "")
                    .replaceAll(",", "\t") + " " + place + "\t\t\t" + date + "\t" + result + "\t" + rank);
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCompetitions(Membership membership, Member member, Competition competition, CompetitionMember competitionMember) {

        Scanner fileReader = null;
        try {
            fileReader = new Scanner(competitions);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (fileReader.hasNext()) {
            swimStyle = fileReader.next();
            place = fileReader.next();
            date = fileReader.next();
            result = fileReader.next();
            rank = fileReader.nextInt();

            competition = new Competition(swimStyle, place, date, result, rank);
            competitionMember.competitionResults.add(competition);
        }
    }

    public void saveTrainings(Member member, Training training) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(trainings, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            date = training.getDate();
            result = training.getResult();


            bw.write(date.replaceAll("\\[", "").replaceAll("]", "")
                    .replaceAll(",", "\t") + " " + result);
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTrainings(Membership membership, Member member, Training training, CompetitionMember competitionMember) {

        Scanner fileReader = null;
        try {
            fileReader = new Scanner(trainings);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (fileReader.hasNext()) {
            date = fileReader.next();
            result = fileReader.next();

            training = new Training(date, result);
            competitionMember.trainingResults.add(training);
        }
    }
}
