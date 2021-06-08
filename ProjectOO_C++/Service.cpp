class Service : public virtual Entity {
public:
  Service(string name, string description, int id)
      : Entity(name, description, id){}

  string getDetails() { return "Entities.Service entity"; }
}
