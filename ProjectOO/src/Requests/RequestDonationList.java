package Requests;

import java.util.ArrayList;

public class RequestDonationList {

    public ArrayList<RequestDonation> rdEntities = new ArrayList<>();


    public RequestDonation get(int id) {
        for (RequestDonation i: rdEntities ){
            if (id == i.getEntity().getId()) {
                return i;
            }
        }
        return null;
    }
    public void add(RequestDonation requestDonation) {
        boolean itemFound = false;
        for (RequestDonation i: rdEntities ){
            if (requestDonation.getEntity().getId() == i.getEntity().getId()) {
                i.setQuantity(i.getQuantity() + requestDonation.getQuantity()); //increase the amount by the amount of the give request donation
                itemFound = true;
            }
        }
        if (!itemFound) {
            rdEntities.add(requestDonation);
        }
    }

    public void remove(int id) { //use collection to remove item from the list
        rdEntities.removeIf(i -> id == i.getEntity().getId());
    }
    public void modify(int id, double newQuantity) {
        for (RequestDonation i: rdEntities ){
            if (id == i.getEntity().getId()) {
                i.setQuantity(newQuantity);
            }
        }
    }
    public void monitor() {
        for (RequestDonation i : rdEntities) {
            System.out.println("Entity Name: " + i.getEntity().getName() + " Entity id: " + i.getEntity().getId() + " Quantity: " + i.getQuantity());
        }
    }
    public void reset() {
        rdEntities.clear();
    }

    public ArrayList<RequestDonation> getRdEntities() {
        return rdEntities;
    }
}
