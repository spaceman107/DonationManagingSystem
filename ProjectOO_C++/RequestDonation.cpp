#include "Entity.h"

class RequestDonationList {
    double quantity = 1;
    Entity entity;

  public:

    Entity getEntity() {
        return entity;
    }

    double getQuantity() {
        return quantity;
    }

    void setQuantity(double quantity) {
        this->quantity = quantity;
    }
};
