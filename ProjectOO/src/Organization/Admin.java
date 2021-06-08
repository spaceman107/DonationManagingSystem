package Organization;

import Entities.Entity;
import Users.User;

public class Admin extends User {

    private boolean isAdmin;

    public Admin(String name, String phone, boolean isAdmin) {
        super(name, phone);
        this.isAdmin = isAdmin;
    }

    //wrapper methods to give only the admin access
    public void listBeneficiaries(Organization organization) {
        organization.listBeneficiaries();
    }
    public void listDonators(Organization organization) {
        organization.listDonators();
    }
    public void resetBeneficiaryList(Organization organization) {
        organization.resetBeneficiaryList();
    }
    public void removeEntity(Entity e, Organization organization) {
        organization.removeEntity(e);
    }
    public void removeDonator(String phoneNumber, Organization organization) {
        organization.removeDonator(phoneNumber);
    }
    public void removeBeneficiary (String phoneNumber, Organization organization) {
        organization.removeBeneficiary(phoneNumber);
    }
}
