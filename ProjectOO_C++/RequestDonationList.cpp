#include <Entity>
#include <RequestDonation>
#include <stdio.h>
#include <vector>

using namespace std;
class MyClass
{
public:
    std::vector<RequestDonation> rdEntities;
    string myString;

    RequestDonation get(int id)
    {
        for (int i=0; i<rdEntities.size()l; i++ )
        {
            if (id == rdEntities.at(i).getEntity().getId())
            {
                return i;
            }
        }
        return null;
    }

    void add(int id,double quantity)
    {
        bool itemFound = false;
        for (int i=0; i<rdEntities.size()l; i++  )
        {
            if (id == rdEntities.at(i).getEntity().getId())  //if item already exist the quantity is increased by 1
            {
                rdEntities.at(i).setQuantity(i.getQuantity() + quantity);
                itemFound = true;
            }
        }
        if (!itemFound)   
        {
            RequestDonation *rD = new RequestDonation();

        }
    }
};
