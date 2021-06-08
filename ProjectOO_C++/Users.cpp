#include <iostream>
#include <string>
#include <vector>

using namespace std;

/* forward declarations; XXX must implement */
class Offer;
class Request;
class RequestDonationList;

class User
{
public:
    void setName(string name)
    {
        this->name = name;
    }
    string getName()
    {
        return this->name;
    }

    void setPhone(string phone)
    {
        this->phone = phone;
    }
    string getPhone()
    {
        return this->phone;
    }

private:
    string name;
    string phone;
};


class Admin : public User
{
public:


private:
    bool isAdmin = true;
};

class Donator : public User
{
public:
    void addDonator() {}
    void removeDonator() {}
    void commitDonator() {}

private:
    vector<Offer> offersList;
};

class Beneficiary : public User
{
public:
    void addReceived() {}
    void removeReceived() {}
    void commitReceived() {}

    void addRequest() {}
    void removeRequest() {}
    void commitRequest() {}

private:
    int noPersons = 1;                              // plithos twn beneficiaries
    vector<RequestDonationList> receivedList;       // exei idi lavei
    vector<Request> requestsList;                   // trexousa lista
};