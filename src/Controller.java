import java.text.DecimalFormat;

public class Controller {
    UI ui = new UI();
    Member member;
    LoginGui loginGui = new LoginGui();
    FileHandler fileHandler = new FileHandler();
    Membership membership = new Membership();
    Finance finance = new Finance();


    public void mainMenu() {
        Menu menu = new Menu();
        fileHandler.loadMembers(membership, member); //loads all the member into the array // maybe messes up filesave?
        int choice;
        boolean keepRunning;

        do {
            keepRunning = true;
            menu.showMainMenu();
            choice = ui.getScanInt();
            switch (choice) {
                case 1:
                    joinTheClub();
                    break;
                case 2:
                    viewMembership();
                    break;
                case 3:
                    competitionResults();
                    break;
                case 4:
                    showMembers();
                    break;
                case 5:
                    adminLogin();
                    break;
                case 9:
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
                    ui.errorRed("Water you sinking aboat");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    ui.displayGreen("Swim ya later! :D");


                    keepRunning = false;
            }
        } while (keepRunning);
    }

    public void joinTheClub() {
        registerNewMember();
    }

    public void viewMembership() {
        //TODO Christopher
        ui.displayGreen("Enter your name id");
        String input = ui.getString();
        membership.allMembers();
        for (int i = 0; i < membership.allMembers.size(); i++) {
            if (input.equals(membership.allMembers.get(i).getFirstName())) {
                ui.displayGreen(membership.allMembers.get(i).toString());
            }
        }
    }

    public void competitionResults() {
        //Top 5 svømmere?
        //
    }

    public void showMembers() { //TODO FIX this filtrering natual order...
        //Filtrering natual order...
        //ui.displayGreen(membership.youthTeam + "\n" + membership.seniorTeam + "\n" + membership.seniorXoTeam + "\n" + membership.passive);

        ui.displayGreen(membership.allMembers().toString()); //shorter than above
        //ui.displayGreen(membership.allMembers().sort(naturalOrder().toString()); needs interface to work
    }

    public void adminLogin() {
        //   loginGui.createFrame();
        int type = 2;
        type = loginGui.getLoginRights(type);
        if (loginGui.getLoginRights(type) == 1) {
            chairmanSubMenu();
        } else if (loginGui.getLoginRights(type) == 2) {
            financeSubMenu();
        } else if (loginGui.getLoginRights(type) == 3)
            coachSubMenu();
        else
            ui.errorRed("Water you doing?!");
    }


    public void chairmanSubMenu() {
        Menu menu = new Menu();

        int choice;
        boolean keepRunning;

        do {
            keepRunning = true;
            menu.chairmanSubMenu();
            choice = ui.getScanInt();
            switch (choice) {
                case 1:
                    registerNewMember();
                    break;
                case 2:
                    changeMembershipStatus();
                    break;
                case 3:
                    changeActivityLevel();
                    break;
                case 4:
                    addLostFound();
                    ;
                    break;
                case 5:
                    deleteLostFound();
                    ;
                    break;
                case 9:
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
                    ui.errorRed("Water you doing !");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    ui.errorRed("F40");
                    ui.displayGreen("We do it dirty in the deep end !!! :D");


                    keepRunning = false;
            }
        } while (keepRunning);
    }

    public void registerNewMember() {
        ui.displayGreen("Please enter Name");
        String name = ui.getString();
        ui.displayGreen("Please enter surname");
        String surName = ui.getString();
        ui.displayGreen("Please enter year of birth");
        String year = ui.getString();
        ui.displayGreen("Please enter sex");
        String sex = ui.getString();
        member = new Member(name, surName, year, sex);
        membership.ageIdentifier(member);
        fileHandler.saveMember(member);
    }

    public void changeMembershipStatus() {
    }

    public void changeActivityLevel() {
        //Kalder på viewmembership, så vi har en enkelt bruger.
        ui.displayGreen("Set membership status: ");
        ui.displayGreen("1. Active");
        ui.displayGreen("2. Passive");
        if (ui.getScanInt() == 1) {
            member.setActive(true);
        } else
            member.setActive(false);
    }

    public void financeSubMenu() {
        Menu menu = new Menu();

        int choice;
        boolean keepRunning;

        do {
            keepRunning = true;
            menu.financeSubMenu();
            choice = ui.getScanInt();
            switch (choice) {
                case 1:
                    membershipStatistics();
                    break;
                case 2:
                    viewFinances();
                    break;
                case 3:
                    deleteMember();
                    break;
                case 4:
                    addLostFound();
                    break;
                case 5:
                    deleteLostFound();
                    break;
                case 9:
                    ui.displayGreen("Swimming away .....");
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {
                    }
                    ui.displayGreen("Still swimming....");
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {
                    }
                    ui.errorRed("SHARK !!!");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    ui.errorRed("F40");
                    ui.displayGreen("Thanks for Swimming! :D");


                    keepRunning = false;
            }
        } while (keepRunning);
    }

    public void membershipStatistics() {
    }

    public void viewFinances() {
        int youthIncome = finance.youthSubFee(membership);
        int seniorIncome = finance.seniorSubFee(membership);
        int seniorXoIncome = finance.seniorXoSubFee(membership);
        int passiveIncome = finance.passiveSubFee(membership);
        int sum = youthIncome + seniorIncome + seniorXoIncome + passiveIncome;
        ui.displayGreen("Total income from youth subscribers " + youthIncome + " kr");
        ui.displayGreen("Total income from senior subscribers " + seniorIncome + " kr");
        ui.displayGreen("Total income from seniors > 60 subscribers " + seniorXoIncome + " kr");
        ui.displayGreen("Total income from passive subscribers " + passiveIncome + " kr");
        ui.displayGreen("Total income from subscribers " + sum + " kr");
        ui.getPattern(seniorIncome+"kr");



    }

    public void deleteMember() {
        ui.displayGreen("Write name of member: ");
        String firstName = ui.getString();
        ui.displayGreen("Write surname of member: ");
        String surName = ui.getString();
        for (int i = 0; i < membership.allMembers.size(); i++) {
            if (firstName.equals(membership.allMembers.get(i).getFirstName())
                    && (surName.equals(membership.allMembers.get(i).getSurName()))) {
                membership.allMembers.remove(membership.allMembers.get(i));
            } else
                ui.errorRed("No member with that name");
        }
        //Mangler at gemme til fil via filehandler.
    }

    public void coachSubMenu() {
        Menu menu = new Menu();

        int choice;
        boolean keepRunning;

        do {
            keepRunning = true;
            menu.coachSubMenu();
            choice = ui.getScanInt();
            switch (choice) {
                case 1:
                    swimStylesSubMenu();
                    break;
                case 2:
                    showSwimmers();
                    break;
                case 3:
                    addLostFound();
                    break;
                case 4:
                    deleteLostFound();
                    break;
                case 5:
                    break;
                case 9:
                    ui.displayGreen("Saving your high score.....");
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {
                    }
                    ui.displayGreen("Still saving....");
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {
                    }
                    ui.errorRed("System error!");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    ui.errorRed("F40");
                    ui.displayGreen("Sea ya later! :D");


                    keepRunning = false;
            }
        } while (keepRunning);
    }

    public void showSwimmers() {
    }

    public void addLostFound() {
    }

    public void deleteLostFound() {
    }

    public void swimStylesSubMenu() {
        Menu menu = new Menu();

        int choice;
        boolean keepRunning;

        do {
            keepRunning = true;
            menu.swimStylesSubMenu();
            choice = ui.getScanInt();
            switch (choice) {
                case 1:
                    frontCrawl();
                    break;
                case 2:
                    butterfly();
                    break;
                case 3:
                    backstroke();
                    break;
                case 4:
                    breaststroke();
                    break;
                case 5:
                    sidestroke();
                    break;
                case 9:
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
                    ui.errorRed("F40");
                    ui.displayGreen("You should eat your pasta if you want to swim fasta! :D");


                    keepRunning = false;
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

    public void sidestroke() {
    }

}

