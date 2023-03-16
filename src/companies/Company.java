package companies;

public abstract class Company {
    private String address;
    private String name;

    public Company(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public abstract double getIncome();

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }
}
