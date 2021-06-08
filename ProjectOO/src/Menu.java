import Entities.Entity;
import Entities.Material;
import Entities.Service;
import Organization.Organization;
import Organization.Admin;
import Requests.RequestDonation;
import Users.Beneficiary;
import Users.Donator;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Organization organization = new Organization();

        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("Nick", "2610",true);
        organization.setAdmin(admin);

        Donator donator1 = new Donator("John","6969");
        Beneficiary beneficiary1 = new Beneficiary("Ben","261069",2);
        Beneficiary beneficiary2 = new Beneficiary("Alice","2610244",5);

        Entity milk = new Material("Milk","Just milk",1,2,5,7);
        Entity sugar = new Material("Sugar","Sweet crystals",2,2,5,7);
        Entity rice = new Material("Rice","Chinese eat it",3,2,5,7);

        Entity lesson1 = new Service("Maths","Addition",4);
        Entity lesson2 = new Service("Physics","Quantum mechanics",5);
        Entity lesson3 = new Service("Biology","Cell multiplication",6);

        organization.addEntity(milk);
        organization.addEntity(sugar);
        organization.addEntity(rice);

        organization.addEntity(lesson1);
        organization.addEntity(lesson2);
        organization.addEntity(lesson3);

        organization.insertDonator(donator1);
        organization.insertBeneficiary(beneficiary1);


        RequestDonation requestDonation = new RequestDonation(milk,50);
        RequestDonation requestDonation1 = new RequestDonation(lesson1,17);


        donator1.add(requestDonation);
        donator1.add(requestDonation1);
        donator1.commit(organization);

        RequestDonation requestDonation3 = new RequestDonation(milk, 2);
        RequestDonation requestDonation4 = new RequestDonation(lesson1,18);

        beneficiary1.add(requestDonation3);
        beneficiary1.add(requestDonation4);
        beneficiary1.commit(organization);

        organization.listEntities(1);
        organization.listEntities(2);
        boolean exitApplication = false;
    while(!exitApplication){
        System.out.println("Please enter you mobile number in order to login or sing up.");

        String phoneNumber = scanner.nextLine();
        String s = "";
        s = organization.loginTest(phoneNumber);

            switch (s) {
                case "Donator" :
                    System.out.println("You have successfully logged in as a donator!");
                    Donator currentUser = (Donator) organization.findUser(phoneNumber);
                    boolean donatorLogout = false;
                    while(!donatorLogout) {

                        System.out.println("What would you like to do?(Give the appropriate number)");
                        System.out.println("1. Add Offer " + "\n" +
                                "2. Show Offers " + "\n" +
                                "3. Commit " + "\n" +
                                "4. Logout " + "\n" +
                                "5. Exit");

                        String donatorMenuSelection = scanner.nextLine();
                        switch (donatorMenuSelection) {
                            case "1":
                                System.out.println("What would you like to offer?(Give the appropriate number)" + "\n" + "1. Material" + "\n" + "2. Service");
                                String typeOfEntity = scanner.nextLine();
                                boolean validInput = false;
                                while (!validInput) {
                                    switch (typeOfEntity) {
                                        case "1":
                                            organization.listEntities(1);
                                            validInput = true;
                                            break;
                                        case "2":
                                            organization.listEntities(2);
                                            validInput = true;
                                            break;
                                        default:
                                            System.out.println("Wrong number. Give 1 to see the list of Materials or 2 to see the Services.");
                                            break;
                                    }
                                }

                                System.out.println("Give the id of entity you want to give:");
                                int itemSelection = scanner.nextInt();
                                try { // checks if the id is valid and print details
                                    organization.entityFind(itemSelection).getDetails();
                                } catch (NullPointerException e) {
                                    System.out.println("No such item found.");
                                    break;
                                }

                                System.out.println("Are you sure you want to add this?(y/n)");

                                scanner.nextLine();

                                String addItemSelection = scanner.nextLine();

                                if (addItemSelection.equals("y")) {
                                    System.out.println("Give the amount you want to donate");
                                    double quantity1 = scanner.nextDouble();
                                    RequestDonation requestDonation2 = new RequestDonation(organization.entityFind(itemSelection),quantity1);
                                    currentUser.add(requestDonation2);
                                    System.out.println("Item successfully added");
                                } else if(addItemSelection.equals("n")) {
                                    break;
                                } else {
                                    System.out.println("Invalid input");
                                }
                                break;
                            case "2":
                                try {
                                    if(currentUser.getOfferList().getRdEntities().size() == 0) {
                                        System.out.println("No items in your list.");
                                        break;
                                    } else {
                                        System.out.println("These are you current offers");
                                        currentUser.monitor();
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("You haven't offer anything yet");
                                    break;
                                }
                                System.out.println("Would you like to edit or delete an offer?(y/n)");
                                String itemEditSelection = scanner.nextLine();
                                if (itemEditSelection.equals("y")) {
                                    System.out.println("Give the id of the entity you want to remove or edit:");
                                    int itemId = scanner.nextInt();
                                    Entity en = organization.entityFind(itemId);
                                    if(en == null){
                                        System.out.println("Wrong id.");
                                        break;
                                    }
                                    System.out.println("Give the number of the action you want to be performed.");
                                    System.out.println("1. Edit" + "\n" + "2. Remove" + "\n" + "3. Remove all");

                                    scanner.nextLine();

                                    String actionSelection = scanner.nextLine();
                                    boolean validInput2 = false;
                                    while (!validInput2) {
                                        switch (actionSelection) {
                                            case "1":
                                                System.out.println("Give the new quantity of the Offer:");
                                                int offerQuantity = scanner.nextInt();
                                                currentUser.modify(itemId, offerQuantity);
                                                System.out.println("Would you like to commit the changes?(y/n)");
                                                scanner.nextLine();
                                                String commitEdit = scanner.nextLine();
                                                if (commitEdit.equals("y")) {
                                                    currentUser.commit(organization);
                                                    System.out.println("Successfully committed changes.");
                                                }
                                                validInput2 = true;
                                                break;
                                            case "2":
                                                System.out.println("Are you sure you want to remove this?(y/n)");
                                                String removeSelection = scanner.nextLine();
                                                if (removeSelection.equals("y")) {
                                                    currentUser.remove(itemId);
                                                }
                                                System.out.println("Would you like to commit the changes?(y/n)");
                                                String commitRemove = scanner.nextLine();
                                                if (commitRemove.equals("y")) {
                                                    currentUser.commit(organization);
                                                    System.out.println("Successfully committed changes.");
                                                }
                                                validInput2 = true;
                                                break;
                                            case "3":
                                                System.out.println("Are you sure you want to remove everything from the list?(y/n)");
                                                String removeAll = scanner.nextLine();
                                                if (removeAll.equals("y")) {
                                                    currentUser.reset();
                                                }
                                                System.out.println("Would you like to commit the changes?(y/n)");
                                                String commitRemoveAll = scanner.nextLine();
                                                if (commitRemoveAll.equals("y")) {
                                                    currentUser.commit(organization);
                                                    System.out.println("Successfully committed changes.");
                                                }
                                                validInput2 = true;
                                                break;
                                            default:
                                                System.out.println("Invalid combination, please try again.");
                                                validInput2 = true;
                                                break;
                                        }
                                    }
                                }
                                break;
                            case "3":
                                currentUser.commit(organization);
                                System.out.println("Successfully committed changes");
                                break;
                            case "4":
                                System.out.println("Logging out user...");
                                donatorLogout = true;
                                break;
                            case "5":
                                System.out.println("Exiting application...");
                                donatorLogout = true;
                                exitApplication = true;
                                break;
                            default:
                                System.out.println("Invalid input!");
                                break;
                        }
                    }
                    break;
                case "Beneficiary" :
                    System.out.println("You have successfully logged in as a beneficiary");

                    Beneficiary currentBeneficiary = (Beneficiary) organization.findUser(phoneNumber);
                    boolean beneficiaryLogOut = false;
                    while (!beneficiaryLogOut) {
                        System.out.println("What would you like to do?");
                        System.out.println("1. Add Request " +
                                "2. Show Requests " +
                                "3. Commit " +
                                "4. Logout " +
                                "5. Exit ");
                        String beneficiaryMenuSelection = scanner.nextLine();
                        switch (beneficiaryMenuSelection) {
                            case "1":
                                System.out.println("What would you like to Request?(Give the appropriate number)" + "\n" + "1. Material" + "\n" + "2. Service");
                                String typeOfEntity = scanner.nextLine();
                                boolean validInput = false;
                                while (!validInput) {
                                    switch (typeOfEntity) {
                                        case "1":
                                            organization.listEntities(1);
                                            validInput = true;
                                            break;
                                        case "2":
                                            organization.listEntities(2);
                                            validInput = true;
                                            break;
                                        default:
                                            System.out.println("Wrong number. Give 1 to see the list of Materials or 2 to see the Services.");
                                            break;
                                    }
                                }

                                System.out.println("Give the id of entity you want to receive:");
                                int itemSelection = scanner.nextInt();
                                try { // checks if the id is valid and print details
                                    organization.entityFind(itemSelection).getDetails();
                                } catch (NullPointerException e) {
                                    System.out.println("No such item found.");
                                    break;
                                }

                                System.out.println("Are you sure you want to add this to your receive list?(y/n)");
                                scanner.nextLine();
                                String addItemSelection = scanner.nextLine();

                                if (addItemSelection.equals("y")) {
                                    System.out.println("Give the quantity of the item:");
                                    double quantity = scanner.nextDouble();
                                    RequestDonation requestDonation2 = new RequestDonation(organization.entityFind(itemSelection),quantity);
                                    try {
                                        currentBeneficiary.add(requestDonation2);
                                    } catch (NullPointerException e) {
                                        System.out.println("No such item found.");
                                    }
                                } else if(addItemSelection.equals("n")) {
                                    break;
                                } else {
                                    System.out.println("Invalid input");
                                }
                                break;
                            case "2":
                                System.out.println("These are you current requests");
                                currentBeneficiary.monitor();
                                System.out.println("Would you like to edit or delete a request?(y/n)");
                                String itemEditSelection = scanner.nextLine();
                                if (itemEditSelection.equals("y")) {
                                    System.out.println("Give the id of the entity you want to remove or edit:");
                                    int itemId = scanner.nextInt();
                                    System.out.println("1.Edit" + "\n" + "2. Remove" + "\n" + "3. Remove all");
                                    scanner.nextLine();
                                    System.out.println("Give the number of the action you want to be performed.");
                                    String actionSelection = scanner.nextLine();
                                    boolean validInput2 = false;
                                    while (!validInput2) {
                                        switch (actionSelection) {
                                            case "1":
                                                System.out.println("Give the new quantity of the request:");
                                                int offerQuantity = scanner.nextInt();
                                                currentBeneficiary.modify(itemId, offerQuantity);
                                                System.out.println("Would you like to commit the changes?(y/n)");
                                                scanner.nextLine();
                                                String commitEdit = scanner.nextLine();
                                                if (commitEdit.equals("y")) {
                                                    currentBeneficiary.commit(organization);
                                                    System.out.println("Successfully committed changes.");
                                                }
                                                validInput2 = true;
                                                break;
                                            case "2":
                                                System.out.println("Are you sure you want to remove this?(y/n)");
                                                String removeSelection = scanner.nextLine();
                                                if (removeSelection.equals("y")) {
                                                    currentBeneficiary.remove(itemId);
                                                }
                                                System.out.println("Would you like to commit the changes?(y/n)");
                                                String commitRemove = scanner.nextLine();
                                                if (commitRemove.equals("y")) {
                                                    currentBeneficiary.commit(organization);
                                                    System.out.println("Successfully committed changes.");
                                                }
                                                validInput2 = true;
                                                break;
                                            case "3":
                                                System.out.println("Are you sure you want to remove everything from the list?(y/n)");
                                                String removeAll = scanner.nextLine();
                                                if (removeAll.equals("y")) {
                                                    currentBeneficiary.reset();
                                                }
                                                System.out.println("Would you like to commit the changes?(y/n)");
                                                String commitRemoveAll = scanner.nextLine();
                                                if (commitRemoveAll.equals("y")) {
                                                    currentBeneficiary.commit(organization);
                                                    System.out.println("Successfully committed changes.");
                                                }
                                                validInput2 = true;
                                                break;
                                            default:
                                                System.out.println("Invalid combination, please try again.");
                                                validInput2 = true;
                                                break;
                                        }
                                    }
                                }
                                break;
                            case "3":
                                currentBeneficiary.commit(organization);
                                System.out.println("Successfully committed changes");
                                break;
                            case "4":
                                System.out.println("Logging out user...");
                                beneficiaryLogOut = true;
                                break;
                            case "5":
                                System.out.println("Exiting application...");
                                beneficiaryLogOut = true;
                                exitApplication = true;
                                break;
                            default:
                                System.out.println("Invalid input!");

                        }
                    }
                    break;
                case "Admin" :
                    System.out.println("You have successfully logged in as a admin");
                    System.out.println("1. View"+ "\n" +
                            "2. Monitor Organization"+ "\n" +
                            "3. Commit"+ "\n" +
                            "4. Logout"+ "\n" +
                            "5. Exit");
                    String selection5 = scanner.nextLine();
                    switch (selection5) {
                        case "1":
                            System.out.println("What would you like to View?(Give the appropriate number)" + "\n" + "1. Material" + "\n" + "2. Service");
                                String typeOfEntity = scanner.nextLine();
                                boolean validInput = false;
                                while (!validInput) {
                                    switch (typeOfEntity) {
                                        case "1":
                                            organization.listEntities(1);
                                            validInput = true;
                                            break;
                                        case "2":
                                            organization.listEntities(2);
                                            validInput = true;
                                            break;
                                        default:
                                            System.out.println("Wrong number. Give 1 to see the list of Materials or 2 to see the Services.");
                                            break;
                                    }
                                }
                            break;
                        case "2":
                            System.out.println("Available actions:" + "\n" + "1. List Beneficiaries" +
                                    "2. List Donators" +
                                    "3. Reset Beneficiaries Lists");

                            String adminSelectionMenu = scanner.nextLine();
                            boolean validInput2 = false;
                            while (!validInput2) {
                                switch (adminSelectionMenu) {
                                    case "1":
                                        admin.listBeneficiaries(organization);
                                        System.out.println("Would you like to remove a beneficiary from the organization?(y/n)");
                                        String removeBeneficiary = scanner.nextLine();
                                        if (removeBeneficiary.equals("y")) {
                                            System.out.println("Give the phoneNumber of the beneficiary you want to remove: ");
                                            String phone = scanner.nextLine();
                                            admin.removeBeneficiary(phone,organization);
                                            System.out.println("User successfully removed.");
                                        }
                                        validInput2 = true;
                                        break;
                                    case "2":
                                        admin.listDonators(organization);
                                        System.out.println("Would you like to remove a donator from the organization?(y/n)");
                                        String removeDonator = scanner.nextLine();
                                        if (removeDonator.equals("y")) {
                                            System.out.println("Give the phoneNumber of the donator you want to remove: ");
                                            String phone = scanner.nextLine();
                                            admin.removeDonator(phone,organization);
                                            System.out.println("User successfully removed.");
                                        }
                                        validInput2 = true;
                                        break;
                                    case "3" :
                                        admin.resetBeneficiaryList(organization);
                                        validInput2 = true;
                                        break;
                                    default:
                                        System.out.println("Wrong number. Give 1 to see the list of Materials or 2 to see the Services.");
                                        break;
                                }
                            }
                            break;
                        case "3":
                            System.out.println("Logging out user...");
                            break;
                        case "4":
                            System.out.println("Exiting application...");
                            exitApplication = true;
                            break;
                        default:
                            System.out.println("System Error!");
                            break;
                    }
                        break;
                case "New User" :
                    System.out.println("Unable to find an account bound to the given " +
                            "phone number. Please create a new account");
                    System.out.println("Press 1 if you want a donator account.");
                    System.out.println("Press 2 if you want a beneficiary account.");
                    System.out.println("Press 3 to exit");
                    int account = scanner.nextInt();

                    if (account == 1)  {
                        System.out.println("Give your name in order to complete your account creation");
                        scanner.nextLine();
                        String name = scanner.nextLine();

                        Donator donator = new Donator(name,phoneNumber);
                        organization.insertDonator(donator);
                        System.out.println("Your account has been created!");
                    }
                    if (account == 2)  {
                        System.out.println("Give your name: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        System.out.println("Give the number of people in your family in order to complete your account creation: ");
                        int noPersons = scanner.nextInt();

                        Beneficiary beneficiary = new Beneficiary(name,phoneNumber,noPersons);
                        organization.insertBeneficiary(beneficiary);
                        System.out.println("Your account has been created!");
                    }
                    if (account == 3) {
                        System.out.println("Exiting application...");
                        exitApplication = true;
                        break;
                    }
                    break;
                default:
                    System.out.println("System Error!");
                    break;
            }
        }
    }
}
