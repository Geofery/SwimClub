import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileHandler {
    UI ui = new UI();
    Membership membership;
    File file = new File("Members.txt");
    Member member;
    private String firstName;
    private String surName;
    private String age;
    private String sex;
    private boolean membershipStatus;
    private String results;

    public void saveMember(String name, int points) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.write(name.replaceAll("\\[", "").replaceAll("]", "")
                    .replaceAll(",", "") + " " + points);
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMembers() {

        Scanner fileReader = null;
        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ui.displayGreen("First name   Surname   Age   Sex   Membership status   Results ");
        ui.display("______________________");


        while (fileReader.hasNext()) {
            firstName = fileReader.next();
            surName = fileReader.next();
            age = fileReader.next();
            sex = fileReader.next();
            membershipStatus = fileReader.nextBoolean();
            results = fileReader.next();
            new Member(firstName,surName, age, sex, membershipStatus, results);
            membership.ageIdentifier(member);
        }
    }
}
