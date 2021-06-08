package Entities;

public abstract class Entity {

    private String name = "";
    private String description = "";
    private int id = -1;

    public Entity(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    @Override
    public String toString() {
        String s = "";
        s += "Info: " + getEntityInfo() + " \n";
        s += "Details: " + getDetails();
        return s;
    }

    public String getEntityInfo() {
        return "Name: " + name + "\n" + "Description: " + description + "\n" + "Id: " + id;
    }

    public abstract String getEntityType();
    public  String getDetails() {
        return "Blue";
    }
    public abstract double getDeservedQuantity(int i);//used in class Requests in order to validate a request

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
