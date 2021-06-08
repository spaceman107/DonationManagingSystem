#include <iostream>
#include <vector>
#include "Entity.hpp"
#include "Material.hpp"
#include "RequestDonationList.hpp"
#include "Beneficiary.hpp"
#include "Donator.hpp"
#include "User.hpp"


using namespace std;


class Organization
{
public:
    string loginTest(string phoneNumber)
    {
        string s = "New User";
        if (admin == null)
        {
            cout << "System administrator has not been intialized. " << endl;
            cout << "Give your name: "; << endl;
            cin >> string name;
            Admin administrator(name, phoneNumber, true);
            this->admin = admin;
        }
        if (admin.getPhone() == phoneNumber)
        {
            cout << "Welcome " << admin.getName() << endl;
            s = "Admin";
        }

        for (int j = 0; j < donatorList.size(); j++)
        {
            if (j.getPhone() == phoneNumber)
            {
                cout << "Welcome back " << j.getName() << endl;
                s = "Donator";
            }
        }
        for (int j=0; j < beneficiaryList.size(); j++)
        {
            if (j.getPhone() == phoneNumber)
            {
                cout << "Welcome back " << j.getName() << endl;
                s = "Beneficiary";
            }
        }
        return s;
    }

    User findUser(string phoneNumber)
    {
        if (admin.getPhone() == phoneNumber)
        {
            return admin;
        }
        for (int j = 0; j < donatorList.size(); j++)
        {
            if (j.getphone() == phoneNumber)
            {
                return j;
            }
        }
        for (int j =0; j < beneficiaryList.size(); j++)
        {
            if (j.getPhone() == phoneNumber)
            {
                return j;
            }
        }
        return NULL;  // TODO MUST RETURN SOMETHING
    }

    void setAdmin(Admin a)
    {
        this->admin = a;
    }

    Admin getAmin()
    {
        return admin;
    }

    void addEntity(Entity e)
    {
        entityList.push_back(e);
    }

    protected void removeEntity(Entity e)
    {
        entityList.remove(e);
    }

    void insertDonator(Donator d)
    {
        donatorList.push_back(d);
    }

    protected void removeDonator(Donator d)
    {
        donatorList.remove(d);
    }

    void insertBeneficiary(Beneficiary b)
    {
        beneficiaryList.push_back(d);
    }

    protected void removeBeneficiary(Beneficiary b)
    {
        beneficiaryList.remove(b);
    }


    void listEntities(int type)
    {
        /*give 1 to print the materials and
        2 to print the Services of the entityList */
        vector<Entity> materialList;
        vector<Entity> serviceList;

        for (int j = 0; j < entityList.size(); j++)
        {
            if (j.getEntityType() == "Material")
            {
                materialList.push_back(j);
            }
            if (i.getEntityType() == "Service")
            {
                serviceList.push_back(j);
            }
        }
        if (type == 1)
        {
            for (j = 0; j < materialList.size(); j++)
            {
                cout << j.getEntityInfo(); << endl;
                cout << "Quantity" << currentDonations.get(i.getId()).getQuantity(); << endl;

            }
        }
        if (type == 2)
        {
            for (j = 0; j < serviceList.size(); j++)
            {
                cout << j.getEntityInfo(); << endl;
                cout << "Quantity" << currentDonations.get(i.getId()).getQuantity(); << endl;

            }

        }
    }

    protected void listBeneficiarie()
    {
        for int (j =0; j < beneficiaryList.size(); j++)
        {
            j.getDetails();
        }
    }

    protected void listDonators()
    {
        for (int j =0; j < donatorList.size(); j++)
        {
            j.getDetails();
        }
    }

    protected void redetBeneficiaryList()
    {
        for (int j =0; j < beneficiaryList.size(); j++)
        {
            j.getReceivedList().clear();
        }
    }

    RequestDonationList getCurrentDoantions()
    {
        return currentDonations;
    }

    vector<Entity> getEntitylist()
    {
        return entityList;
    }

private:
    string name;
    Admin admin;
    vector<Entity> entityList;
    vector<Donator> donatorList;
    vector<Beneficiary> beneficiaryList;
    RequestDonationList currentDonations;
};
