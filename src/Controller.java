import java.util.Locale;

public class Controller {
    UI ui = new UI();
    FileHandler fileHandler = new FileHandler();
    Membership membership = new Membership();
    Finance finance = new Finance();
    LostAndFound lostAndFound = new LostAndFound();
    SwimStyle swimStyle;
    Member member;
    CompetitionMembership competitionMembership = new CompetitionMembership();
    CompetitionMember competitionMember;
    Training training;


    public void mainMenu() {
        Menu menu = new Menu();
        fileHandler.loadMembers(membership, member); //loads all the member into the array
        fileHandler.loadCompetitionMembers(membership,competitionMember,training,competitionMembership );
        lostAndFound.createLostAndFoundList();
        membership.allMembers();
        competitionMembership.allMembers();
        int choice;
        boolean keepRunning;

        do {
            keepRunning = true;
            menu.showMainMenu(ui);
            choice = ui.getScanInt();
            switch (choice) {
                case 1 -> membership.addNewMember(ui, member, membership, fileHandler);
                case 2 -> viewMembership();
                case 3 -> competitionResults();
                case 4 -> membership.displayMembers(ui);
                case 5 -> adminLogin();
                case 6 -> lostAndFound.displayLostAndFound(ui);
                case 9 -> {
                    ui.displayGreen("If in doubt, swim it out.....");
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {
                    }
                    ui.displayGreen("The wetter the better....");
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {
                    }
                    ui.errorRed("Water you sinking aboat");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    ui.displayGreen("We do it dirty in the deep end !!! :D");
                    keepRunning = false;
                }
            }
        } while (keepRunning);
    }

    public void viewMembership() {
        //TODO Jeff //   if no member needs to show that.
        ui.displayLine();
        ui.displayBlue("Enter your firstname with a capital letter ");
        String input = ui.getString();
        for (int i = 0; i < membership.getAllMembers().size(); i++) {
            if (input.equals(membership.getAllMembers().get(i).getFirstName())) {
                ui.displayGreen(membership.getAllMembers().get(i).toString());
            }
        }
        ui.displayLine();
    }

    public void competitionResults() {
        ui.displayLine();
        //Top 5 svømmere?
        //
        ui.displayLine();
    }

    public void adminLogin() { //TODO Christopher fix login sound and...
        ui.displayLine();
        ui.displayGreen("Please enter E-mail: ");
        String email = ui.getString().toLowerCase(Locale.ROOT);
        ui.displayGreen("Please enter your password: ");
        String password = ui.getString();

        if (email.equals("chairman") && password.equals("1234")) {
            ui.displayGreen("Login successful!");
            ui.displayLine();
            chairmanSubMenu();
        } else if (email.equals("finance") && password.equals("1234")) {
            ui.displayGreen("Login successful!");
            ui.displayLine();
            financeSubMenu();
        } else if (email.equals("coach") && password.equals("1234")) {
            ui.displayGreen("Login successful!");
            ui.displayLine();
            coachSubMenu();
        } else
            ui.errorRed("WATER YOU DOING??? ");
    }

        //JOptionPain
      /* JFrame frame = loginGui.createFrame();

        loginGui.listenForLogin();
        frame.setVisible(false);
        ui.displayLine();
        if (loginGui.getLoginRights() == 1) {
            chairmanSubMenu();
        } else if (loginGui.getLoginRights() == 2) {
            financeSubMenu();
        } else if (loginGui.getLoginRights() == 3) {
            coachSubMenu();
        } else
            ui.errorRed("Water you doing?!");
        ui.displayLine();*/

    public void chairmanSubMenu() {
        Menu menu = new Menu();

        int choice;
        boolean keepRunning;

        do {
            keepRunning = true;
            menu.chairmanSubMenu(ui);
            choice = ui.getScanInt();
            switch (choice) {
                case 1 -> membership.addNewMember(ui, member, membership, fileHandler);
                case 2 -> changeMembershipStatus();
                case 3 -> deleteMember();
                case 4 -> lostAndFound.addLostItem(ui);
                case 5 -> lostAndFound.deleteItem(ui);
                case 9 -> {
                    ui.displayGreen("Checking if you forgot anyfin.....");
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {
                    }
                    ui.displayGreen("Anyfin can happen when your part dolphin....");
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {
                    }
                    ui.errorRed("Water you doing !");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    ui.errorRed("Dont go further out than the belly button");
                    ui.displayGreen("Sea ya later! :D");
                    keepRunning = false;
                }
            }
        } while (keepRunning);
    }

    public void changeMembershipStatus() {
        ui.displayLine();
        membership.displayMembers(ui);
        ui.displayGreen("Set membership status: ");
        ui.displayGreen("1. Active");
        ui.displayGreen("2. Passive");
        ui.displayGreen("9. Back to admin");
        int choice = ui.getScanInt();
        if (choice == 1) {
            ui.displayGreen("What member?");
            membership.getAllMembers().get(ui.getScanInt() - 1).setActive(true);
        } else if (choice == 2) {
            ui.displayGreen("What member?");
            membership.getAllMembers().get(ui.getScanInt() - 1).setActive(false);
        } else if (choice == 9) {
            chairmanSubMenu();
        } else if (choice != 1 || choice != 2 || choice != 9) {
            ui.errorRed("WATER YOU SINKING ABOAT???");
            chairmanSubMenu();
        }
    }

    public void financeSubMenu() {
        Menu menu = new Menu();

        int choice;
        boolean keepRunning;

        do {
            keepRunning = true;
            menu.financeSubMenu(ui);
            choice = ui.getScanInt();
            switch (choice) {
                case 1 -> finance.financeCreditors(ui, membership, finance);
                case 2 -> finance.viewFinances(ui, membership);
                case 3 -> finance.deleteMember(ui, membership);
                case 4 -> lostAndFound.addLostItem(ui);
                case 5 -> lostAndFound.deleteItem(ui);
                case 9 -> {
                    ui.errorRed("WATER YOU SINKING ABOAT??");
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {
                    }
                    ui.displayGreen("Swimming away");
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {
                    }
                    ui.errorRed("SHARK !!!");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    ui.errorRed("U Dead???");
                    ui.displayGreen("Told you not to push it! :D");
                    keepRunning = false;
                }
            }
        } while (keepRunning);
    }


    public void deleteMember() {  // Cant be moved because chairman sub also uses it. finance delete has been moved.
        ui.displayLine();
        membership.displayMembers(ui);
        membership.deleteMember(ui);
        //TODO burde kunne smides ind i switchcase nu og resten af metoden slettes
        ui.displayLine();
    }

    public void coachSubMenu() {
        Menu menu = new Menu();
        competitionMembership.swimStyleIdentifierYouth(competitionMember);
        competitionMembership.swimStyleIdentifierSenior(competitionMember);

        int choice;
        boolean keepRunning;

        do {
            keepRunning = true;
            menu.coachSubMenu(ui);
            choice = ui.getScanInt();
            switch (choice) {
                case 1 -> swimStylesSubMenu();
                case 2 -> competitionMembership.showSwimmers(ui);
                case 3 -> competitionResults();
                case 4 -> addCompetitonMember();
                case 5 -> deleteCompetitonMember();
                case 6 -> lostAndFound.addLostItem(ui);
                case 7 -> lostAndFound.deleteItem(ui);
                case 9 -> {
                    ui.displayGreen("Swimming away.....");
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {
                    }
                    ui.displayGreen("Still swimming....");
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {
                    }
                    ui.errorRed("SHARK!!!");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    ui.errorRed("False alarm!");
                    ui.displayGreen("Don't count laps. Make every lap count. :D");
                    keepRunning = false;
                }
            }
        } while (keepRunning);
    }


    private void addCompetitonMember() { //todo valiadate !age > 60
        membership.displayMembers(ui);
        ui.displayGreen("Input member Id");
        String memberId = ui.getString();
        while (!validateMemberId(memberId)){
            memberId = ui.getString();
        }

        ui.displayGreen("What swimstyle, do you want to the member to comepete in?");
        ui.displayGreen("1. Frontcrawl: \n2. Backstroke: \n3. Breaststroke: \n4. Butterfly  \n9. to go back\n");
        int coachChoice = ui.getScanInt();
        ui.displayGreen("Enter training result in format **,**");
        String result = ui.getString();
        String choice = "";
        if (coachChoice == 1) {
            choice = swimStyle.Frontcrawl.toString();
            ui.displayGreen(choice);
        } else if (coachChoice == 2) {
            choice = swimStyle.Backstroke.toString();
        } else if (coachChoice == 3) {
            choice = swimStyle.Breaststroke.toString();
        } else if (coachChoice == 4) {
            choice = swimStyle.Butterfly.toString();
            ;
        } else if (coachChoice == 9) {
            coachSubMenu();
        }
        if (validateMemberAge(memberId) == true) {
            training = new Training(ui.date(), result);
            for (int i = 0; i < membership.getAllMembers().size(); i++) {
                if (membership.getAllMembers().get(i).getMemberId().equals(memberId)) {
                    competitionMember = new CompetitionMember(membership.getAllMembers().get(i).getMemberId().replaceAll("M", "C"),
                        membership.getAllMembers().get(i).getFirstName(), membership.getAllMembers().get(i).getSurName(),
                        membership.getAllMembers().get(i).getAge(), membership.getAllMembers().get(i).getSex(),
                        membership.getAllMembers().get(i).isActive(), choice, training);
                        membership.getAllMembers().remove(i);
                }
            }
            fileHandler.saveCompetitionMember(competitionMember, choice,training);
        }
    }

    public boolean validateMemberAge(String memberId){
        int validateAge = 1961;
        for (int i = 0; i < membership.getAllMembers().size(); i++) {
            if (membership.getAllMembers().get(i).getMemberId().equals(memberId) && Integer.parseInt(membership.getAllMembers().get(i).getAge()) > validateAge){
                return true;
            }
        }
        ui.errorRed("Member is to old to compete!");
        return false;
    }

    public boolean validateMemberId(String memberId){
        if (memberId.startsWith("M")){
            return true;
        }else
            ui.errorRed("Invalid input");
            return false;
    }

    private void deleteCompetitonMember() { //todo if there is time
        for (int i = 0; i < membership.getAllMembers().size(); i++) {
            membership.displayMembers(ui);
            ui.displayGreen("input member Id og the member you want to delete");
            String memberId = ui.getString();
            if (membership.getAllMembers().get(i).getMemberId().equals(memberId)) {

            }
        }
    }

    public void swimStylesSubMenu() {
        Menu menu = new Menu();

        int choice;
        boolean keepRunning;

        do {
            keepRunning = true;
            menu.swimStylesSubMenu(ui);
            choice = ui.getScanInt();
            switch (choice) {
                case 1 -> frontCrawl();
                case 2 -> butterfly();
                case 3 -> backstroke();
                case 4 -> breaststroke();
                case 9 -> {
                    ui.displayGreen("Water we waiting for.....");
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {
                    }
                    ui.displayGreen("Water-ever it takes....");
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {
                    }
                    ui.errorRed("System error!");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    ui.errorRed("7 Days Without Swimming Makes One Weak.");
                    ui.displayGreen("You should eat your pasta if you want to swim fasta! :D");
                    keepRunning = false;
                }
            }
        } while (keepRunning);
    }

    public void frontCrawl() {

    }

    public void butterfly() {
    }

    public void backstroke() {
    }

    public void breaststroke() {
    }


}

