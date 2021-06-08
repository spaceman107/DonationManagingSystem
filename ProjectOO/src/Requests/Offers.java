package Requests;

import Organization.Organization;

public class Offers extends RequestDonationList{
    public void commit(Organization organization) {
        for (RequestDonation i:rdEntities) {
            organization.getCurrentDonations().add(i);
        }
        rdEntities.clear();
    }
}
