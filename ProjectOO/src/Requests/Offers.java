package Requests;

import Organization.Organization;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Offers extends RequestDonationList{

//    public void commit(RequestDonationList currentDonations, ArrayList<RequestDonation> rdEntities){
//
//        //update currentDonations with the included offers of rdEntities list
//        currentDonations.stream().map((p) -> {
//            return rdEntities.stream().filter(u -> p.equals(u)).findFirst().orElse(p);
//        }).collect(Collectors.toList());
//
//        //if this complete corectly:
//        for (ArrayList<RequestDonation> i: rdEntities){
//            rdEntities.remove(i);
//        }
//    }
    public void commit(Organization organization) {
        for (RequestDonation i:rdEntities) {
//            organization.getCurrentDonations().add(i.getEntity().getId(),i.getQuantity());
            organization.getCurrentDonations().add(i);
        }
        rdEntities.clear();
    }
}
