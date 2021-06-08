#include <iostream>
#include <string>

using namespace std;

class Entity { // The class
private:       // Access specifier
  string name = "";
  string description = "";
  int id = -1;
  string name = "";
  string description = "";
  int id = -1;

public:
  Entity(string name, string description, int id) {
    this->name = name;
    this->description = description;
    this->id = id;
  }
  virtual string getDetails();
  int getId() { return id; }

  string getName() { return name; }
};