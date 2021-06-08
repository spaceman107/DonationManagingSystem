#include "Organization"
#include <stdio.h>
#include <vector>


class Offers: public RequestDonationList {
   public:
      void commit(Organization organization) {
        for (int i=0; i<rdEntities.size(); i++  ){
            organization.getCurrentDonations().add(rdEntities.at(i).getEntity().getId(),rdEntities.at(i).getQuantity());
        }
    }
};