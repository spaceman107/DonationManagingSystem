#include <iostream>
#include <vector>
#include 'Entity.h'

using namespace std;

class RequestDonation
{
public:

Entity getEntity()
{
    return this->Enity
}

double getQuantity()
{
    return this->quantity;
}

void setQuantity(double q)
{
    quantity = q;
}

private:
    Entity entity;
    double quantity = 1;
};



class RequestDonationList
{
public:
    vector<RequestDonation> rdEntities;

    RequestDonation get(int id)
    {
        for (int j = 0; j < rdEntities.size(); j++)
        {
            if (id == i.getEntity().getId())
                return i;
        }
        return null; // TODO exception not found request
    }

    void add(int id, double quantity)
    {
        bool itemFound = false;
        for (int j = 0; j < rdEntities.size(); j++)
        {
            if (id == i.getEntity().getId())
            {
                /*if item already exist the quantity is
                increased by 1 */
                i.setQuantity(i.getQuantity() + quantity);
                itemFound = true;
            }
            if (!itemFound)
            {
                //TODO exception and object creation
                rdEntities.push_back (i);
            }
        }

    }

    void remove(int id)
    {
         for (int j = 0; j < rdEntities.size(); j++)
         {
             if (id == i.getEntity().getId())
             {
                 rdEntities.erase (rdEntities.begin() + rdEntities.at(i));
             }
         }
    }

    void modify(int id, int newQuantity)
    {
        for (int j = 0; j < rdEntities.size(); j++)
        {
            if (id == i.getEntity().getId())
            {
                i.setQuantity(newQuantity);
            }
        }

    }

    void monitor()
    {
       for (int j = 0; j < rdEntities.size(); j++)
       {
           cout << "Entity Name: " << i.getEntity().getName()
           << "Entity id: " << i.getEntity().getId() <<
           " Quantity: " + i.getQuantity()); << endl;
       }
    }

    void reset()
    {
        rdEntities.clear();
    }

    public ArrayList<RequestDonation> getRdEntities() {
        return rdEntities;
    }
    


private:
    int id;
    int newQuantity;

};


