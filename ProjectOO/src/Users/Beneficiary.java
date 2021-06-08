package Users;

import Entities.Entity;
import Entities.Material;
import Organization.Organization;
import Requests.RequestDonation;
import Requests.RequestDonationList;
import Requests.Requests;


public class Beneficiary extends User {

    private int noPersons = 1;
    private RequestDonationList receivedList = new RequestDonationList();
    private Requests requestList = new Requests();



    public Beneficiary(String name, String phone, int noPersons) {
        super(name, phone);
        this.noPersons = noPersons;
    }

    public int levelCalculator() { //finds the level of the Beneficiary based on the noPersons
        if (noPersons == 1) {
            return 1;
        }
        if (noPersons >= 2 && noPersons <=4) {
            return 2;
        }
        if (noPersons >= 5) {
            return 3;
        } else {
            return -1;
        }
    }
    //wrapper methods
    public void add(RequestDonation r) {
        requestList.add(r,this);
    }
    public void remove(int id) {
        requestList.remove(id);
    }
    public void monitor() {
        requestList.monitor();
    }
    public void modify(int id, int newQuantity) {
        requestList.modify(id, newQuantity);
    }
    public void reset() {
        requestList.reset();
    }
    public void commit(Organization organization) {
        requestList.commit(organization);
    }

    public String getName() {
        return super.getName();
    }

    public int getNoPersons() {
        return noPersons;
    }

    public RequestDonationList getReceivedList() {
        return receivedList;
    }

    public Requests getRequestList() {
        return requestList;
    }
}
