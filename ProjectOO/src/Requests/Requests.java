package Requests;

import Entities.Entity;
import Entities.Service;
import Organization.Organization;
import Users.Beneficiary;

public class Requests extends RequestDonationList {

    public void add(RequestDonation requestDonation, Beneficiary beneficiary){
        if(requestDonation.getQuantity() > 0 && validRequestDonation(requestDonation,beneficiary)) {
            rdEntities.add(requestDonation);
        } else {
            System.out.println("Unable to add: " + requestDonation.getEntity().getName() + ". Try lowering the requested amount.");
        }
    }

    public void modify(int id, double newQuantity){
        super.modify(id,newQuantity);
    }

    public boolean validRequestDonation(RequestDonation requestDonation, Beneficiary beneficiary){
        Entity entity = requestDonation.getEntity();

        if (entity instanceof Service) {
            return true;
        }

        for (RequestDonation i: beneficiary.getReceivedList().getRdEntities()) { //finds the received entity from beneficiary list
            if(i.getEntity().getId() == requestDonation.getEntity().getId()) {
                //adds the requested amount to the received amount
                //and if the amount its greater than the deserved amount false is returned
               if((i.getQuantity() + requestDonation.getQuantity()) > i.getEntity().getDeservedQuantity(beneficiary.levelCalculator())) {
                   return false;
               } else if(((i.getQuantity() + requestDonation.getQuantity()) <= i.getEntity().getDeservedQuantity(beneficiary.levelCalculator())) && ((i.getQuantity() + requestDonation.getQuantity()) > 0)) {
                   return true;
               }
            } else if(i.getQuantity() > i.getEntity().getDeservedQuantity(beneficiary.levelCalculator())){ //if the item is not in the beneficiary list only the current quantity of the request is checked
                return false;
            } else {
                return true;
            }
        }
        //if statements if the Entity is not in the received list
        if((requestDonation.getQuantity()) > requestDonation.getEntity().getDeservedQuantity(beneficiary.levelCalculator())) {
            return false;
        } else if(((requestDonation.getQuantity()) <= requestDonation.getEntity().getDeservedQuantity(beneficiary.levelCalculator())) && ((requestDonation.getQuantity()) > 0)) {
            return true;

        } else if(requestDonation.getQuantity() > requestDonation.getEntity().getDeservedQuantity(beneficiary.levelCalculator())){ //if the item is not in the beneficiary list only the current quantity of the request is checked
            return false;
        }
        return false;
    }

    public void commit(Organization organization){
        for (RequestDonation i : rdEntities) {
            if (organization.getCurrentDonations().get(i.getEntity().getId()).getQuantity() - i.getQuantity() < 0) { //checks if there is sufficient quantity to give
                System.out.println("Unable to commit your request for the " + i.getEntity().getName() + " with id: " + i.getEntity().getId());
                System.out.println("Not enough items");
            } else {
                //using the modify method we give the id of the entity we want to manipulate and set the quantity as the subtraction of the old one minus the requested one
                organization.getCurrentDonations().modify(i.getEntity().getId(),organization.getCurrentDonations().get(i.getEntity().getId()).getQuantity() - i.getQuantity());
                System.out.println("Successfully added "+ i.getEntity().getName() + " with id: " + i.getEntity().getId());
            }
        }
    }

}
