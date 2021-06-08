package Requests;

import Organization.Organization;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Offers extends RequestDonationList{
    public void commit(Organization organization) {
        for (RequestDonation i:rdEntities) {
            organization.getCurrentDonations().add(i);
        }
        rdEntities.clear();
    }
}
