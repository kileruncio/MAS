package companies;

public class SmallBuisness extends Company {
    private double income;

    public SmallBuisness(String address, String name) {
        super(address, name);
        this.income = Math.random() * 1000;
    }

    @Override
    public double getProfit() {
        return income * 0.7;
    }

}
