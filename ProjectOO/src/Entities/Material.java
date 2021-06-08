package Entities;

public class Material extends Entity {

    private double level1;
    private double level2;
    private double level3;

    public Material(String name, String description, int id, double level1, double level2, double level3) {
        super(name, description, id);
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
    }

    //this method is used in the method listEntities
    //of Class Organization to define the type of the entity
    public String getEntityType() {
        return "Material";
    }

    @Override
    public String getDetails() {
        String s = "";
        s += "Entities.Material entity: " + "\n";
        s += "One person is entitle to " + this.level1 + " entities";
        s += "From 2-4 people, beneficiary is entitle to " + this.level2 + " entities";
        s += "From 5 people an above, beneficiary is entitle to " + this.level3 + " entities";

        return s;
    }

    public double getDeservedQuantity(int level) {//return the quantity the beneficiary deserves based on his level
        double deservedQuantity = 0;
        switch (level) {
            case 1:
                deservedQuantity = level1;
                break;
            case 2 :
                deservedQuantity = level2;
                break;
            case 3 :
                deservedQuantity = level3;
                break;
            default:
                System.out.println("Unable to calculate the deserved amount of quantity");
        }
        return deservedQuantity;
    }
}
