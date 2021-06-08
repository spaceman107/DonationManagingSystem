package Users;

import Organization.Organization;
import Requests.Offers;
import Requests.RequestDonation;

public class Donator extends User {

    private Offers offerList = new Offers(); ;

    public Donator(String name, String phone) {
        super(name, phone);

    }
    //wrapper methods
    public void add(RequestDonation r) {
        offerList.add(r);
    }

    public void remove(int id) {
        offerList.remove(id);
    }
    public void monitor() {
        offerList.monitor();
    }
    public void modify(int id, int newQuantity) {
        offerList.modify(id, newQuantity);
    }
    public void reset() {
        offerList.reset();
    }
    public void commit(Organization organization) {
        offerList.commit(organization);
    }

    public Offers getOfferList() {
        return offerList;
    }
}
