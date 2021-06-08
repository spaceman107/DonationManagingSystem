package Users;

public abstract class User {
    private String name = "";
    private String phone = "";

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
    public void getDetails() {
        System.out.println("Details");
        System.out.print("Name : " + name +"\n");
        System.out.println("Phone: " + phone);
    }

}
