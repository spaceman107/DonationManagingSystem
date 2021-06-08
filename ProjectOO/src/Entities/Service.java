package Entities;

public class Service extends Entity {

    public Service(String name, String description, int id) {
        super(name, description, id);
    }
    public String getEntityType() {
        return "Service";
    }

    @Override
    public String getDetails() {
        return "Entities.Service entity";
    }

    @Override
    public double getDeservedQuantity(int i) { //method is not used
        return -1;
    }
}
