class Material : public virtual Entity {
private:
  double level1;
  double level2;
  double level3;

public:
  Material(string name, string description, int id, double level1,
           double level2, double level3)
      : Entity(name, description, id) {
    this->level1 = level1;
    this->level2 = level2;
    this->level3 = level3;
  }
  string getDetails() {
    string s = "";
    s += "Entities.Material entity: \n";
    s += "One person is entitle to ", this->level1, " entities";
    s += "From 2-4 people, beneficiary is entitle to ", this->level2,
        " entities";
    s += "From 5 people an above, beneficiary is entitle to ", this->level3,
        " entities";

    return s;
  }
};