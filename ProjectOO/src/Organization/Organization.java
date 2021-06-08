package Organization;

import Entities.Entity;
import Requests.RequestDonationList;
import Users.Beneficiary;
import Users.Donator;
import Users.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Organization {

    private String name;
    private Admin admin;
    private ArrayList<Entity> entityList = new ArrayList<>();
    private ArrayList<Donator> donatorList = new ArrayList<>();
    private ArrayList<Beneficiary> beneficiaryList = new ArrayList<>();
    private RequestDonationList currentDonations = new RequestDonationList();

    public String loginTest(String phoneNumber) {
        String s = "New User";
        if(admin == null) { //checks if an administrator has been assigned to the organization
            System.out.println("System administrator has not been initialized. " +
                    "Give your name: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            Admin admin = new Admin(name, phoneNumber, true);
            this.admin = admin;
        }
        if(admin.getPhone().equals(phoneNumber)) {

            System.out.println("Welcome " + admin.getName());
            s = "Admin";
        }
        for (Donator i: donatorList) {
            if(i.getPhone().equals(phoneNumber)) {
                System.out.println("Welcome back " + i.getName());
                s = "Donator";
            }
        }
        for (Beneficiary i: beneficiaryList) {
            if(i.getPhone().equals(phoneNumber)) {
                System.out.println("Welcome back " + i.getName());
                s = "Beneficiary";
            }
        }
        return s;
    }
    public User findUser(String phoneNumber) {
        if(admin.getPhone().equals(phoneNumber)) {
            return admin;
        }
        for (Donator i: donatorList) {
            if(i.getPhone().equals(phoneNumber)) {
                return i;
            }
        }
        for (Beneficiary i: beneficiaryList) {
            if(i.getPhone().equals(phoneNumber)) {
                return i;
            }
        }
        return null;
    }
    public Entity entityFind(int id) { //Used in menu in order to create a RequestDonation object so it can be added at User's rdEntities
        for (Entity i : entityList) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public void setAdmin(Admin a) {
        this.admin = a;
    }
    public Admin getAdmin() {
        return this.admin;
    }
    public void addEntity(Entity e) {
        entityList.add(e);
    }
    protected void removeEntity(Entity e) {
        entityList.remove(e);
    }
    public void insertDonator(Donator d) {
        donatorList.add(d);
    }
    public void removeDonator(String phoneNumber) { // Uses collection to iterate through list in order to find and remove the user with the specified phoneNumber
        donatorList.removeIf(d -> d.getPhone().equals(phoneNumber));
    }
    public void insertBeneficiary(Beneficiary b) {
        beneficiaryList.add(b);
    }
    protected void removeBeneficiary (String phoneNumber) { // Uses collection to iterate through list in order to find and remove the user with the specified phoneNumber
        beneficiaryList.removeIf(b -> b.getPhone().equals(phoneNumber));
    }
    public void listEntities(int type) { //give 1 to print the Materials and 2 to print the Services of entityList
        ArrayList<Entity> materialList = new ArrayList<>();
        ArrayList<Entity> serviceList = new ArrayList<>();

        for (Entity i : entityList) {
            if (i.getEntityType().equals("Material")) {
                materialList.add(i);
            }
            if (i.getEntityType().equals("Service")) {
                serviceList.add(i);
            }
        }
        if(type == 1) {
            for (Entity i : materialList) {
                System.out.println(i.getEntityInfo());
                try {
                    System.out.println("Quantity: " + currentDonations.get(i.getId()).getQuantity());
                    System.out.println("=============================================================");
                } catch (NullPointerException e) {
                    System.out.println("Quantity: 0");
                    System.out.println("=============================================================");
                }

            }
        }
        if(type == 2) {
            for (Entity i : serviceList) {
                System.out.println(i.getEntityInfo());
                try {
                    System.out.println("Quantity: " + currentDonations.get(i.getId()).getQuantity());
                    System.out.println("=============================================================");
                } catch (NullPointerException e) {
                    System.out.println("Quantity: 0");
                    System.out.println("=============================================================");
                }

            }
        }
    }

    protected void listBeneficiaries() {
        for (Beneficiary i: beneficiaryList) {
            i.getDetails();
            System.out.println("=============================================================");
        }
    }
    protected void listDonators() {
        for (Donator i: donatorList) {
            i.getDetails();
            System.out.println("=============================================================");
        }
    }
    protected void resetBeneficiaryList() {
        for (Beneficiary i: beneficiaryList) {
            i.getReceivedList().reset();
        }
    }

    public RequestDonationList getCurrentDonations() {
        return currentDonations;
    }

    public ArrayList<Entity> getEntityList() {
        return entityList;
    }
}
